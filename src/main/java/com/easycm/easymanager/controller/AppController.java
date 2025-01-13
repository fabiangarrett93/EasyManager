package com.easycm.easymanager.controller;

import com.easycm.easymanager.model.Material;
import com.easycm.easymanager.model.Venda;
import com.easycm.easymanager.service.VendaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    private final VendaService vendaService = new VendaService();

    // Página inicial (login)
    @GetMapping("/login")
    public String loginPage() {
        return "login";  // Retorna o template "login.html"
    }

    // Página de logout
    @GetMapping("/logout")
    public String logoutPage() {
        return "logout";  // Retorna o template "logout.html"
    }

    // Página de registro de venda
    @GetMapping("/venda")
    public String registrarVendaForm() {
        return "venda-form";  // Retorna um formulário de venda
    }

    @PostMapping("/venda")
    public String registrarVenda(
            @RequestParam("cliente") String cliente,
            @RequestParam("descricao") String descricao,
            @RequestParam("valorTotal") double valorTotal,
            @RequestParam("nomeMaterial") String nomeMaterial,
            @RequestParam("quantidade") int quantidade,
            @RequestParam("precoUnitario") double precoUnitario,
            Model model
    ) {
        if (cliente.isEmpty() || descricao.isEmpty() || valorTotal <= 0) {
            model.addAttribute("erro", "Preencha todos os campos corretamente.");
            return "venda-form";
        }

        Material material = new Material(nomeMaterial, quantidade, precoUnitario);
        List<Material> materiais = new ArrayList<>();
        materiais.add(material);
        Venda venda = new Venda(1, cliente, descricao, valorTotal, materiais);

        vendaService.adicionarVenda(venda);

        model.addAttribute("mensagem", "Venda registrada com sucesso!");
        model.addAttribute("venda", venda);
        return "venda-sucesso";  // Exibe os detalhes da venda registrada
    }

    // Página de relatório
    @GetMapping("/relatorio")
    public String gerarRelatorio(Model model) {
        List<Venda> vendas = vendaService.getVendas();
        model.addAttribute("vendas", vendas);
        return "relatorio";  // Exibe a página de relatório com as vendas
    }
}
