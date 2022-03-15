package com.github.mrkioz.telegramnotify.listeners;

import com.github.mrkioz.telegramnotify.TelegramNotify;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import com.github.mrkioz.telegramnotify.utils.HttpClient;
import org.json.simple.JSONObject;

import static com.github.mrkioz.telegramnotify.TelegramNotify.BOT_TOKEN;
import static com.github.mrkioz.telegramnotify.TelegramNotify.CHAT_ID;

public class playerevents implements Listener {

    @EventHandler
    public void PlayerJoinsTheServer(PlayerJoinEvent event){

        String RequestURL = "https://api.telegram.org/bot" + BOT_TOKEN + "/sendMessage";
        JSONObject data = new JSONObject();
        data.put("chat_id", CHAT_ID);
        data.put("text", event.getPlayer().getName() + " has joined the server");
        String urlParameters = data.toJSONString();

        if (TelegramNotify.Debug){
            Bukkit.getLogger().warning("Requesting URL: " + RequestURL);
            Bukkit.getLogger().warning("Sending Content: " + urlParameters);
        }

        String r = HttpClient.executePostJSON(RequestURL, urlParameters);
        if (TelegramNotify.Debug) Bukkit.getLogger().info(r);
    }

    @EventHandler
    public void PlayerLeavesTheServer(PlayerQuitEvent event){

        String RequestURL = "https://api.telegram.org/bot" + BOT_TOKEN + "/sendMessage";
        JSONObject data = new JSONObject();
        data.put("chat_id", CHAT_ID);
        data.put("text", event.getPlayer().getName() + " has left the server");
        String urlParameters = data.toJSONString();

        if (TelegramNotify.Debug){
            Bukkit.getLogger().warning("Requesting URL: " + RequestURL);
            Bukkit.getLogger().warning("Sending Content: " + urlParameters);
        }

        String r = HttpClient.executePostJSON(RequestURL, urlParameters);
        if (TelegramNotify.Debug) Bukkit.getLogger().info(r);
    }

}
