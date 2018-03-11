package de.fourseasons.server.SeasonSystem.lst;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class lst_TabEvent implements Listener{
	
	
	@EventHandler
	public void on(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		String name = "";
		String clan = "";
		String prefix = "";
		
		if(p.hasPermission("season.rang.Admin")) {
			
			name = ChatColor.DARK_RED + p.getName();
			prefix = ChatColor.DARK_RED + "Admin" + ChatColor.DARK_GRAY + " | " + name;
			p.setPlayerListName(prefix);
		} else if(p.hasPermission("season.rang.vip")) {
			name = ChatColor.AQUA + p.getName();
			prefix = ChatColor.AQUA + "VIP" + ChatColor.DARK_GRAY + " | " + name;
			p.setPlayerListName(prefix);
		} else if(p.hasPermission("season.rang.elite")) {
			name = ChatColor.YELLOW + p.getName();
			prefix = ChatColor.YELLOW + "ELITE" + ChatColor.DARK_GRAY + " | " + name;
			p.setPlayerListName(prefix);
		} else if(p.hasPermission("season.rang.pro")) {
			name = ChatColor.GREEN + p.getName();
			prefix = ChatColor.GREEN + "Pro" + ChatColor.DARK_GRAY + " | " + name;
			p.setPlayerListName(prefix);
		} else if(p.hasPermission("season.rang.titan")) {
			name = ChatColor.GOLD + p.getName();
			prefix = ChatColor.GOLD + "" + ChatColor.BOLD + "Titan" + ChatColor.DARK_GRAY + " | " + name;
			p.setPlayerListName(prefix);
		} else if(p.hasPermission("season.rang.epic")) {
			name = ChatColor.DARK_GRAY + p.getName();
			prefix = ChatColor.GOLD + "" + ChatColor.BOLD + "E"+ChatColor.DARK_GRAY.BOLD+ "pic" + ChatColor.GRAY + " | " + name;
			p.setPlayerListName(prefix);
		} else if(p.hasPermission("season.rang.ultra")) {
			name = ChatColor.LIGHT_PURPLE + p.getName();
			prefix = ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "ULTRA" + ChatColor.DARK_GRAY + " | " + name;
			p.setPlayerListName(prefix);
		} else if(p.hasPermission("season.rang.youtuber")) {
			name = ChatColor.DARK_PURPLE + p.getName();
			prefix = ChatColor.DARK_PURPLE +  "Special" + ChatColor.DARK_GRAY + " | " + name;
			p.setPlayerListName(prefix);
			name = ChatColor.DARK_PURPLE + p.getName();
		} else if(p.hasPermission("season.rang.streamer")) {
			name = ChatColor.DARK_PURPLE + p.getName();
			prefix = ChatColor.DARK_PURPLE + "Twitch.tv" + ChatColor.DARK_GRAY + " | " + name;
			p.setPlayerListName(prefix);
		} else if(p.hasPermission("season.rang.supporter")) {
			name = ChatColor.DARK_GREEN + p.getName();
			prefix = ChatColor.DARK_GREEN + "Sup" + ChatColor.DARK_GRAY + " | " + name;
			p.setPlayerListName(prefix);
		} else if(p.hasPermission("season.rang.moderator")) {
			name = ChatColor.DARK_AQUA + p.getName();
			prefix = ChatColor.DARK_AQUA + "Mod" + ChatColor.DARK_GRAY + " | " + name;
			p.setPlayerListName(prefix);
		} else if(p.hasPermission("season.rang.gameadmin")) {
			name = ChatColor.RED + p.getName();
			prefix = ChatColor.RED + "G-Admin" + ChatColor.DARK_GRAY + " | " + name;
			p.setPlayerListName(prefix);
		} else if(p.hasPermission("season.rang.developer")) {
			name = ChatColor.AQUA + p.getName();
			prefix = ChatColor.AQUA + "Dev" + ChatColor.DARK_GRAY + " | " + name;
			p.setPlayerListName(prefix);
		} else if(p.hasPermission("season.rang.member")) {
			name = ChatColor.BLUE + p.getName();
			prefix = ChatColor.BLUE + "Member" + ChatColor.DARK_GRAY + " | " + name;
			p.setPlayerListName(prefix);
		} else {
			name = ChatColor.BLUE + p.getName();
			prefix = ChatColor.BLUE + "Member" + ChatColor.DARK_GRAY + " | " + name;
			p.setPlayerListName(prefix);
		}
	}

}
