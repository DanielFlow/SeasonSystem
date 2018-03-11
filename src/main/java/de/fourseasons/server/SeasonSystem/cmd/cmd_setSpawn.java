package de.fourseasons.server.SeasonSystem.cmd;

import java.io.FileNotFoundException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.fourseasons.server.SeasonSystem.methods.LocationManager;
import de.fourseasons.server.SeasonSystem.methods.Utils;
import net.md_5.bungee.api.ChatColor;

public class cmd_setSpawn implements CommandExecutor{

	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		Player p = (Player) s;
		/*<Checken ob Spieler ein Spieler oder Consolesender ist>*/
		if(!(s instanceof Player)) {	
			Utils.consoleCommandHelpMap(s);	
			return true;
		}
		/*<Falls er ein Spieler ist wird dieser Code ausgelöst >*/
		if(p.hasPermission("season.cmd.setspawn")) {
			
				try {
					LocationManager.saveLocation(p.getLocation(), "spawn");
					p.sendMessage(Utils.prefix + "Du hast den " + ChatColor.GREEN + "Spawn " + ChatColor.GRAY + "gesetzt!.");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		} else {
			
			Utils.err_no_permissions(p, "/setspawn", "Admin");
			
		}
		
		return false;
		
	}

}
