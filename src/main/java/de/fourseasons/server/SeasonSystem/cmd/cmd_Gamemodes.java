package de.fourseasons.server.SeasonSystem.cmd;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.fourseasons.server.SeasonSystem.methods.Utils;
import net.md_5.bungee.api.ChatColor;

public class cmd_Gamemodes implements CommandExecutor{

	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		Player p = (Player) s;
		/*<Checken ob Spieler ein Spieler oder Consolesender ist>*/
		if(!(s instanceof Player)) {	
			Utils.consoleCommandHelpMap(s);	
			return true;
		}
		/*<Falls er ein Spieler ist wird dieser Code ausgelöst >*/
		if(p.hasPermission("season.cmd.gamemode")) {
			
				if(args.length == 1) {
					if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(Utils.prefix + "Du hast deinen Spielmodus auf " + ChatColor.GREEN + "" + ChatColor.BOLD + "Survival" + ChatColor.GRAY + " geändert!.");
					}else if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(Utils.prefix + "Du hast deinen Spielmodus auf " + ChatColor.GREEN + "" + ChatColor.BOLD + "Creative" + ChatColor.GRAY + " geändert!.");
					}else if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
						p.setGameMode(GameMode.ADVENTURE);
						p.sendMessage(Utils.prefix + "Du hast deinen Spielmodus auf " + ChatColor.GREEN + "" + ChatColor.BOLD + "Adventure" + ChatColor.GRAY + " geändert!.");
					}else if(args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
						p.setGameMode(GameMode.SPECTATOR);
						p.sendMessage(Utils.prefix + "Du hast deinen Spielmodus auf " + ChatColor.GREEN + "" + ChatColor.BOLD + "Spectator" + ChatColor.GRAY + " geändert!.");
					}
				} else {
					Utils.err_invalid_syntax(p, "/gamemode (1,2,3)");
				}

					
				
		} else {
			
			Utils.err_no_permissions(p, "/gamemode", "Moderator");
			
		}
		
		return false;
		
	}

}
