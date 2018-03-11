package de.fourseasons.server.SeasonSystem;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


import de.fourseasons.server.SeasonSystem.methods.Utils;

public class SeasonSystem extends JavaPlugin{
	
	
	public static SeasonSystem instance;
	
	
	public static SeasonSystem getInstance() {
		
		return instance;
	}
	
	@Override
	public void onDisable() {
		System.out.println(Utils.ConsoleErrorPrint("Der Server wird Heruntergefahren, SeasonSystem unloaded!", true));
	}

	@Override
	public void onEnable() {
		instance = this;
		Utils.register_cmd();
		Utils.register_lst();
		onConfig();
		System.out.println(Utils.ConsoleErrorPrint("Der Server wird Gestartet, SeasonSystem wurde geladen!", true));
		
		super.onEnable();
	}

	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
		super.onLoad();
	}
	
	
	public void onConfig() {
		  
	        FileConfiguration cfg = this.getConfig();
	        cfg.options().copyDefaults(true);
	        this.saveDefaultConfig();
	        cfg.addDefault("wartungsmodus", true);
	        cfg.addDefault("pvp", true);
	        cfg.addDefault("globalmute", false);
	        cfg.addDefault("eventmodus", false);
	        this.saveDefaultConfig();
	        this.saveConfig();
	}
	

	

}
