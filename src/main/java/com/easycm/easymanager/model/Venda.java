package com.easycm.easymanager.model;

import java.util.List;

public class Venda {
    private int id;
    private String cliente;
    private String descricaoServico;
    private double valorTotal;
    private List<Material> materiais;  // Lista de materiais usados na venda

    public Venda(int id, String cliente, String descricaoServico, double valorTotal, List<Material> materiais) {
        this.id = id;
        this.cliente = cliente;
        this.descricaoServico = descricaoServico;
        this.valorTotal = valorTotal;
        this.materiais = materiais;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getCliente() {
        return cliente;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public List<Material> getMateriais() {
        return materiais;
    }
}
