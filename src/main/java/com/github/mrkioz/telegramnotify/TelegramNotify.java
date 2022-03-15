package com.github.mrkioz.telegramnotify;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.mrkioz.telegramnotify.listeners.playerevents;

public final class TelegramNotify extends JavaPlugin implements Listener {

    static int PlayersOnline = 0;
    public static boolean Debug = true;
    public static String BOT_TOKEN;
    public static int CHAT_ID;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this,this);
        getServer().getPluginManager().registerEvents(new playerevents(),this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        BOT_TOKEN = getConfig().getString("BOT_TOKEN");
        CHAT_ID = getConfig().getInt("CHAT_ID");
        Debug = getConfig().getBoolean("debug");

        Bukkit.getLogger().info(ChatColor.GREEN + "The plugin has been enabled");

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(ChatColor.RED + "The Plugin has been disabled");
    }
}
