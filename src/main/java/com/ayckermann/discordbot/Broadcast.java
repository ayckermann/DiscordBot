package com.ayckermann.discordbot;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;


public class Broadcast extends DiscordBot{
    private Database db = new Database();
    
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    public static long calculateInitialDelay(LocalDateTime currentDateTime, LocalDateTime targetDateTime) {
        return java.time.Duration.between(currentDateTime, targetDateTime).toMillis();
    }
    
    public void broadcastToUsersInDb(String message, String dateTimeString) throws SQLException{
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        LocalDateTime currentDateTime = LocalDateTime.now();
        
        long initialDelay = calculateInitialDelay(currentDateTime, dateTime);
        
        ResultSet resultSet = db.load("SELECT userId FROM user", null);
        while (resultSet.next()) {
            String id = resultSet.getString("userId");
            
           super.jda.retrieveUserById(id).queue((user) -> {
                user.openPrivateChannel().queue((privateChannel) ->
                    //privateChannel.sendMessage(message).queue()
                    scheduler.schedule(() -> privateChannel.sendMessage(message).queue(), initialDelay, TimeUnit.MILLISECONDS)         

                );
            });
            
            
        }
    }
    public void broadcastToAllGuild(String message, String dateTimeString) throws SQLException{
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        LocalDateTime currentDateTime = LocalDateTime.now();
        
        long initialDelay = calculateInitialDelay(currentDateTime, dateTime);   
        
        ResultSet resultSet = db.load("SELECT defaultChannel FROM guild", null);
        while (resultSet.next()) {
            String id = resultSet.getString("defaultChannel");

            scheduler.schedule(() -> super.jda.getTextChannelById(id).sendMessage(message).queue(), initialDelay, TimeUnit.MILLISECONDS);            
        }
    }
     public void broadcastToGuild(String guildId, String message, String dateTimeString) throws SQLException{
       
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        LocalDateTime currentDateTime = LocalDateTime.now();
        
        long initialDelay = calculateInitialDelay(currentDateTime, dateTime);        
        
        Object[] data = {guildId};
        ResultSet resultSet = db.load("SELECT defaultChannel FROM guild WHERE guildId=?", data );
        while (resultSet.next()) {
            String id = resultSet.getString("defaultChannel");
            
            scheduler.schedule(() -> super.jda.getTextChannelById(id).sendMessage(message).queue(), initialDelay, TimeUnit.MILLISECONDS);            
        }
    }
    public void broadcastToGuildMembers(String guildId, String message, String dateTimeString) throws SQLException{
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        LocalDateTime currentDateTime = LocalDateTime.now();
        
        long initialDelay = calculateInitialDelay(currentDateTime, dateTime);   
        
        Guild guild = jda.getGuildById(guildId);
        for (Member member : guild.getMembers()) {
        
            if (!member.getUser().isBot()) {

                member.getUser().openPrivateChannel().queue((privateChannel) ->    
                scheduler.schedule(() -> privateChannel.sendMessage(message).queue(), initialDelay, TimeUnit.MILLISECONDS)         

                ); 
            }

        }
    }

}
