package com.easycm.easymanager.model;

import java.util.ArrayList;
import java.util.List;

public class DatabaseMock {
    private List<Venda> vendas;          // Lista de vendas
    private List<Funcionario> funcionarios;  // Lista de funcionários (opcional, conforme evolução do projeto)

    public DatabaseMock() {
        this.vendas = new ArrayList<>();        // Inicializa a lista de vendas
        this.funcionarios = new ArrayList<>();  // Inicializa a lista de funcionários
    }

    // Métodos para vendas
    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    // Métodos para funcionários (se necessário)
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
