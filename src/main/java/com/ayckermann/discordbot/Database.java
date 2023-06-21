/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ayckermann.discordbot;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASUS VIVOBOOK
 */
public class Database {
    Connection connection;
    
    Database(){
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/discordbot",
                "root", "");
        }
        catch (Exception exception) {
                   System.out.println(exception);
               }
    }
    public ResultSet load(String query, Object[] data){
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            
            if(data != null){
                for(int i =0; i<data.length ;i++){
                    preparedStmt.setString ((i+1), data[i].toString());
                    
                }         
            }
       
            ResultSet resultSet = preparedStmt.executeQuery();
            return resultSet;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public void edit(String query, Object[] data){
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            
            for(int i =0; i<data.length ;i++){
                preparedStmt.setString ((i+1), data[i].toString());
            }
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
