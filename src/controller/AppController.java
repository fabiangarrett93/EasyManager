package com.easycm.easymanager.controller;

import com.easycm.easymanager.model.Material;
import com.easycm.easymanager.model.Venda;
import com.easycm.easymanager.service.VendaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class AppController {

    private final VendaService vendaService;

    public AppController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    // Página inicial
    @GetMapping("/")
    public String index() {
        return "index";  // Retorna o arquivo index.html
    }

    // Página de registrar venda
    @GetMapping("/registrar-venda")
    public String exibirFormVenda(Model model) {
        model.addAttribute("mensagemErro", null);
        return "venda-form";  // Retorna a página com o formulário de venda
    }

    // Processar venda
    @PostMapping("/registrar-venda")
    public String registrarVenda(
            @RequestParam("cliente") String cliente,
            @RequestParam("descricao") String descricao,
            @RequestParam("valorTotal") double valorTotal,
            @RequestParam("nomeMaterial") String nomeMaterial,
            @RequestParam("quantidade") int quantidade,
            @RequestParam("precoUnitario") double precoUnitario,
            Model model
    ) {
        // Validações
        if (cliente.isBlank() || descricao.isBlank()) {
            model.addAttribute("erro", "O nome do cliente e a descrição do serviço não podem estar vazios.");
            return "venda-form";
        }
        if (valorTotal <= 0 || quantidade <= 0 || precoUnitario <= 0) {
            model.addAttribute("erro", "Os valores de venda, quantidade e preço unitário devem ser maiores que zero.");
            return "venda-form";
        }

        // Criando material e venda
        Material material = new Material(nomeMaterial, quantidade, precoUnitario);
        Venda venda = new Venda(1, cliente, descricao, valorTotal, Arrays.asList(material));

        // Salvando venda no "banco de dados"
        vendaService.adicionarVenda(venda);

        // Adicionando informações para a página de sucesso
        model.addAttribute("mensagem", "Venda registrada com sucesso!");
        model.addAttribute("venda", venda);
        return "venda-sucesso";  // Página de sucesso
    }

    // Página de relatório de vendas
    @GetMapping("/relatorio")
    public String gerarRelatorio(Model model) {
        List<Venda> vendas = vendaService.getVendas();
        if (vendas.isEmpty()) {
            model.addAttribute("mensagemErro", "Nenhuma venda foi registrada até o momento.");
        } else {
            model.addAttribute("vendas", vendas);
        }
        return "relatorio";  // Página relatorio.html
    }

    // Página de login
    @GetMapping("/login")
    public String loginPage() {
        return "login";  // Página de login (login.html)
    }

    // Página de dashboard após login
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";  // Deve retornar o nome do arquivo Thymeleaf sem extensão
    }

    // Página de logout (opcional)
    @GetMapping("/logout")
    public String logoutPage() {
        return "logout";  // Página de logout (logout.html)
    }
}
