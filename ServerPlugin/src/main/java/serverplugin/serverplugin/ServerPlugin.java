package serverplugin.serverplugin;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import serverplugin.serverplugin.Commands.FlyCommands;
import serverplugin.serverplugin.Commands.push;
import serverplugin.serverplugin.events.PlayerEvents;

import java.util.logging.Logger;

public final class ServerPlugin extends JavaPlugin
{

    public PluginDescriptionFile config = this.getDescription();
    public Logger log = this.getLogger();

    @Override
    public void onEnable()
    {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PlayerEvents(this), this);
        getCommand("fly").setExecutor(new FlyCommands(this));
        getCommand("push").setExecutor(new push(this));
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        log.info("ServerPlugin has ready for server open.");
        log.info("버젼 : " + config.getVersion());
        log.info("접두사 : " + config.getPrefix());
        log.info("ServerPlugin successfully on!");
    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
        System.out.println("ServerPlugin has off for server close.");
    }
}
