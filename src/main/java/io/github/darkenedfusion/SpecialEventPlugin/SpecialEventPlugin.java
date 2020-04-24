package io.github.darkenedfusion.SpecialEventPlugin;

import io.github.darkenedfusion.SpecialEventPlugin.Commands.CloudBoots;
import io.github.darkenedfusion.SpecialEventPlugin.Listeners.bootListener;
import org.bukkit.plugin.java.JavaPlugin;

public class SpecialEventPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
// First registers command CloudBoots
        this.getCommand("cloudboots").setExecutor(new CloudBoots());
// Registers the events in bootListener in this plugin.
        this.getServer().getPluginManager().registerEvents(new bootListener(), this);
    }

    @Override
    public void onDisable() {

    }





}
