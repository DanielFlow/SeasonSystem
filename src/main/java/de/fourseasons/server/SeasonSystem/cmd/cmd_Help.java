package de.fourseasons.server.SeasonSystem.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.fourseasons.server.SeasonSystem.SeasonSystem;
import de.fourseasons.server.SeasonSystem.methods.Utils;

public class cmd_Help implements CommandExecutor{

	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		Player p = (Player) s;
		/*<Checken ob Spieler ein Spieler oder Consolesender ist>*/
		if(!(s instanceof Player)) {	
			Utils.consoleCommandHelpMap(s);	
			return true;
		}
		/*<Falls er ein Spieler ist wird dieser Code ausgelöst >*/
		if(p.hasPermission("season.cmd.help")) {
			
				Utils.playerCommandHelpMap(p);
				
		} else {
			
			Utils.err_no_permissions(p, "/help", "Member");
			
		}
		
		return false;
		
	}

}
