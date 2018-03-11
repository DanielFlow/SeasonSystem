package de.fourseasons.server.SeasonSystem.lst;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.fourseasons.server.SeasonSystem.SeasonSystem;
import de.fourseasons.server.SeasonSystem.methods.Utils;

public class lst_ChatEvent implements Listener{
	
	
	@EventHandler
	public void on(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		String name = "";
		String msg = e.getMessage();
		String clan = "";
		String prefix = "";
		if(SeasonSystem.getInstance().getConfig().getBoolean("globalmute")) {
			e.setCancelled(true);
			p.sendMessage(Utils.prefix + "Du darfst nicht "+Utils.highlight+"Chatten!"+Utils.color+", Globalmute ist Aktiviert!.");
		} else {
			if(p.hasPermission("season.rang.Admin")) {
				prefix = ChatColor.DARK_RED + "Admin";
				name = ChatColor.DARK_RED + p.getName();
				e.setFormat(prefix + ChatColor.DARK_GRAY + " | " + clan + ChatColor.GRAY + " *" + name + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + msg);
			} else if(p.hasPermission("season.rang.vip")) {
				prefix = ChatColor.AQUA + "VIP";
				name = ChatColor.AQUA + p.getName();
				e.setFormat(prefix + ChatColor.DARK_GRAY + " | " + clan + ChatColor.GRAY + " *" + name + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + msg);
			} else if(p.hasPermission("season.rang.elite")) {
				prefix = ChatColor.YELLOW + "Elite";
				name = ChatColor.YELLOW + p.getName();
				e.setFormat(prefix + ChatColor.DARK_GRAY + " | " + clan + ChatColor.GRAY + " *" + name + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + msg);
			} else if(p.hasPermission("season.rang.pro")) {
				prefix = ChatColor.GREEN + "Pro";
				name = ChatColor.GREEN + p.getName();
				e.setFormat(prefix + ChatColor.DARK_GRAY + " | " + clan + ChatColor.GRAY + " *" + name + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + msg);
			} else if(p.hasPermission("season.rang.titan")) {
				prefix = ChatColor.GOLD.BOLD + "Titan";
				name = ChatColor.GOLD + p.getName();
				e.setFormat(prefix + ChatColor.DARK_GRAY + " | " + clan + ChatColor.GRAY + " *" + name + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + msg);
			} else if(p.hasPermission("season.rang.epic")) {
				prefix = ChatColor.GOLD.BOLD + "E"+ChatColor.DARK_GRAY.BOLD+ "pic";
				name = ChatColor.GRAY + p.getName();
				e.setFormat(prefix + ChatColor.DARK_GRAY + " | " + clan + ChatColor.GRAY + " *" + name + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + msg);
			} else if(p.hasPermission("season.rang.ultra")) {
				prefix = ChatColor.LIGHT_PURPLE.BOLD + "ULTRA";
				name = ChatColor.LIGHT_PURPLE + p.getName();
				e.setFormat(prefix + ChatColor.DARK_GRAY + " | " + clan + ChatColor.GRAY + " *" + name + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + msg);
			} else if(p.hasPermission("season.rang.youtuber")) {
				prefix = ChatColor.DARK_PURPLE + "Special-VIP";
				name = ChatColor.DARK_PURPLE + p.getName();
				e.setFormat(prefix + ChatColor.DARK_GRAY + " | " + clan + ChatColor.GRAY + " *" + name + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + msg);
			} else if(p.hasPermission("season.rang.streamer")) {
				prefix = ChatColor.DARK_PURPLE + "Twitch.tv";
				name = ChatColor.DARK_PURPLE + p.getName();
				e.setFormat(prefix + ChatColor.DARK_GRAY + " | " + clan + ChatColor.GRAY + " *" + name + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + msg);
			} else if(p.hasPermission("season.rang.supporter")) {
				prefix = ChatColor.DARK_GREEN + "Supporter";
				name = ChatColor.DARK_GREEN + p.getName();
				e.setFormat(prefix + ChatColor.DARK_GRAY + " | " + clan + ChatColor.GRAY + " *" + name + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + msg);
			} else if(p.hasPermission("season.rang.moderator")) {
				prefix = ChatColor.DARK_AQUA + "Moderator";
				name = ChatColor.DARK_AQUA + p.getName();
				e.setFormat(prefix + ChatColor.DARK_GRAY + " | " + clan + ChatColor.GRAY + " *" + name + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + msg);
			} else if(p.hasPermission("season.rang.gameadmin")) {
				prefix = ChatColor.RED + "Game-Admin";
				name = ChatColor.RED + p.getName();
				e.setFormat(prefix + ChatColor.DARK_GRAY + " | " + clan + ChatColor.GRAY + " *" + name + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + msg);
			} else if(p.hasPermission("season.rang.developer")) {
				prefix = ChatColor.AQUA + "Dev";
				name = ChatColor.AQUA + p.getName();
				e.setFormat(prefix + ChatColor.DARK_GRAY + " | " + clan + ChatColor.GRAY + " *" + name + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + msg);
			} else if(p.hasPermission("season.rang.member")) {
				prefix = ChatColor.BLUE + "Member";
				name = ChatColor.BLUE + p.getName();
				e.setFormat(prefix + ChatColor.DARK_GRAY + " | " + clan + ChatColor.GRAY + " *" + name + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + msg);
			} else {
				prefix = ChatColor.BLUE + "Member";
				name = ChatColor.BLUE + p.getName();
				e.setFormat(prefix + ChatColor.DARK_GRAY + " | " + clan + ChatColor.GRAY + " *" + name + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + msg);
			}
		}
		
		
	}

}
