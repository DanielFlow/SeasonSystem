package de.fourseasons.server.SeasonSystem.lst;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

import de.fourseasons.server.SeasonSystem.methods.Utils;

public class lst_HelpTopic implements Listener {
	
	    @EventHandler(priority = EventPriority.NORMAL)
	    
	    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
	        if (!event.isCancelled()) {
	            Player player = event.getPlayer();
	            String cmd = event.getMessage().split(" ")[0];
	            HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
	            if (topic == null) {
	                player.sendMessage(Utils.prefix + "Der Befehl " + ChatColor.GREEN + "" + ChatColor.BOLD + cmd + ChatColor.GRAY + " existiert nicht, "+ ChatColor.GREEN + "" + ChatColor.BOLD + "/help" + ChatColor.GRAY + " ?.");
	                event.setCancelled(true);
	            }
	        }
	    }
}
