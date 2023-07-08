 package com.ayckermann.discordbot;


import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;



public class DiscordBot{
    Dotenv dotenv = Dotenv.load();
    String token = dotenv.get("DISCORD_TOKEN");
    public BotCommands botCommands = new BotCommands();
    JDA jda;

    public DiscordBot() {
        try{
            jda = (JDA) JDABuilder.createDefault(token)
                .addEventListeners(botCommands)
                .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
                .setChunkingFilter(ChunkingFilter.ALL) 
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .build().awaitReady();
            
            jda.upsertCommand("help","Guide to use Aya Bot").queue();
            
            jda.upsertCommand("joke","Tell a joke")
                    .addOption(OptionType.STRING, "contain", "joke containing words you pick", false)
                    .queue();
            
            jda.upsertCommand("meme","Generate meme").queue();
            
            jda.upsertCommand("gpt","Ask me anything")
                    .addOption(OptionType.STRING, "message", "write message carefully because every generated message is paid", true)
                    .queue();
            
            jda.upsertCommand("purge","Purge message")
                    .addOption(OptionType.INTEGER, "x", "Purge last x message, maximum is 100 in guild and 50 in private message",true)
                    .queue();
        }
        catch (Exception e){
                System.out.println(e);
        }
    }
}
