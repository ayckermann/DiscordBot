package com.ayckermann.discordbot;

import java.awt.Color;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.concrete.PrivateChannel;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;


public class BotCommands extends ListenerAdapter{
    private Database db = new Database();
    private Meme meme = new Meme();
    private Joke joke = new Joke();
    private ChatGPT chatGPT =  new ChatGPT();
    public boolean  isRegister(String id){   
        Object[] select = {id};
        String databaseId = response("SELECT userId FROM user WHERE userId=?", select,"userId");
        if(databaseId.equals(id) ){
            return true;
        }
        return false;
    }
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
                User user = event.getJDA().getUserById(id);
                
                Button accept = Button.success("accept", "ACCEPT");
                Button ignore = Button.danger("ignore", "IGNORE");

                EmbedBuilder verif = new EmbedBuilder()
                    .setTitle("WELCOME TO AYA BOT")
                    .setDescription("Click Accept to continue using Aya Bot")
                    .setColor(Color.CYAN);
 
//                    .setActionRows(ActionRow.of(accept));
                user.openPrivateChannel().queue((privateChannel) ->
                    //privateChannel.sendMessage(message).queue()
                    privateChannel.sendMessageEmbeds(verif.build())
                            .setActionRow(accept,ignore)
                            .queue()       

                );
                                    
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
                User user = event.getJDA().getUserById(id);
                
                Button accept = Button.success("accept", "ACCEPT");
                Button ignore = Button.danger("ignore", "IGNORE");

