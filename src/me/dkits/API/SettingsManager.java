package me.dkits.API;

import org.bukkit.configuration.ConfigurationSection;
import java.util.Set;
import org.bukkit.configuration.file.YamlConfiguration;
import me.dkits.Main;
import org.bukkit.configuration.file.FileConfiguration;
import java.io.File;

public class SettingsManager
{
    private static final SettingsManager configuration;
    private static final SettingsManager warps;
    private File file;
    private FileConfiguration config;
    
    static {
        configuration = new SettingsManager("config");
        warps = new SettingsManager("warps");
    }
    
    public static SettingsManager getConfig() {
        return SettingsManager.configuration;
    }
    
    public static SettingsManager getWarps() {
        return SettingsManager.warps;
    }
    
    private SettingsManager(final String fileName) {
        if (!Main.getPlugin().getDataFolder().exists()) {
            Main.getPlugin().getDataFolder().mkdir();
        }
        this.file = new File(Main.getPlugin().getDataFolder(), String.valueOf(fileName) + ".yml");
        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.config = (FileConfiguration)YamlConfiguration.loadConfiguration(this.file);
    }
    
    public <T> Object get(final String path) {
        return this.config.get(path);
    }
    
    public Set<String> getKeys() {
        return (Set<String>)this.config.getKeys(false);
    }
    
    public void set(final String path, final Object value) {
        this.config.set(path, value);
        this.save();
    }
    
    public boolean contains(final String path) {
        return this.config.contains(path);
    }
    
    public ConfigurationSection createSection(final String path) {
        final ConfigurationSection section = this.config.createSection(path);
        this.save();
        return section;
    }
    
    public void save() {
        try {
            this.config.save(this.file);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
