package src;

import java.util.Random;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;


public class ExplosiveMiningEvent implements Listener 
{
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerBreakBlock(BlockBreakEvent event) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		if(!event.getPlayer().hasPermission("EM.false"))
		{
			Random rand = new Random();
			if(ExplosiveMining.config.getInt(event.getBlock().getTypeId() + "",-100) != -100)
			{	
				if(rand.nextInt(101) <= ExplosiveMining.config.getInt(event.getBlock().getTypeId() + ""))
				{
					event.getPlayer().getWorld().createExplosion(event.getPlayer().getLocation(), 0);
					event.getPlayer().damage(ExplosiveMining.config.getInt("damage"));
				}
			}
		}
	}
}
