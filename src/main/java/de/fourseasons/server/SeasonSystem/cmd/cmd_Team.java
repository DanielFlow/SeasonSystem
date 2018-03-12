package de.fourseasons.server.SeasonSystem.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.fourseasons.server.SeasonSystem.SeasonSystem;
import de.fourseasons.server.SeasonSystem.methods.Utils;
import net.md_5.bungee.api.ChatColor;

public class cmd_Team implements CommandExecutor{

	
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		/*<Register Command Via SeasonSystem.getInstance();>*/
		Player p = (Player) s;
		/*<Checken ob Spieler ein Spieler oder Consolesender ist>*/
		if(!(s instanceof Player)) {	
			Utils.consoleCommandHelpMap(s);	
			return true;
		}
		/*<Falls er ein Spieler ist wird dieser Code ausgelöst >*/
		if(p.hasPermission("season.cmd.team")) {
			
				if(Utils.onlinestaffplayers.size() == 0 ) {
					p.sendMessage(Utils.prefix + "Zurzeit sind leider keine " + ChatColor.GREEN + "" + ChatColor.BOLD + "Teammitglieder" + ChatColor.GRAY + " Online.");
				} else if(Utils.onlinestaffplayers.size() == 1) {
					p.sendMessage(Utils.prefix + "Zurzeit ist " + ChatColor.GREEN + "" + ChatColor.BOLD + " nur Ein" + ChatColor.GRAY + " Teammitglied Online.");
				} else {
					p.sendMessage(Utils.prefix + "Zurzeit sind " + ChatColor.GREEN + "" + ChatColor.BOLD + Utils.onlinestaffplayers.size() + ChatColor.GRAY + " Teammitglieder Online.");
				}
				
		} else {
			
			Utils.err_no_permissions(p, "/team", "Member");
			
		}
		
		return false;
		
	}



}
