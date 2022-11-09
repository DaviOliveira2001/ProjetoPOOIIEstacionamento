/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author odavi
 */
public class ProprietarioDAO {
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    
    public boolean conectar(){
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost: 3306/bancoEs", "root", "");
            
            return true;
            
        } catch (ClassNotFoundException |SQLException ex) {
            return false;
        }
    }
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
           
        }
    }
    public int salvar(Proprietario pr){
        int status;
        
       try {
           st = conn.prepareStatement("INSERT INTO proprietario VALUES(?, ?, ?, ?)");
           st.setString(1, pr.getNome());
           st.setString(2, pr.getEndereco());
           st.setString(3, pr.getTelefone());
           st.setString(4, pr.getCpf_cnpj());
            System.out.println(st);
            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            return ex.getErrorCode();
        }
    }
    public Proprietario consultar (String nome){
         
        try {
            Proprietario proprietario = new Proprietario();
            st = conn.prepareStatement("SELECT * from proprietario WHERE nome = ?");
            st.setString(1, nome);
            rs = st.executeQuery();
            //verificar se a consulta encontrou o funcionário com a matricula informada
            if(rs.next()){ // se encontrou o funcionário, vamos carregar os dados
                proprietario.setNome(rs.getString("nome"));
                proprietario.setEndereco(rs.getString("endereco"));
                proprietario.setTelefone(rs.getString("telefone"));
                proprietario.setCpf_cnpj(rs.getString("cpf/cnpj"));
                return proprietario;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public boolean excluir (String nome){
        try {
            st = conn.prepareStatement("DELETE FROM proprietario WHERE nome = ?");
            st.setString(1, nome);
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public int atualizar(Proprietario pr){
        int status;
        
        try {
            st = conn.prepareStatement("UPDATE proprietario SET nome = ?, endereco = ?, telefone = ?, cpf/cnpj = ?");
            st.setString(1, pr.getNome());
            st.setString(2, pr.getEndereco());
            st.setString(3, pr.getTelefone());
            st.setString(4, pr.getCpf_cnpj());
            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            return ex.getErrorCode();
        }
    }
}
