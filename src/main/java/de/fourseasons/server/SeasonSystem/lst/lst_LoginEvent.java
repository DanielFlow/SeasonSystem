package de.fourseasons.server.SeasonSystem.lst;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import de.fourseasons.server.SeasonSystem.SeasonSystem;

public class lst_LoginEvent implements Listener{
	
	@SuppressWarnings({ "deprecation", "static-access" })
	@EventHandler
	public void on(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if(SeasonSystem.getInstance().getConfig().getBoolean("wartungsmodus")) {
			if(p.hasPermission("season.join.wartung")) {
				e.setResult(Result.ALLOWED);
			} else {

				e.setResult(Result.KICK_OTHER);
				e.setKickMessage(ChatColor.BOLD.GREEN + "The FourSeasons Server" + "\n"
						+ ChatColor.RED + "Wir befinden uns Zurzeit in wartung"
						+ "\n"
						+ "\n"
						+ ChatColor.YELLOW + "Wir Sind Bald wieder da für euch! :)");
			}
		} else {
			e.setResult(Result.ALLOWED);
		}
	}

}
