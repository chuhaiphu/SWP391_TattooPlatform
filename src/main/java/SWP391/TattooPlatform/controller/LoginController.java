package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.model.Admin;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
@RestController
@RequestMapping("/login")

public class LoginController {
    final AdminService adminService;

    public LoginController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping()
    public String loadLoginHtml() throws IOException {
        // Load the HTML file as a string
        Resource resource = new ClassPathResource("static/login.html");
        String htmlContent = new String(Files.readAllBytes(Paths.get(resource.getURI())));

        return htmlContent;
    }

    @PostMapping()
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) throws IOException {
        try {
            Admin admin = adminService.getAdminFromJsonFile();
            if ("user@example.com".equals(email) && "userpassword".equals(password)) {
                return ResponseEntity.ok("UserLogin");
            } else if (admin.getAdminEmail().equals(email) && admin.getPassword().equals(password)) {
                // Admin login successful
                return ResponseEntity.ok("AdminLogin");
            } else {
                // Invalid credentials

                throw new IOException("Invalid credentials");
            }
        }catch (IOException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

