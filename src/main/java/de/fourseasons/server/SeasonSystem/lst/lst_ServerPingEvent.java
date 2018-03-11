package de.fourseasons.server.SeasonSystem.lst;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import de.fourseasons.server.SeasonSystem.SeasonSystem;
import net.md_5.bungee.api.ChatColor;

public class lst_ServerPingEvent implements Listener{
	
	@EventHandler
	public void on(ServerListPingEvent e) {
		if(!SeasonSystem.getInstance().getConfig().getBoolean("wartungsmodus")) {
			e.setMotd( 	  /*LINE 1*/ ChatColor.GREEN + "The FourSeasons PvP Network " + ChatColor.DARK_GRAY + " | " + ChatColor.YELLOW + " HCPVP Release !"
						+ "\n"
						+ /*LINE 2*/ ChatColor.GREEN + "Dein #1 PvP Server in Deutschland!");
		} else {
			e.setMotd( 	  /*LINE 1*/ ChatColor.RED + "The FourSeasons PvP Network " + ChatColor.DARK_GRAY + " | " + ChatColor.YELLOW + " HCPVP Release !"
					+ "\n"
					+ /*LINE 2*/ ChatColor.RED + "Wir befinden uns Zurzeit in Wartung!, wir sind bald wieder da");
		}
	}
}
