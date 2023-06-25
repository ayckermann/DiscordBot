package com.ayckermann.discordbot;

import java.awt.Color;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import java.util.Timer;
import java.util.TimerTask;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;


public class BotCommands extends ListenerAdapter{
    private Database db = new Database();
    
    
    public String response(String query, Object[] message, String column){
        String response = "";
        
        ResultSet resultSet = db.load(query, message);
        try {
            while(resultSet.next()){
                response = resultSet.getString(column);
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex + " : tidak ada messae yang cocok ");;
        }
        
        return response;
        
    }
    
    public void infoUser(MessageReceivedEvent event){
        if(!event.getAuthor().isBot()){
            String id = event.getAuthor().getId();
            String name = event.getAuthor().getEffectiveName();
            String username = event.getAuthor().getName();
            
            Object[] select = {id};
            String databaseId = response("SELECT userId FROM user WHERE userId=?", select,"userId");
            
            if(databaseId.equals(id) ){
                Object[] update = {name,username,id};
                db.edit("UPDATE user SET displayName =?, username=? WHERE userId=?",update); 
                
            }else{
                Object[] insert = {id,name,username};
                db.edit("INSERT INTO user (userId,displayName,username)"
                        + "VALUES(?,?,?)",insert );            
            }

        }

    }
    public void infoUser(SlashCommandInteractionEvent event){
        if(!event.getUser().isBot()){
            String id = event.getUser().getId();
            String name = event.getUser().getEffectiveName(); 
            String username = event.getUser().getName();
                
            Object[] select = {id};
            String databaseId = response("SELECT userId FROM user WHERE userId=?", select,"userId");
            
            if(databaseId.equals(id) ){
                Object[] update = {name,username,id};
                db.edit("UPDATE user SET displayName =?, username=? WHERE userId=?",update); 
                
            }else{
                Object[] insert = {id,name,username};
                db.edit("INSERT INTO user (userId,displayName,username)"
                        + "VALUES(?,?,?)",insert );            
            }
        }

    }
    public void infoGuild(MessageReceivedEvent event){
        if(!event.getAuthor().isBot()){
            if(event.isFromGuild()){
                String id = event.getGuild().getId();
                String name = event.getGuild().getName();
                String defaultChannelId = "";
                
                TextChannel communityUpdatesChannel = event.getGuild().getCommunityUpdatesChannel();
  
                if(communityUpdatesChannel == null){
                    defaultChannelId = event.getGuild().getDefaultChannel().getId();
                }
                else{
                    defaultChannelId = event.getGuild().getCommunityUpdatesChannel().getId();
                }
        
                Object[] select = {id};
                String databaseId = response("SELECT guildId FROM guild WHERE guildId=?", select,"guildId");

                if(databaseId.equals(id) ){
                    Object[] update = {name,defaultChannelId,id};
                    db.edit("UPDATE guild SET guildName =?, defaultChannel=? WHERE guildId=?",update); 

                }else{
                    Object[] insert = {id,name,defaultChannelId};
                    db.edit("INSERT INTO guild (guildId,guildName,defaultChannel)"
                            + "VALUES(?,?,?)",insert );            
                }
            }
       
        }
    }
    
