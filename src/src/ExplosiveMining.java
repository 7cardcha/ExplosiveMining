package src;

import org.bukkit.plugin.java.JavaPlugin;

public class ExplosiveMining extends JavaPlugin
{
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(new ExplosiveMiningEvent(), this);
	}
		 
	public void onDisable()
	{
		
	}

}
