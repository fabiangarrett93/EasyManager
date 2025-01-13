package com.easycm.easymanager.controller;

import org.springframework.web.bind.annotation.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
public class LoginController {

    @PostMapping("/login")
    public Map<String, String> login(@RequestParam String username, @RequestParam String password) throws IOException {
        String filePath = Paths.get("C:", "Users", "fabia", "OneDrive", "Área de Trabalho", "easymanager",
                "easymanager", "src", "main", "resources", "templates", "users.txt").toString();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        Map<String, String> response = new HashMap<>();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",\\s*");
            if (parts.length == 3) {
                String fileUser = parts[0].trim();
                String filePass = parts[1].trim();
                String userType = parts[2].trim();

                if (fileUser.equals(username) && filePass.equals(password)) {
                    response.put("status", "success");
                    response.put("userType", userType);
                    return response;
                }
            }
        }
        response.put("status", "error");
        response.put("message", "Credenciais invalidas!");
        return response;
    }
}
