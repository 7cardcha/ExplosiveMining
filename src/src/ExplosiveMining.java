package src;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ExplosiveMining extends JavaPlugin
{
	public static File file;
	public static FileConfiguration config;
	
	public void onEnable()
	{
		loadConfig();
		
		addDefaults();
		
		getServer().getPluginManager().registerEvents(new ExplosiveMiningEvent(), this);
	}
		 
	public void onDisable()
	{
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[])
	{
		if(cmd.getName().equalsIgnoreCase("emreload"))
		{
			loadConfig();
			
			sender.sendMessage("Config reloaded.");
			return true;
		}
		
		return false;
	}
	
	public static void loadConfig()
	{
		file = new File("EMconfig.yml");
		if(!file.exists())
		{
			try 
			{
				file.createNewFile();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		config = YamlConfiguration.loadConfiguration(file);
		
	}
	
	public static void addDefaults()
	{
		if(!config.contains("damage"))
		{
			config.set("damage", 6);
		}
		try 
		{
			config.save(file);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
