package com.easycm.easymanager.service;

import com.easycm.easymanager.model.DatabaseMock;
import com.easycm.easymanager.model.Venda;

import java.util.List;

public class VendaService {
    private DatabaseMock database;

    public VendaService() {
        this.database = new DatabaseMock();  // Inicializa o banco de dados em memória
    }

    public void adicionarVenda(Venda venda) {
        database.adicionarVenda(venda);
        System.out.println("Venda registrada no banco de dados.");
    }

    public List<Venda> getVendas() {
        return database.getVendas();
    }
}
