package fr.stan1712.ssi;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.stan1712.ssi.Main;

public class Main extends JavaPlugin implements Listener{

	  public void onEnable()
	  {
	    saveDefaultConfig();
	    
	    System.out.println("[SSI] SmoothServerInfo enabled");
	    
	    PluginManager pm = getServer().getPluginManager();
	    pm.registerEvents(new commands(this), this);
	  }
	  
	  public void onDisable()
	  {
	    System.out.println("[SSI] SmoothServerInfo disabled");
	  }	  
}