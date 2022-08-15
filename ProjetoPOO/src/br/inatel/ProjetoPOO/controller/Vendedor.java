/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.ProjetoPOO.controller;

/**
 *
 * @author Usuario
 */
public class Vendedor {
    private String nome;
    private String cpf;
    private String registro;
    
    public Vendedor(String nome, String cpf, String registro){
        this.nome = nome;
        this.cpf = cpf;
        this.registro = registro;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
    
    public String getRegistro() {
        return registro;
    }
}
