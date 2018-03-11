package de.fourseasons.server.SeasonSystem.cmd;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.fourseasons.server.SeasonSystem.SeasonSystem;
import de.fourseasons.server.SeasonSystem.methods.Utils;

public class cmd_Wartung implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		/*<Definiere den Spieler>*/
		Player p = (Player) s;
		/*<Checken ob Spieler ein Spieler oder Consolesender ist>*/
		if(!(s instanceof Player)) {	
			Utils.consoleCommandHelpMap(s);	
			return true;
		}
		/*<Falls er ein Spieler ist wird dieser Code ausgelöst >*/
		if(p.hasPermission("season.cmd.wartung")) {
			
				if(SeasonSystem.getInstance().getConfig().getBoolean("wartungsmodus")) {
					Bukkit.broadcastMessage(Utils.prefix + "Der " + Utils.highlight + "Wartungs "+ Utils.color + "Modus wurde von " + Utils.highlight + p.getName() + Utils.color + " Deaktiviert.");
					SeasonSystem.getInstance().getConfig().set("wartungsmodus", false);
					SeasonSystem.getInstance().saveConfig();
				} else {
					Bukkit.broadcastMessage(Utils.prefix + "Der " + Utils.highlight + "Wartungs "+ Utils.color + "Modus wurde von " + Utils.highlight + p.getName() + Utils.color + " Aktiviert.");
					for(Player all : Bukkit.getOnlinePlayers()) {
						if(!all.hasPermission("season.join.wartung")) {
							all.kickPlayer(ChatColor.BOLD.GREEN + "The FourSeasons Server" + "\n"
						+ ChatColor.RED + "Wir befinden uns Zurzeit in wartung"
						+ "\n"
						+ "\n"
						+ ChatColor.YELLOW + "Wir Sind Bald wieder da für euch! :)");
						}
					}
					SeasonSystem.getInstance().getConfig().set("wartungsmodus", true);
					SeasonSystem.getInstance().saveConfig();

				}
				
		} else {
			
			Utils.err_no_permissions(p, "/wartung", "Developer");
			
		}
		
		return false;
		
	}

}