package com.easycm.easymanager.model;

public class Funcionario {
    private Long id;
    private String nome;
    private String cargo;
    private String senha;

    // Construtor padrão (necessário para frameworks como Spring Boot)
    public Funcionario() {
    }

    // Construtor com parâmetros
    public Funcionario(Long id, String nome, String cargo, String senha) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.senha = senha;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Método toString() para facilitar a exibição das informações do funcionário
    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
