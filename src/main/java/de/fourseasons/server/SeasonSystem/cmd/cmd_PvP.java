package de.fourseasons.server.SeasonSystem.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.fourseasons.server.SeasonSystem.SeasonSystem;
import de.fourseasons.server.SeasonSystem.methods.Utils;

public class cmd_PvP implements CommandExecutor{
	
	
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		/*<Definiere den Spieler>*/
		Player p = (Player) s;
		/*<Checken ob Spieler ein Spieler oder Consolesender ist>*/
		if(!(s instanceof Player)) {	
			Utils.consoleCommandHelpMap(s);	
			return true;
		}
		/*<Falls er ein Spieler ist wird dieser Code ausgelöst >*/
		if(p.hasPermission("season.cmd.PvP")) {
			
				if(SeasonSystem.getInstance().getConfig().getBoolean("pvp")) {
					Bukkit.broadcastMessage(Utils.prefix + "Der " + Utils.highlight + "PvP "+ Utils.color + "Modus wurde von " + Utils.highlight + p.getName() + Utils.color + " Deaktiviert.");
					SeasonSystem.getInstance().getConfig().set("pvp", false);
					SeasonSystem.getInstance().saveConfig();
				} else {
					Bukkit.broadcastMessage(Utils.prefix + "Der " + Utils.highlight + "PvP "+ Utils.color + "Modus wurde von " + Utils.highlight + p.getName() + Utils.color + " Aktiviert.");
					SeasonSystem.getInstance().getConfig().set("pvp", true);
					SeasonSystem.getInstance().saveConfig();

				}
				
		} else {
			Utils.err_no_permissions(p, "/pvp", "Moderator");
		}
		
		return false;
		
	}

}



