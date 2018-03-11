package de.fourseasons.server.SeasonSystem.cmd;

import java.io.FileNotFoundException;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.fourseasons.server.SeasonSystem.SeasonSystem;
import de.fourseasons.server.SeasonSystem.methods.LocationManager;
import de.fourseasons.server.SeasonSystem.methods.Utils;

public class cmd_Spawn implements CommandExecutor{

	
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		/*<Register Command Via SeasonSystem.getInstance();>*/
		final Player p = (Player) s;
		/*<Checken ob Spieler ein Spieler oder Consolesender ist>*/
		if(!(s instanceof Player)) {	
			Utils.consoleCommandHelpMap(s);	
			return true;
		}
		/*<Falls er ein Spieler ist wird dieser Code ausgelöst >*/
		if(p.hasPermission("season.cmd.spawn")) {
			
			if(p.hasPermission("season.bypass.cooldowns")) {
				try {
					p.teleport(LocationManager.getLocation("world", "spawn"));
					p.sendMessage(Utils.prefix + "Du wurdest zum " + ChatColor.GREEN + " Spawn " + ChatColor.GRAY + "Teleportiert.");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} else {
				p.sendMessage(Utils.prefix + "Du wirst in " + ChatColor.GREEN + " 3 Sekunden " + ChatColor.GRAY + "zum Spawn Teleportiert.");

				new BukkitRunnable() {
					
		            public void run() {
		            	try {
							p.teleport(LocationManager.getLocation("world", "spawn"));
							p.sendMessage(Utils.prefix + "Du wurdest zum " + ChatColor.GREEN + " Spawn " + ChatColor.GRAY + "Teleportiert.");
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
		            }
		            
		        }.runTaskLater(SeasonSystem.getInstance(), 60);
			}
		
		
				
		} else {
			
			Utils.err_no_permissions(p, "/Spawn", "Member");
			
		}
		
		return false;
		
	}



}