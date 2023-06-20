package com.ayckermann.discordbot;

import com.mysql.cj.Query;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;




public class DiscordBot{
    Dotenv dotenv = Dotenv.load();
    String token = dotenv.get("DISCORD_TOKEN");
    JDA jda;

    public DiscordBot() {
        try{
            jda = (JDA) JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
                .setActivity(Activity.playing("Your Mom"))
                .addEventListeners(new BotCommand())
                .build().awaitReady();
            
            jda.upsertCommand("joke","Tell a joke").queue();
            
            jda.upsertCommand("gpt","Ask me anything")
                    .addOption(OptionType.STRING, "message", "write message carefully because every generated message is paid", true)
                    .queue();
        }
        catch (Exception e){
                System.out.println(e);
        }
    }
}

class BotCommand extends ListenerAdapter{
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

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
//        super.onSlashCommandInteraction(event); 

        if(event.getName().equals("joke")){
            event.deferReply().queue();
            
            event.getHook().sendMessage("bapak kamu jokowi ya?").queue();
        
        }
        else if(event.getName().equals("gpt")){
            event.deferReply().queue();
            
            OptionMapping option= event.getOption("message");
            
            if(option == null){
                event.getHook().sendMessage("message not good").queue();
                return;
            }
            
            String message = option.getAsString();
            
            String response = "HI";
//            try {
//                response = new ChatGPT().gpt(message);
//            } catch (IOException ex) {
//                System.out.println("ex");
//                response = "gpt error";
//                return;
//            }
                    
            event.getHook().sendMessage(message + " " + response).queue();
        }
            

    }
      
}
