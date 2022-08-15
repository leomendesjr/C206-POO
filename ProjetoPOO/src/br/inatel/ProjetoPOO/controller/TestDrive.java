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
public class TestDrive {
    private String cpf;
    private int id;
    
    public TestDrive(String cpf, int id){
        this.cpf = cpf;
        this.id = id;        
    }

    public String getCpf() {
        return cpf;
    }

    public int getId() {
        return id;
    }
            
    
}
