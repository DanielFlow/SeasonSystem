package de.fourseasons.server.SeasonSystem.cmd;



import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.fourseasons.server.SeasonSystem.methods.Utils;
import net.md_5.bungee.api.ChatColor;

public class cmd_Tpa implements CommandExecutor{
	
	
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		/*<Definiere den Spieler>*/
		Player p = (Player) s;
		/*<Checken ob Spieler ein Spieler oder Consolesender ist>*/
		if(!(s instanceof Player)) {	
			Utils.consoleCommandHelpMap(s);	
			return true;
		}
		/*<Falls er ein Spieler ist wird dieser Code ausgelöst >*/
		if(p.hasPermission("season.cmd.tpa")) {
			
			if(args.length == 1) {
				try {
					Player target = Bukkit.getPlayer(args[0]);
					
					Utils.tpa.put(target, p);
					
					target.sendMessage(Utils.prefix + ChatColor.GREEN + "" + ChatColor.BOLD + p.getName() + ChatColor.GRAY + " möchte sich Zu dir Teleportieren! " + ChatColor.GREEN + "" + ChatColor.BOLD +  " /Tpaccept " + ChatColor.GRAY + "?");
					p.sendMessage(Utils.prefix + "Du hast " + ChatColor.GREEN + "" + ChatColor.BOLD + target.getName() + ChatColor.GRAY + " eine Tpa-Anfrage gesendet!.");
				} catch (Exception e) {
					Utils.err_player_notfound(p, args[0]);
				}
				
				
			} else {
				Utils.err_invalid_syntax(p, "/tpa (Spieler)");
			}
			

				
		} else {
			
			Utils.err_no_permissions(p, "/tpa", "VIP");
			
		}
		
		return false;
		
	}

}