package de.fourseasons.server.SeasonSystem.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.fourseasons.server.SeasonSystem.SeasonSystem;
import de.fourseasons.server.SeasonSystem.methods.Utils;
import net.md_5.bungee.api.ChatColor;

public class cmd_Globalmute implements CommandExecutor {
	
	
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		/*<Definiere den Spieler>*/
		Player p = (Player) s;
		/*<Checken ob Spieler ein Spieler oder Consolesender ist>*/
		if(!(s instanceof Player)) {	
			Utils.consoleCommandHelpMap(s);	
			return true;
		}
		/*<Falls er ein Spieler ist wird dieser Code ausgelöst >*/
		if(p.hasPermission("season.cmd.globalmute")) {
			
				if(SeasonSystem.getInstance().getConfig().getBoolean("globalmute")) {
					Bukkit.broadcastMessage(Utils.prefix + "Der " + ChatColor.GREEN + "" + ChatColor.BOLD + "Globalmute "+ Utils.color + "Modus wurde von " + ChatColor.GREEN + "" + ChatColor.BOLD + p.getName() + Utils.color + " deaktiviert.");
					SeasonSystem.getInstance().getConfig().set("globalmute", false);
					SeasonSystem.getInstance().saveConfig();
				} else {
					Bukkit.broadcastMessage(Utils.prefix + "Der " + ChatColor.GREEN + "" + ChatColor.BOLD + "Globalmute "+ Utils.color + "Modus wurde von " + ChatColor.GREEN + "" + ChatColor.BOLD + p.getName() + Utils.color + " aktiviert.");					SeasonSystem.getInstance().getConfig().set("globalmute", true);
					SeasonSystem.getInstance().saveConfig();

				}
				
		} else {
			
			Utils.err_no_permissions(p, "/globalmute", "Moderator");
			
		}
		
		return false;
		
	}

}
