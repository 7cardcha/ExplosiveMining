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
			if(event.getBlock().getTypeId() == 1)
			{
				if(rand.nextFloat() < .01F)
				{
					event.getPlayer().getWorld().createExplosion(event.getPlayer().getLocation(), 0);
					event.getPlayer().damage(6);
				}
			}
			else if(event.getBlock().getTypeId() == 16)
			{
				if(rand.nextFloat() < .03F)
				{
					event.getPlayer().getWorld().createExplosion(event.getPlayer().getLocation(), 0);
					event.getPlayer().damage(6);
				}
			}
		}
	}
}
