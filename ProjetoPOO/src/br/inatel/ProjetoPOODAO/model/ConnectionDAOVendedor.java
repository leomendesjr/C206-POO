/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.ProjetoPOODAO.model;

import br.inatel.ProjetoPOO.controller.Vendedor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class ConnectionDAOVendedor {
        Connection con;
    // objeto responsável por preparar as consultas dinâmicas
    PreparedStatement pst;
    // objeto responsável por executar as consultas estáticas
    Statement st;
    // objeto responsável por referenciar a tabela resultante da busca
    ResultSet rs;

    boolean sucesso = false;

    String database = "ProjetoPOO";
    String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    String user = "root";
    String password = "root";

    public void connectToDb() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão deu certo!");
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        }
    }
    
    public boolean inserirUsuario(Vendedor novoUsuario) {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO vendedor (nome,cpf,registro) values (?,?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, novoUsuario.getNome()); //1- refere-se à primeira interrogação
            System.out.println("Inseriu 1");
            pst.setString(2, novoUsuario.getCpf());  //2- refere-se à segunda interrogação
            System.out.println("Inseriu 2");
            pst.setString(3, novoUsuario.getRegistro());  //2- refere-se à segunda interrogação
            System.out.println("Inseriu 3");
            
            //e assim por diante....
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {   //Encerra a conexão
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
}
