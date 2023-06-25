package com.ayckermann.discordbot;


import io.github.cdimascio.dotenv.Dotenv;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
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
                .addEventListeners(new BotCommands())
                .build().awaitReady();
            
            jda.upsertCommand("joke","Tell a joke")
                    .addOption(OptionType.STRING, "type", "type a joke you wanted to generate ex : dark", false)
                    .queue();
            jda.upsertCommand("meme","Generate meme").queue();
            
            jda.upsertCommand("gpt","Ask me anything")
                    .addOption(OptionType.STRING, "message", "write message carefully because every generated message is paid", true)
                    .queue();
        }
        catch (Exception e){
                System.out.println(e);
        }
    }
}

class Broadcast extends DiscordBot{
    private Database db = new Database();
    
    
    public void broadcastToUsersInDb(String message) throws SQLException{
        ResultSet resultSet = db.load("SELECT userId FROM user", null);
        while (resultSet.next()) {
            String id = resultSet.getString("userId");
            
           super.jda.retrieveUserById(id).queue((user) -> {
                user.openPrivateChannel().queue((privateChannel) ->
                    privateChannel.sendMessage(message).queue()
                );
            });
            
            
        }
    }
    public void broadcastToAllGuild(String message) throws SQLException{
        ResultSet resultSet = db.load("SELECT defaultChannel FROM guild", null);
        while (resultSet.next()) {
            String id = resultSet.getString("defaultChannel");
            super.jda.getTextChannelById(id).sendMessage(message).queue();
            
        }
    }
     public void broadcastToGuild(String guildId, String message) throws SQLException{
        Object[] data = {guildId};
        ResultSet resultSet = db.load("SELECT defaultChannel FROM guild WHERE guildId=?", data );
        while (resultSet.next()) {
            String id = resultSet.getString("defaultChannel");
            super.jda.getTextChannelById(id).sendMessage(message).queue();
            
        }
    }
    public void broadcastToGuildMembers(String guildId, String message) throws SQLException{
        Guild guild = jda.getGuildById(guildId);
        
        for (Member member : guild.getMembers()) {
            if (!member.getUser().isBot()) {
                member.getUser().openPrivateChannel().queue((privateChannel) ->
                    privateChannel.sendMessage(message).queue()
                );  
            }
        }
    }

}
