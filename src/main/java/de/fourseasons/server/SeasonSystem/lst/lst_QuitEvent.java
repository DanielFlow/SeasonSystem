package de.fourseasons.server.SeasonSystem.lst;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.fourseasons.server.SeasonSystem.methods.Utils;

public class lst_QuitEvent implements Listener{
	@EventHandler
	public void onPlayJoin(PlayerQuitEvent e ) {
		Player p = e.getPlayer();
		if(p.hasPermission("season.staff")) {
			Utils.onlinestaffplayers.remove(p);
		}
		if(!p.hasPermission("season.join.msg")) {
			e.setQuitMessage(null);
			Bukkit.broadcastMessage(ChatColor.RED + "-" + ChatColor.GRAY + p.getName());
			
		} else {
			e.setQuitMessage(null);
			Bukkit.broadcastMessage(ChatColor.DARK_AQUA + p.getName() + ChatColor.GRAY + " hat das Spiel verlassen.");
		}
	}

}