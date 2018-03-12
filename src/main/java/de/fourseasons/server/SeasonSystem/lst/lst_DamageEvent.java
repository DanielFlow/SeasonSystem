package de.fourseasons.server.SeasonSystem.lst;


import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import de.fourseasons.server.SeasonSystem.SeasonSystem;
import de.fourseasons.server.SeasonSystem.methods.Utils;

public class lst_DamageEvent implements Listener{
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void on(EntityDamageEvent e) {
		Player p = (Player) e.getEntity();
		try {
			if(SeasonSystem.getInstance().getConfig().getBoolean("pvp")) {
				e.setCancelled(false);
				} else {
				e.setCancelled(true);
				p.setHealth(20);
			}
		} catch (Exception e2) {
			
		}
		
		
		if(e.getCause() == DamageCause.FALL) {
			e.setCancelled(true);
			
		}
	}
	
	
	

}