    public void infoGuild(SlashCommandInteractionEvent  event){
        if(!event.getUser().isBot()){
            if(event.isFromGuild()){
                String id = event.getGuild().getId();
                String name = event.getGuild().getName();
                String defaultChannelId = "";
                
                TextChannel communityUpdatesChannel = event.getGuild().getCommunityUpdatesChannel();
  
                if(communityUpdatesChannel == null){
                    defaultChannelId = event.getGuild().getDefaultChannel().getId();
                }
                else{
                    defaultChannelId = event.getGuild().getCommunityUpdatesChannel().getId();
                }
        
                Object[] select = {id};
                String databaseId = response("SELECT guildId FROM guild WHERE guildId=?", select,"guildId");

                if(databaseId.equals(id) ){
                    Object[] update = {name,defaultChannelId,id};
                    db.edit("UPDATE guild SET guildName =?, defaultChannel=? WHERE guildId=?",update); 

                }else{
                    Object[] insert = {id,name,defaultChannelId};
                    db.edit("INSERT INTO guild (guildId,guildName,defaultChannel)"
                            + "VALUES(?,?,?)",insert );            
                }
            }
       
        }
    }
    
    
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
       infoUser(event);
       if(event.isFromGuild()){
           infoGuild(event);
           if(event.getMessage().getMentions().isMentioned(event.getJDA().getSelfUser())){
                if(!event.getAuthor().isBot()){
                    MessageChannel channel = event.getChannel(); 
                    String content = event.getMessage().getContentDisplay();
                    
                    String mention = event.getJDA().getSelfUser().getName();
                    mention = "@"+mention;
                    String message = content.replace(mention, "").trim();
                 

                    Object[] data = {message};
                    String response = response("SELECT respond FROM msg_respond WHERE message=?", data,"respond");

                    if(!response.equals("")){
                        channel.sendMessage(response).queue(); 
                    }
                    if(content.equals(mention)){
                        String mentionedUser = event.getMessage().getAuthor().getAsMention();
                        channel.sendMessage("Gimana ?" + mentionedUser).queue(); 
                    }

                }
           }
       }
       else{
            if(!event.getAuthor().isBot()){
            String message = event.getMessage().getContentRaw();
            MessageChannel channel = event.getChannel(); 

            Object[] data = {message};
            String response = response("SELECT respond FROM msg_respond WHERE message=?", data,"respond");

            if(!response.equals("")){
                channel.sendMessage(response).queue(); 
            }

        }
       }


    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        infoUser(event);
        if(event.isFromGuild()){
            infoGuild(event);
        }
        
        if(event.getName().equals("joke")){
            event.deferReply().queue();
            OptionMapping option= event.getOption("type");
           
            String type = "";
            if (option != null){
               type = option.getAsString();
            }
            
            String[] joke = {};
            try {
                if(type.isEmpty()){
                    type = "";
                }
                joke = new Joke().generateJoke(type);
                
 
                
            } catch (IOException ex) {
                System.out.println(ex);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            
            if(joke != null){
                event.getHook().sendMessage(joke[0]).queue();

                final String punchline = joke[1];

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                   @Override
                   public void run() {
                       event.getChannel().sendMessage(punchline).queue();
                   }
                }, 5000);          
            } 
            else{
                event.getHook().sendMessage("Joke tidak ditemukan").queue();
            }  
        }
        
        else if(event.getName().equals("meme")){
             event.deferReply().queue();
            String meme="";
            
            try {
                meme = new Meme().generateMeme();
            } catch (IOException ex) {
                Logger.getLogger(BotCommands.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(BotCommands.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.CYAN);
            eb.setImage(meme);

            event.getHook().sendMessageEmbeds(eb.build()).queue();
        }
        
        else if(event.getName().equals("gpt")){
            event.deferReply().queue();
            
            OptionMapping option= event.getOption("message");
            
            if(option == null){
                event.getHook().sendMessage("message not good").queue();
                return;
            }
            
            String message = option.getAsString();
            Object[] data = {"gpt",message};
            String response = response("SELECT respond FROM slash_command WHERE command=? AND parameter=?", data,"respond");
            if(!response.equals("")){
                event.getHook().sendMessage(message + " " + response).queue();
            }
            else{
                try {
                    response = new ChatGPT().gpt(message);
                    event.getHook().sendMessage(message + " " + response).queue();
                    
                    Object[] data2 = {"gpt",message,response};
                    db.edit("INSERT INTO slash_command (command,parameter,respond)"
                            + "VALUES(?,?,?)",data2 );
     
                    
                } catch (IOException ex) {
                    System.out.println("ex");
                    response = "gpt error";
                    return;
                }
            }
        }
    }
      
}
