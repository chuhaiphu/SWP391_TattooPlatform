package SWP391.TattooPlatform.controller;

import SWP391.TattooPlatform.model.Admin;
import SWP391.TattooPlatform.service.LoginService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
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
    final LoginService loginService;

    public LoginController(AdminService adminService, LoginService loginService) {
        this.adminService = adminService;
        this.loginService = loginService;
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
            if (admin.getAdminEmail().equals(email) && admin.getPassword().equals(password)) {
                // Admin login successful
                return ResponseEntity.ok("AdminLogin");
            }
            return loginService.login(email, password);
        }catch (IOException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can not find any account");
        }
    }
}