                EmbedBuilder verif = new EmbedBuilder()
                    .setTitle("WELCOME TO AYA BOT")
                    .setDescription("Click Accept to continue using Aya Bot")
                    .setColor(Color.CYAN);
 
//                    .setActionRows(ActionRow.of(accept));
                user.openPrivateChannel().queue((privateChannel) ->
                    //privateChannel.sendMessage(message).queue()
                    privateChannel.sendMessageEmbeds(verif.build())
                            .setActionRow(accept,ignore)
                            .queue()       

                );
                                    
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
    public void onButtonInteraction(ButtonInteractionEvent event) {
//        super.onButtonInteraction(event); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        if(event.getButton().getId().equals("accept")){
            
            event.deferEdit().queue();
                        
            String id = event.getUser().getId();
            String name = event.getUser().getEffectiveName();
            String username = event.getUser().getName();
            
            
            Object[] insert = {id,name,username};                        
            db.edit("INSERT INTO user (userId,displayName,username)"
                    + "VALUES(?,?,?)",insert );

            event.getHook().deleteOriginal().queue();
            event.getChannel().sendMessage("Thanks for accepting. Enjoy :)").queue();
            
        }
        else if(event.getButton().getId().equals("ignore")){
            event.deferEdit().queue();
            
            event.getHook().deleteOriginal().queue();  

            event.getChannel().sendMessage("See you next time!").queue();
        }
    }
    
    
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
       if(event.isFromGuild()){
           infoGuild(event);
           if(event.getMessage().getMentions().isMentioned(event.getJDA().getSelfUser())){
                infoUser(event);
                if(!event.getAuthor().isBot() && isRegister(event.getAuthor().getId())){
                    MessageChannel channel = event.getChannel(); 
                    String content = event.getMessage().getContentDisplay();
                    
                    String mention = event.getJDA().getSelfUser().getName();
                    mention = "@"+mention;
                    String message = content.replace(mention, "").trim();
                 

                    Object[] data = {message};
                    String response = response("SELECT respond FROM msg_respond WHERE message=?", data,"respond");

                    if(!response.equals("")){
                        channel.sendMessage(response).queue(); 
                        
                        Object[] log = {event.getAuthor().getId(),event.getAuthor().getName(),message,response};
                        db.edit("INSERT INTO log (userId,username,incoming,outgoing)"
                                + "VALUES(?,?,?,?)",log ); 
                    }else{
                        response="Sorry I can't answer that message";
                        channel.sendMessage(response).queue(); 
                        
                        Object[] log = {event.getAuthor().getId(),event.getAuthor().getName(),message,response};
                        db.edit("INSERT INTO log (userId,username,incoming,outgoing)"
                                + "VALUES(?,?,?,?)",log ); 
                    }
                    
                    
                    if(content.equals(mention)){
                        String mentionedUser = event.getMessage().getAuthor().getAsMention();
                        channel.sendMessage("Gimana ?" + mentionedUser).queue(); 
                        
                        Object[] log = {event.getAuthor().getId(),event.getAuthor().getName(),"@Aya Bot", "Gimana ?" + mentionedUser};
                        db.edit("INSERT INTO log (userId,username,incoming,outgoing)"
                                + "VALUES(?,?,?,?)",log );
                    }

                }
                else if(!event.getAuthor().isBot() && !isRegister(event.getAuthor().getId())){
                    event.getChannel().sendMessage("Accept our verification first." +event.getMember().getAsMention()).queue();
 

                }
           }
       }
       else{
            infoUser(event);
            if(!event.getAuthor().isBot() && isRegister(event.getAuthor().getId())){
                String message = event.getMessage().getContentRaw();
                MessageChannel channel = event.getChannel(); 

                Object[] data = {message};
                String response = response("SELECT respond FROM msg_respond WHERE message=?", data,"respond");

                if(!response.equals("")){
                    channel.sendMessage(response).queue(); 
                    Object[] log = {event.getAuthor().getId(),event.getAuthor().getName(),message,response};
                    db.edit("INSERT INTO log (userId,username,incoming,outgoing)"
                            + "VALUES(?,?,?,?)",log );
                }
                else{
                    response="Sorry I can't answer that message";
                    channel.sendMessage(response).queue(); 

                    Object[] log = {event.getAuthor().getId(), event.getAuthor().getName(), message, response};
                    db.edit("INSERT INTO log (userId,username,incoming,outgoing)"
                            + "VALUES(?,?,?,?)",log ); 
                }

            }
            else if(!event.getAuthor().isBot() && !isRegister(event.getAuthor().getId())){
                event.getChannel().sendMessage("Accept our verification first.").queue();

            }
       }


    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        
        infoUser(event);
        if(isRegister(event.getUser().getId())){
            if(event.isFromGuild()){
                infoGuild(event);
            }
        
            if(event.getName().equals("joke")){
                event.deferReply().queue();
                OptionMapping option= event.getOption("contain");

                String type = "";
                if (option != null){
                   type = option.getAsString();
                }

                String[] jokes = {};
     
                if(type.isEmpty()){
                    type = "";
                }
                jokes = joke.generateJoke(type);     

     

                if(joke != null){
                    event.getHook().sendMessage(jokes[0]).queue();

                    final String punchline = jokes[1];
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                       @Override
                       public void run() {
                           event.getChannel().sendMessage(punchline).queue();
                       }
                    }, 5000);  
                    
                    Object[] log = {event.getUser().getId(),event.getUser().getName(),"/joke "+type,jokes[0]+"\n"+jokes[1]};
                    db.edit("INSERT INTO log (userId,username,incoming,outgoing)"
                            + "VALUES(?,?,?,?)",log ); 
                } 
                else{
                    event.getHook().sendMessage("Joke tidak ditemukan").queue();
                    Object[] log = {event.getUser().getId(),event.getUser().getName(),"/joke "+type,"Joke tidak ditemukan"};
                    db.edit("INSERT INTO log (userId,username,incoming,outgoing)"
                            + "VALUES(?,?,?,?)",log ); 
                }  
            }

            else if(event.getName().equals("meme")){
                event.deferReply().queue();
                String memes="";

                try {
                    memes = meme.generateMeme();
                } catch (IOException ex) {
                    Logger.getLogger(BotCommands.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BotCommands.class.getName()).log(Level.SEVERE, null, ex);
                }

                EmbedBuilder eb = new EmbedBuilder();
                eb.setColor(Color.CYAN);
                eb.setImage(memes);
                event.getHook().sendMessageEmbeds(eb.build()).queue();
                
                Object[] log = {event.getUser().getId(),event.getUser().getName(),"/meme",meme};
                db.edit("INSERT INTO log (userId,username,incoming,outgoing)"
                        + "VALUES(?,?,?,?)",log );
                 
            }

            else if(event.getName().equals("gpt")){
                event.deferReply().queue();

                OptionMapping option= event.getOption("message");

                if(option == null){
                    event.getHook().sendMessage("message not good").queue();
                    return;
                }

                String message = option.getAsString();
                Object[] data = {"/gpt "+message};
                String response = response("SELECT respondSlash FROM slash_command WHERE slashCommand=?", data,"respondSlash");
                if(!response.equals("")){                    
                    if(response.length() < 2000){
                        event.getHook().sendMessage(message + "\n" + response).queue();
                        
                    }else{
                        int length = response.length();
                        int middle = length / 2;

                        String part1 = response.substring(0, middle);
                        String part2 = response.substring(middle);

                        event.getHook().sendMessage(message + "\n" + part1).queue();
                        event.getChannel().sendMessage("... "+part2).queue();
                    }  
                    Object[] log = {event.getUser().getId(),event.getUser().getName(),message,response};
                    db.edit("INSERT INTO log (userId,username,incoming,outgoing)"
                            + "VALUES(?,?,?,?)",log );
                }
                else{
                    try {
                        response = chatGPT.gpt(message);
                        if(response.length() < 2000){
                            event.getHook().sendMessage(message + "\n" + response).queue();
                        }else{
                            int length = response.length();
                            int middle = length / 2;

                            String part1 = response.substring(0, middle);
                            String part2 = response.substring(middle);
                            
                            event.getHook().sendMessage(message + "\n" + part1).queue();
                            event.getChannel().sendMessage("... "+part2).queue();
                        }
                        
                        message = "/gpt "+message;
                        Object[] data2 = {message,response};
                        db.edit("INSERT INTO slash_command (slashCommand,respondSlash)"
                                + "VALUES(?,?)",data2 );
                        
                        Object[] log = {event.getUser().getId(),event.getUser().getName(),message,response};
                        db.edit("INSERT INTO log (userId,username,incoming,outgoing)"
                              + "VALUES(?,?,?,?)",log );
                    } catch (IOException ex) {
                        System.out.println("ex");
                        response = "gpt error";
                        event.getHook().sendMessage(message + "\n" + response).queue();
                        Object[] log = {event.getUser().getId(),event.getUser().getName(),message,response};
                        db.edit("INSERT INTO log (userId,username,incoming,outgoing)"
                              + "VALUES(?,?,?,?)",log );
                    }
                }
            }
            
            else if(event.getName().equals("purge")){
                OptionMapping option= event.getOption("x");
                int x = option.getAsInt();
                int numToDelete = Math.min(x, 100); // Limit to a maximum of 100 messages

                if (event.isFromGuild()) {
                    if(event.getMember().hasPermission(Permission.MODERATE_MEMBERS)){
                        Channel channel = event.getChannel();
                        TextChannel textChannel = (TextChannel) channel;

                        textChannel.getHistory().retrievePast(numToDelete).queue(messages -> {
                            int deletedCount = messages.size();
                            event.deferReply().queue();
                            textChannel.deleteMessages(messages).queue(deletedMessages -> {
                                event.getHook().sendMessage("Deleted " + deletedCount + " messages.").queue();
                            }, error -> {
                                event.getHook().sendMessage("An error occurred while deleting messages.").queue();
                                error.printStackTrace();
                            });
                          });

                    }

                }

                else{
                    Channel channel = event.getChannel();
                    PrivateChannel privateChannel = (PrivateChannel) channel;

                    int count =0;
                    event.deferReply().queue();

                    List<Message> messages = privateChannel.getHistory().retrievePast(numToDelete).complete(); 
                    for(Message message : messages){
                        if(message.getAuthor().isBot()){
                            count++;
                        }
                    }

                    List<Message> messages2 = privateChannel.getHistory().retrievePast(numToDelete+count).complete(); 

                    int deletedCount = 0;
                    for(Message message : messages2){
                        if(message.getAuthor().isBot()){
                            message.delete().queue();
                            deletedCount++;
                        }
                    }

                    if(count>0){

                        event.getChannel().sendMessage("Can only delete messages from bot in Private Message.\n"
                                + "Deleted " + deletedCount + " messages.").queue();
                    }
                    else{
                        event.getHook().sendMessage("An error occurred while deleting messages.").queue();
                    }
                }
                
            }
            
            else if(event.getName().equals("help")){
                event.deferReply().queue();
                
                Object[] data ={"/help"};
                String response = response("SELECT respondSlash FROM slash_command WHERE slashCommand=?", data,"respondSlash");
                
                event.getHook().sendMessage(response).queue();
                
                Object[] log = {event.getUser().getId(),event.getUser().getName(),"/help",response};
                db.edit("INSERT INTO log (userId,username,incoming,outgoing)"
                  + "VALUES(?,?,?,?)",log );
            }

        }
        else{
            if(event.isFromGuild()){
                event.getChannel().sendMessage("Accept our verification first." +event.getMember().getAsMention()).queue();
                
            }else{
                event.getChannel().sendMessage("Accept our verification first.").queue();

            }
        }

        
    }
    
}
