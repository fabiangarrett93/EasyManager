package com.easycm.easymanager.model;


import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    private int id;
    private String nome;
    private List<Venda> vendas;

    public Vendedor(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.vendas = new ArrayList<>();
    }

    public void registrarVenda(Venda venda) {
        vendas.add(venda);
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public String getNome() {
        return nome;
    }
}
