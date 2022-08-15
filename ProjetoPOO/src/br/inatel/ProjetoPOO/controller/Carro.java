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
public class Carro {
    private int id;
    private String nomeVend;
    private String modelo;
    private String marca;
    private int qntAce;
    private float fipe;
    private int ano;
    private int chaveid;

    public Carro(int ano, String modelo, int id, String marca, int qntAce, float fipe, int chaveid){
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.qntAce = qntAce;
        this.fipe = fipe;
        this.ano = ano; 
        this.chaveid = chaveid;
    }

    public String getNomeVend() {
        return nomeVend;
    }

    public String getModelo() {
        return modelo;
    }

    public int getQntAce() {
        return qntAce;
    }

    public float getFipe() {
        return fipe;
    }

    public int getAno() {
        return ano;
    }
    
    public String getMarca() {
        return marca;
    }

    public int getChaveid() {
        return chaveid;
    }

    public int getId() {
        return id;
    }
    
}
