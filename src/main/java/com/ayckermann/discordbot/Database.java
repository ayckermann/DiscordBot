package com.ayckermann.discordbot;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    Connection connection;
    
    Database(){
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/discordbot",
                "root", "");
            if(connection != null){
                System.out.println("DATABASE CONNECTED");
            }else{
                System.out.println("FAILED TO CONNECT TO DATABASE ");
            }
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
