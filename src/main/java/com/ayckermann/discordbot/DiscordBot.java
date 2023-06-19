package com.ayckermann.discordbot;

import com.mysql.cj.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;





public class DiscordBot extends ListenerAdapter{
    private Database db = new Database();
 
    
    String response(String query, Object[] message){
        String response = "";
        
        ResultSet resultSet = db.load(query, message);
        try {
            while(resultSet.next()){
                response = resultSet.getString("respond");
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex + " : tidak ada messae yang cocok ");;
        }
        
        return response;
        
    }
    @Override
    public void onMessageReceived( MessageReceivedEvent event){


       if(!event.getAuthor().isBot()){
           String message = event.getMessage().getContentRaw();
           MessageChannel channel = event.getChannel(); 

           Object[] data = {message};
           String response = response("SELECT respond FROM msg_respond WHERE message=?", data);

           if(!response.equals("")){
               channel.sendMessage(response).queue(); 
           }

       }  
    }
    

    
}
