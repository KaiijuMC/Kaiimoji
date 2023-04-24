package dev.kugge.kaiimoji;

import dev.kugge.kaiimoji.watcher.SneakWatcher;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class Kaiimoji extends JavaPlugin {

    public static Kaiimoji instance;
    public static Logger logger;
    public static Map<Player, Long> sneakDuration = new ConcurrentHashMap<>();

    @Override
    public void onEnable() {
        instance = this;
        logger = getLogger();
        register();
    }

    private void register(){
        Bukkit.getPluginManager().registerEvents(new SneakWatcher(), this);
    }
}
