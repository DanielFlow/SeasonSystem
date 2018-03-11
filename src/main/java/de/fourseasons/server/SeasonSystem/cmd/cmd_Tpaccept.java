package de.fourseasons.server.SeasonSystem.cmd;



import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.fourseasons.server.SeasonSystem.SeasonSystem;
import de.fourseasons.server.SeasonSystem.methods.Utils;
import net.md_5.bungee.api.ChatColor;

public class cmd_Tpaccept implements CommandExecutor{
	
	
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		/*<Definiere den Spieler>*/
		final Player p = (Player) s;
		/*<Checken ob Spieler ein Spieler oder Consolesender ist>*/
		if(!(s instanceof Player)) {	
			Utils.consoleCommandHelpMap(s);	
			return true;
		}
		/*<Falls er ein Spieler ist wird dieser Code ausgelöst >*/
		if(p.hasPermission("season.cmd.tpa")) {
			
			if(args.length == 0) {
				final Player target = Utils.tpa.get(p);
				target.sendMessage(Utils.prefix + "Du wirst in 3 Sekunden zu " + ChatColor.GREEN + p.getName() + ChatColor.GRAY + " teleportiert.");
				p.sendMessage(Utils.prefix + ChatColor.GREEN + target.getName() + " wird in 3 Sekunden zu dir teleportiert.");

				 new BukkitRunnable() {
				        
			            public void run() {
			              target.teleport(p.getLocation());
			              target.sendMessage(Utils.prefix + "Du wurdest zu " + ChatColor.GREEN + p.getName() + ChatColor.GRAY + "  Teleportiert");
			              p.sendMessage(Utils.prefix + ChatColor.GREEN + p.getName() + ChatColor.GRAY + "  wurde zu dir Teleportiert");
			            }
			            
			        }.runTaskLater(SeasonSystem.getInstance(), 60);
				
				
			} else {
				Utils.err_invalid_syntax(p, "/tpaccept");
			}
			

				
		} else {
			
			Utils.err_no_permissions(p, "/tpaccept", "VIP");
			
		}
		
		return false;
		
	}

}