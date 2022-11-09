/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author odavi
 */
public class CorDAO {
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    
    public boolean conectar(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost: 3306/bancoes", "root", "");

            
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
    public int salvar(Cor cor){
        int status;
         try {
           
             st = conn.prepareStatement("INSERT INTO cor VALUES (?)");
             st.setString(1, cor.getCor());
             System.out.println(st);
             status = st.executeUpdate();
             return status;
        } catch (SQLException ex) {
             System.out.println(ex.getErrorCode());
            return ex.getErrorCode();
    }
  }
}
       
