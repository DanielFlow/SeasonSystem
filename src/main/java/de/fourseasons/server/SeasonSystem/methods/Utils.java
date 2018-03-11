package de.fourseasons.server.SeasonSystem.methods;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

import de.fourseasons.server.SeasonSystem.SeasonSystem;
import de.fourseasons.server.SeasonSystem.cmd.cmd_Feed;
import de.fourseasons.server.SeasonSystem.cmd.cmd_Globalmute;
import de.fourseasons.server.SeasonSystem.cmd.cmd_Heal;
import de.fourseasons.server.SeasonSystem.cmd.cmd_Help;
import de.fourseasons.server.SeasonSystem.cmd.cmd_PvP;
import de.fourseasons.server.SeasonSystem.cmd.cmd_Team;
import de.fourseasons.server.SeasonSystem.cmd.cmd_Tpa;
import de.fourseasons.server.SeasonSystem.cmd.cmd_Tpaccept;
import de.fourseasons.server.SeasonSystem.cmd.cmd_Wartung;
import de.fourseasons.server.SeasonSystem.lst.lst_ChatEvent;
import de.fourseasons.server.SeasonSystem.lst.lst_DamageEvent;
import de.fourseasons.server.SeasonSystem.lst.lst_HelpTopic;
import de.fourseasons.server.SeasonSystem.lst.lst_JoinEvent;
import de.fourseasons.server.SeasonSystem.lst.lst_LoginEvent;
import de.fourseasons.server.SeasonSystem.lst.lst_QuitEvent;
import de.fourseasons.server.SeasonSystem.lst.lst_ServerPingEvent;
import de.fourseasons.server.SeasonSystem.lst.lst_TabEvent;



public class Utils {
	
	
	
	
	public static ChatColor color = ChatColor.GRAY;
	public static ChatColor highlight = ChatColor.GREEN;
	public static ArrayList<Player> onlinestaffplayers = new ArrayList<Player>();
	public static HashMap<Player, Player> tpa = new HashMap<Player, Player>();	
	public static String prefix = ChatColor.GREEN + "Four" + ChatColor.YELLOW + "Seasons " + ChatColor.DARK_GRAY + " » " + color;
	
	public static void err_no_permissions(Player p, String command, String Group) {
		p.sendMessage(prefix + "Du benötigst die gruppe " + highlight + Group + color + " um den Command " + highlight + command + color + " zu benutzen!.");
		
	}
	
	public static void err_musstbea_player(Player p, String command, String Group) {
		p.sendMessage(prefix + "Du benötigst die gruppe " + highlight + Group + color + " um den Command " + highlight + command + color + " zu benutzen!.");
		
	}
	
	public static void err_player_notfound(Player p, String args0) {
		p.sendMessage(prefix + ChatColor.RED + "Der Spieler " + ChatColor.GREEN + args0 + ChatColor.RED + " ist nicht online!");
		
	}
	
	public static void err_invalid_syntax(Player p, String syntax) {
		p.sendMessage(prefix + ChatColor.RED + "Bitte benutze: " + ChatColor.GREEN + syntax);
		
	}
	
	
	public static void register_cmd() {
		SeasonSystem.getInstance().getCommand("feed").setExecutor(new cmd_Feed());
		SeasonSystem.getInstance().getCommand("help").setExecutor(new cmd_Help());
		SeasonSystem.getInstance().getCommand("globalmute").setExecutor(new cmd_Globalmute());
		SeasonSystem.getInstance().getCommand("pvp").setExecutor(new cmd_PvP());
		SeasonSystem.getInstance().getCommand("wartung").setExecutor(new cmd_Wartung());
		SeasonSystem.getInstance().getCommand("team").setExecutor(new cmd_Team());
		SeasonSystem.getInstance().getCommand("heal").setExecutor(new cmd_Heal());
		SeasonSystem.getInstance().getCommand("tpa").setExecutor(new cmd_Tpa());
		SeasonSystem.getInstance().getCommand("tpaccept").setExecutor(new cmd_Tpaccept());


		}
	
