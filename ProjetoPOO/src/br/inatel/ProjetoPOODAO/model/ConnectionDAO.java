package br.inatel.ProjetoPOODAO.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.inatel.ProjetoPOO.controller.Carro;
import br.inatel.ProjetoPOO.view.Tela;

/**
 *
 * @author PICHAU
 */
public class ConnectionDAO {
    
        // objeto responsável pela conexão com o servidor do banco de dados
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
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        }
    }
    
    /************************ INSERIR DADOS *********************************/
    public boolean inserirUsuario(Carro novoUsuario) 
    {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO carro (ano,modelo,marca,acessorios,tabela,chave_id) values (?,?,?,?,?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try 
        {
            pst = con.prepareStatement(sql);
            pst.setInt(1, novoUsuario.getAno()); //1- refere-se à primeira interrogação
            System.out.println("Inseriu 1");
            pst.setString(2, novoUsuario.getModelo());  //2- refere-se à segunda interrogação
            System.out.println("Inseriu 2");
            pst.setString(3, novoUsuario.getMarca());  //2- refere-se à segunda interrogação
            System.out.println("Inseriu 3");
            pst.setInt(4, novoUsuario.getQntAce());  //2- refere-se à segunda interrogação
            System.out.println("Inseriu 4");
            pst.setFloat(5, novoUsuario.getFipe());  //2- refere-se à segunda interrogação
            System.out.println("Inseriu 5");
            pst.setInt(6, novoUsuario.getChaveid());  //2- refere-se à segunda interrogação
            System.out.println("Inseriu 6");
            
            
                                                       //e assim por diante....
            pst.execute();
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {   //Encerra a conexão
                con.close();
                pst.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }

    
    /************************ BUSCAR DADOS *********************************/
    
    public ArrayList<Carro> buscarUsuariosSemFiltro() 
    {
        ArrayList<Carro> listaDeUsuarios = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM carro";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try 
        {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            System.out.println("Lista de carro: ");
            while(rs.next())
            {
                //System.out.println(rs.getString("nome"));
                Carro usuarioTemp = new Carro(rs.getInt("ano"),rs.getString("modelo"), rs.getInt("id"), rs.getString("marca"), rs.getInt("acessorios"), rs.getFloat("tabela"), rs.getInt("chave_id"));
                System.out.println("Ano = "+usuarioTemp.getAno());
                System.out.println("Modelo = "+usuarioTemp.getModelo());
                System.out.println("ID = "+usuarioTemp.getId());
                System.out.println("Marca = "+usuarioTemp.getMarca());
                System.out.println("Acessorios = "+usuarioTemp.getQntAce());
                System.out.println("Tabela Fipe = "+usuarioTemp.getFipe());
                System.out.println("Chave ID = "+usuarioTemp.getChaveid());
                System.out.println("---------------------------------");
                listaDeUsuarios.add(usuarioTemp);
            }
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {
                con.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return listaDeUsuarios;
    }
    
    /************************ ATUALIZAR DADOS *********************************/
    
    public boolean atualizarNomeUsuario(String modelo, float novaFipe) 
    {
        connectToDb();
        //Comando em SQL
        String sql = "UPDATE carro SET tabela=? WHERE modelo=?";
        
         //O comando recebe paramêtros -> consulta dinâmica (pst)
        try 
        {
            pst = con.prepareStatement(sql);
            pst.setFloat(1, novaFipe);
            pst.setString(2, modelo);
            pst.execute();
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {
                con.close();
                pst.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Erro = " + ex.getMessage());
            }

        }
        return sucesso;
    }
    
    /************************ DELETAR REGISTROS *******************************/
    
    public boolean deletarUsuario(int id) 
    {
        connectToDb();
        //Comando em SQL:
        String sql = "DELETE FROM carro WHERE id=?";
        try 
        {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {
                con.close();
                pst.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }

}