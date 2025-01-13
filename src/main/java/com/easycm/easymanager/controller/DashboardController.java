package com.easycm.easymanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("mensagem", "Bem-vindo à Dashboard!");
        return "dashboard";  // Retorna o arquivo dashboard.html em "resources/templates/"
    }
}
