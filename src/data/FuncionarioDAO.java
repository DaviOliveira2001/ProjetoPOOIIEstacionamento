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
public class FuncionarioDAO {
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
    public int salvar(Funcionario fn){
        int status;
        
       try {
           st = conn.prepareStatement("INSERT INTO funcionario VALUES(?, ?, ?, ?)");
           st.setString(1, fn.getNome());
           st.setString(2, fn.getEndereco());
           st.setString(3, fn.getTelefone());
           st.setString(4, fn.getTurno());
            System.out.println(st);
            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            return ex.getErrorCode();
        }
    }
    public boolean excluir(String nome){
        try {
            st = conn.prepareStatement("DELETE FROM funcionario WHERE nome = ?");
            st.setString(1, nome);

            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }    
    }
    public int atualizar(Funcionario func){
        int status;
        try{
            st = conn.prepareStatement("UPDATE FROM funcionario SET nome = ?, endereco = ?, telefone = ?, turno = ?");
            st.setString(1, func.getNome());
            st.setString(2, func.getEndereco());
            st.setString(3, func.getTelefone());
            st.setString(4, func.getTurno());
            status = st.executeUpdate();
            return status;
        }catch (SQLException ex){
            System.out.println(ex.getErrorCode());
            return ex.getErrorCode();
        }
    }
    public Funcionario consultar(String nome){
       
        try {
             Funcionario func = new Funcionario();
            st = conn.prepareStatement("SELECT * from funcionario WHERE nome = ?");
            st.setString(1, nome);
            rs = st.executeQuery();
            
            if(rs.next()){
            func.setNome(rs.getString("nome"));
            func.setEndereco(rs.getString("endereco"));
            func.setTelefone(rs.getString("telefone"));
            func.setTurno(rs.getString("turno"));
            return func;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
     }
    
}
