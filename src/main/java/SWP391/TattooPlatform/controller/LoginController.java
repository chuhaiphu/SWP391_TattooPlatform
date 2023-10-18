package SWP391.TattooPlatform.controller;

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

    @GetMapping()
    public String loadLoginHtml() throws IOException {
        // Load the HTML file as a string
        Resource resource = new ClassPathResource("static/login.html");
        String htmlContent = new String(Files.readAllBytes(Paths.get(resource.getURI())));

        return htmlContent;
    }

    @PostMapping()
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        if ("user@example.com".equals(email) && "userpassword".equals(password)) {
            return ResponseEntity.ok("UserLogin");
        } else if ("admin@example.com".equals(email) && "adminpassword".equals(password)) {
            // Admin login successful
            return ResponseEntity.ok("AdminLogin");
        } else {
            // Invalid credentials
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }
}

