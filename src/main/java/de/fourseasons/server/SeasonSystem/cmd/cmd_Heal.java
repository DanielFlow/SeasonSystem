package de.fourseasons.server.SeasonSystem.cmd;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import de.fourseasons.server.SeasonSystem.methods.Utils;
import net.md_5.bungee.api.ChatColor;

public class cmd_Heal implements CommandExecutor{
	
	public HashMap<String, Long> feedcooldown = new HashMap<String, Long>();
	
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		/*<Definiere den Spieler>*/
		Player p = (Player) s;
		/*<Checken ob Spieler ein Spieler oder Consolesender ist>*/
		if(!(s instanceof Player)) {	
			Utils.consoleCommandHelpMap(s);	
			return true;
		}
		/*<Falls er ein Spieler ist wird dieser Code ausgelöst >*/
		if(p.hasPermission("season.cmd.heal")) {
			
			if(!p.hasPermission("season.bypass.cooldowns")) {
				if (feedcooldown.containsKey(p.getName())) { // Hier prüfen wir ob der Spieler in der hashmap ist.
					long secondsLeft = ((feedcooldown.get(p.getName()) / 1000) + 1800)- (System.currentTimeMillis() / 1000); // Hier Prüfen wir ob der Spieler noch warten muss ( die + 20 sind die sekunden die der Spieler warten muss (20 sekunden))
					if (secondsLeft > 0) {
						Utils.CommandCooldownMessage(p, secondsLeft, "/heal");
						return true;
					}
				}	
				feedcooldown.put(p.getName(), System.currentTimeMillis());	// Hier fügen wir den aktuellen Timestamp in die Hashmap ein
				p.setHealth(20);
				p.sendMessage(Utils.prefix + "Du wurdest "+ ChatColor.GREEN + "" + ChatColor.BOLD +"geheilt!"+ Utils.color + ".");
			} else {
				p.setHealth(20);
				p.sendMessage(Utils.prefix + "Du wurdest "+ ChatColor.GREEN + "" + ChatColor.BOLD +"geheilt!"+ Utils.color + ".");
			}
	

				
		} else {
			
			Utils.err_no_permissions(p, "/heal", "ELITE");
			
		}
		
		return false;
		
	}

}