	public static void register_lst() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new lst_TabEvent(), SeasonSystem.getInstance());
		pm.registerEvents(new lst_ChatEvent(), SeasonSystem.getInstance());
		pm.registerEvents(new lst_DamageEvent(), SeasonSystem.getInstance());
		pm.registerEvents(new lst_JoinEvent(), SeasonSystem.getInstance());
		pm.registerEvents(new lst_LoginEvent(), SeasonSystem.getInstance());
		pm.registerEvents(new lst_QuitEvent(), SeasonSystem.getInstance());
		pm.registerEvents(new lst_ServerPingEvent(), SeasonSystem.getInstance());
		pm.registerEvents(new lst_HelpTopic(), SeasonSystem.getInstance());

	}
	 
	
	
	
	
	public static String ConsoleErrorPrint(String error, boolean achtung) {
		if(achtung = true) {
			String error_msg = "ACHTUNG | " + error;
			return error_msg;
		}
		
		String error_msg = "SCHWERWIEGEND | " + error;
		return error_msg;
		
	}

	public static void sendSeasonInfo(Player p) {
		
		
		/* <TODO Sende Zum Spieler eine Hilfe Übersicht und Alle Server Commands!>*/
		
		
		
		
	}
	
	
	public static void consoleCommandHelpMap(CommandSender s) {
		s.sendMessage(Utils.prefix + "Du musst ein " + Utils.highlight + "Spieler "+ Utils.color + "sein um diesen Command zu Verwenden!");
		s.sendMessage(" ");
		s.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "Consolen Befehle" + ChatColor.DARK_GRAY + " -]-----");
		s.sendMessage(ChatColor.GREEN + "/Ban " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Bannt einen Spieler vom Server.");
		s.sendMessage(ChatColor.GREEN + "/Kick " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Kickt einen Spieler vom Server.");
		s.sendMessage(ChatColor.GREEN + "/Broadcast " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Sendet eine Globale nachricht an den Server.");
		s.sendMessage(ChatColor.GREEN + "/Reload " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Lädt alle Serverdaten neu, Server lagt für 5 Sek.");
		s.sendMessage(ChatColor.GREEN + "/Stop " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Leitet das Herunterfahren des Servers ein, 5 Sek Countdown.");
		s.sendMessage(ChatColor.GREEN + "/Wartung " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Versetzt den Server in den Wartungs Zustand");
		s.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "Consolen Befehle" + ChatColor.DARK_GRAY + " -]-----");
		
	}
	
	
	
	public static void playerCommandHelpMap(Player p) {
		if(p.hasPermission("season.rang.member")) {
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "Member Befehle" + ChatColor.DARK_GRAY + " -]-----");
			p.sendMessage(ChatColor.GREEN + "/Kit " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet das Kit Inventar");
			p.sendMessage(ChatColor.GREEN + "/sethome " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Setzt ein Home, mit /Home kommst du dahin!.");
			p.sendMessage(ChatColor.GREEN + "/clan " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet Clan Menü.");
			p.sendMessage(ChatColor.GREEN + "/friede " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Frage einen Spieler nach frieden.");
			p.sendMessage(ChatColor.GREEN + "/shop " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Leitet das Herunterfahren des Servers ein, 5 Sek Countdown.");
			p.sendMessage(ChatColor.GREEN + "/spawn " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Teleportiert dich zum Spawn");
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "Member Befehle" + ChatColor.DARK_GRAY + " -]-----");
		} else if(p.hasPermission("season.rang.vip")) {
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "VIP Befehle" + ChatColor.DARK_GRAY + " -]-----");
			p.sendMessage(ChatColor.GREEN + "/tpa " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet das Kit Inventar");
			p.sendMessage(ChatColor.GREEN + "/tpahere " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Setzt ein Home, mit /Home kommst du dahin!.");
			p.sendMessage(ChatColor.GREEN + "/back " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet Clan Menü.");
			p.sendMessage(ChatColor.GREEN + "/Kit VIP " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Frage einen Spieler nach frieden.");
			p.sendMessage(ChatColor.GREEN + "/farben " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Leitet das Herunterfahren des Servers ein, 5 Sek Countdown.");
			p.sendMessage(ChatColor.GREEN + "/spawn " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Teleportiert dich zum Spawn");
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "VIP Befehle" + ChatColor.DARK_GRAY + " -]-----");
		} else if(p.hasPermission("season.rang.elite")) {
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "ELITE Befehle" + ChatColor.DARK_GRAY + " -]-----");
			p.sendMessage(ChatColor.GREEN + "/tpa " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet das Kit Inventar");
			p.sendMessage(ChatColor.GREEN + "/tpahere " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Setzt ein Home, mit /Home kommst du dahin!.");
			p.sendMessage(ChatColor.GREEN + "/back " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet Clan Menü.");
			p.sendMessage(ChatColor.GREEN + "/Kit VIP " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Frage einen Spieler nach frieden.");
			p.sendMessage(ChatColor.GREEN + "/farben " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Leitet das Herunterfahren des Servers ein, 5 Sek Countdown.");
			p.sendMessage(ChatColor.GREEN + "/spawn " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Teleportiert dich zum Spawn");
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "ELITE Befehle" + ChatColor.DARK_GRAY + " -]-----");
		} else if(p.hasPermission("season.rang.pro")) {
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "PRO Befehle" + ChatColor.DARK_GRAY + " -]-----");
			p.sendMessage(ChatColor.GREEN + "/tpa " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet das Kit Inventar");
			p.sendMessage(ChatColor.GREEN + "/tpahere " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Setzt ein Home, mit /Home kommst du dahin!.");
			p.sendMessage(ChatColor.GREEN + "/back " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet Clan Menü.");
			p.sendMessage(ChatColor.GREEN + "/Kit VIP " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Frage einen Spieler nach frieden.");
			p.sendMessage(ChatColor.GREEN + "/farben " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Leitet das Herunterfahren des Servers ein, 5 Sek Countdown.");
			p.sendMessage(ChatColor.GREEN + "/spawn " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Teleportiert dich zum Spawn");
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "PRO Befehle" + ChatColor.DARK_GRAY + " -]-----");
		} else if(p.hasPermission("season.rang.titan")) {
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "TITAN Befehle" + ChatColor.DARK_GRAY + " -]-----");
			p.sendMessage(ChatColor.GREEN + "/tpa " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet das Kit Inventar");
			p.sendMessage(ChatColor.GREEN + "/tpahere " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Setzt ein Home, mit /Home kommst du dahin!.");
			p.sendMessage(ChatColor.GREEN + "/back " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet Clan Menü.");
			p.sendMessage(ChatColor.GREEN + "/Kit VIP " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Frage einen Spieler nach frieden.");
			p.sendMessage(ChatColor.GREEN + "/farben " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Leitet das Herunterfahren des Servers ein, 5 Sek Countdown.");
			p.sendMessage(ChatColor.GREEN + "/spawn " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Teleportiert dich zum Spawn");
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "TITAN Befehle" + ChatColor.DARK_GRAY + " -]-----");
		} else if(p.hasPermission("season.rang.epic")) {
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "EPIC Befehle" + ChatColor.DARK_GRAY + " -]-----");
			p.sendMessage(ChatColor.GREEN + "/tpa " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet das Kit Inventar");
			p.sendMessage(ChatColor.GREEN + "/tpahere " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Setzt ein Home, mit /Home kommst du dahin!.");
			p.sendMessage(ChatColor.GREEN + "/back " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet Clan Menü.");
			p.sendMessage(ChatColor.GREEN + "/Kit VIP " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Frage einen Spieler nach frieden.");
			p.sendMessage(ChatColor.GREEN + "/farben " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Leitet das Herunterfahren des Servers ein, 5 Sek Countdown.");
			p.sendMessage(ChatColor.GREEN + "/spawn " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Teleportiert dich zum Spawn");
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "EPIC Befehle" + ChatColor.DARK_GRAY + " -]-----");
		} else if(p.hasPermission("season.rang.ultra")) {
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "ULTRA Befehle" + ChatColor.DARK_GRAY + " -]-----");
			p.sendMessage(ChatColor.GREEN + "/tpa " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet das Kit Inventar");
			p.sendMessage(ChatColor.GREEN + "/tpahere " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Setzt ein Home, mit /Home kommst du dahin!.");
			p.sendMessage(ChatColor.GREEN + "/back " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet Clan Menü.");
			p.sendMessage(ChatColor.GREEN + "/Kit VIP " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Frage einen Spieler nach frieden.");
			p.sendMessage(ChatColor.GREEN + "/farben " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Leitet das Herunterfahren des Servers ein, 5 Sek Countdown.");
			p.sendMessage(ChatColor.GREEN + "/spawn " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Teleportiert dich zum Spawn");
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "ULTRA Befehle" + ChatColor.DARK_GRAY + " -]-----");
		} else if(p.hasPermission("season.rang.youtuber")) {
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "YOUTUBER Befehle" + ChatColor.DARK_GRAY + " -]-----");
			p.sendMessage(ChatColor.GREEN + "/tpa " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet das Kit Inventar");
			p.sendMessage(ChatColor.GREEN + "/tpahere " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Setzt ein Home, mit /Home kommst du dahin!.");
			p.sendMessage(ChatColor.GREEN + "/back " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet Clan Menü.");
			p.sendMessage(ChatColor.GREEN + "/Kit VIP " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Frage einen Spieler nach frieden.");
			p.sendMessage(ChatColor.GREEN + "/farben " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Leitet das Herunterfahren des Servers ein, 5 Sek Countdown.");
			p.sendMessage(ChatColor.GREEN + "/spawn " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Teleportiert dich zum Spawn");
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "YOUTUBER Befehle" + ChatColor.DARK_GRAY + " -]-----");
		} else if(p.hasPermission("season.rang.streamer")) {
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "STREAMER Befehle" + ChatColor.DARK_GRAY + " -]-----");
			p.sendMessage(ChatColor.GREEN + "/tpa " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet das Kit Inventar");
			p.sendMessage(ChatColor.GREEN + "/tpahere " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Setzt ein Home, mit /Home kommst du dahin!.");
			p.sendMessage(ChatColor.GREEN + "/back " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet Clan Menü.");
			p.sendMessage(ChatColor.GREEN + "/Kit VIP " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Frage einen Spieler nach frieden.");
			p.sendMessage(ChatColor.GREEN + "/farben " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Leitet das Herunterfahren des Servers ein, 5 Sek Countdown.");
			p.sendMessage(ChatColor.GREEN + "/spawn " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Teleportiert dich zum Spawn");
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "STREAMER Befehle" + ChatColor.DARK_GRAY + " -]-----");
		} else {
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "VIP Befehle" + ChatColor.DARK_GRAY + " -]-----");
			p.sendMessage(ChatColor.GREEN + "/tpa " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet das Kit Inventar");
			p.sendMessage(ChatColor.GREEN + "/tpahere " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Setzt ein Home, mit /Home kommst du dahin!.");
			p.sendMessage(ChatColor.GREEN + "/back " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Öffnet Clan Menü.");
			p.sendMessage(ChatColor.GREEN + "/Kit VIP " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Frage einen Spieler nach frieden.");
			p.sendMessage(ChatColor.GREEN + "/farben " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Leitet das Herunterfahren des Servers ein, 5 Sek Countdown.");
			p.sendMessage(ChatColor.GREEN + "/spawn " + ChatColor.DARK_GRAY + "| " + ChatColor.GREEN + "Teleportiert dich zum Spawn");
			p.sendMessage(ChatColor.DARK_GRAY + "-----]- " + ChatColor.GREEN + "VIP Befehle" + ChatColor.DARK_GRAY + " -]-----");
		}
	}
	
	
	
	public static void CommandCooldownMessage(Player p, long secondsLeft, String command) {
		p.sendMessage(prefix + "Du musst noch " + highlight + secondsLeft + color + " Sekunden warten um den Command " + highlight + command + color + " zu benutzen.");
		
	}
	

}
