package de.fourseasons.server.SeasonSystem.lst;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.fourseasons.server.SeasonSystem.methods.ActionBar;
import de.fourseasons.server.SeasonSystem.methods.Title;
import de.fourseasons.server.SeasonSystem.methods.Utils;

public class lst_JoinEvent implements Listener{
	
	@EventHandler
	public void onPlayJoin(PlayerJoinEvent e ) {
		Player p = e.getPlayer();
		if(p.hasPermission("season.staff")) {
			Utils.onlinestaffplayers.add(p);
		}
		if(!p.hasPermission("season.join.msg")) {
			e.setJoinMessage(null);
			Title title = new Title(ChatColor.GREEN + "Four" + ChatColor.YELLOW + "Seasons"
					,
					 ChatColor.YELLOW + "Next" + ChatColor.GREEN + " Level" + ChatColor.BLUE +" Potion " + ChatColor.RED + "PvP", 40, 40, 20);
			title.send(p);
			/*
			 * ActionBar bar = new ActionBar(ChatColor.GRAY + "Name:" + ChatColor.YELLOW + p.getName() + ChatColor.GRAY + "Kills: " + ChatColor.YELLOW + "0" + ChatColor.GRAY + "Deaths: " + ChatColor.YELLOW + "0");
			bar.send(p);
			 */
			Bukkit.broadcastMessage(ChatColor.GREEN + "+" + ChatColor.GRAY + p.getName());
			
		} else {
			e.setJoinMessage(null);
			Title title = new Title(ChatColor.GREEN + "Four" + ChatColor.YELLOW + "Seasons"
					,
					 ChatColor.YELLOW + "Next" + ChatColor.GREEN + " Level" + ChatColor.BLUE +" Potion " + ChatColor.RED + "PvP", 40, 40, 20);
			title.send(p);
			/*
			 * ActionBar bar = new ActionBar(ChatColor.GRAY + "Name:" + ChatColor.YELLOW + p.getName() + ChatColor.GRAY + "Kills: " + ChatColor.YELLOW + "0" + ChatColor.GRAY + "Deaths: " + ChatColor.YELLOW + "0");
			bar.send(p);;
			 */
			Bukkit.broadcastMessage(ChatColor.YELLOW + p.getName() + ChatColor.GRAY + " hat das Spiel betreten.");
		}
	}

}
