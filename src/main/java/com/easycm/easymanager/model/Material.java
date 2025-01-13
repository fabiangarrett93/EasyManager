package com.easycm.easymanager.model;

public class Material {
    private String nome;
    private int quantidade;
    private double preco;

    // Construtor correto
    public Material(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public double calcularCusto() {
        return quantidade * preco;
    }

    // Getters e Setters
}
