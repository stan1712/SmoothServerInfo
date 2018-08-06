package fr.stan1712.ssi;

import java.io.File;
import java.io.IOException;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.stan1712.ssi.Main;

public class Main extends JavaPlugin implements Listener{

	  public void onEnable()
	  {
	    saveDefaultConfig();
	    
	    System.out.println("[SSI] SmoothServerInfo enabled");
	    if(getConfig().getBoolean("bwebsite") == true ) {
	    	System.out.println("[SSI] /website command loaded !");
	    }
	    if(getConfig().getBoolean("bdiscord") == true ) {
	    	System.out.println("[SSI] /discord command loaded !");
	    }
	    if(getConfig().getBoolean("bforum") == true ) {
	    	System.out.println("[SSI] /forum command loaded !");
	    }
	    if(getConfig().getBoolean("bteamspeak") == true ) {
	    	System.out.println("[SSI] /teamspeak command loaded !");
	    }
	    
		File direct = new File("plugins/SmoothServerInfo");
		if(!direct.exists())
		{
			direct.mkdir();
			System.out.println("[SSI] 'SmoothServerInfo' directory created !");
		}
		File config = new File("plugins/SmoothServerInfo", "config.yml");
		if (!config.exists()) {
			try {
				config.createNewFile();
				
				System.out.println("[SSI] 'config.yml' created !");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	    
	    PluginManager pm = getServer().getPluginManager();
	    pm.registerEvents(new commands(this), this);
	  }
	  
	  public void onDisable()
	  {
	    System.out.println("[SSI] SmoothServerInfo disabled");
	  }	  
}