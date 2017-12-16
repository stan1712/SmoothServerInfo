package fr.stan1712.ssi;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class commands implements Listener {
	
	private Main main;
	
	public commands(Main smoothinfo)
	{
	  this.main = smoothinfo;
	}

	@EventHandler
	public void onCommandes(PlayerCommandPreprocessEvent e){
	  Player p = e.getPlayer();
	  String msg = e.getMessage();
	  String[] args = msg.split(" ");
  
		if (args[0].equalsIgnoreCase("/ssi")){
			if (p.hasPermission("smoothinfo.main")){
				p.sendMessage(ChatColor.YELLOW + "SmoothServerInfo " + ChatColor.BLUE + "v1.0");
				if(this.main.getConfig().getBoolean("bwebsite") == true ){
					p.sendMessage(ChatColor.BLUE + "/iwebsite");
				}
				if(this.main.getConfig().getBoolean("bdiscord") == true ){
					p.sendMessage(ChatColor.BLUE + "/idiscord");
				}
				if(this.main.getConfig().getBoolean("bforum") == true ){
					p.sendMessage(ChatColor.BLUE + "/iforum");
				}
				if(this.main.getConfig().getBoolean("bteamspeak") == true ){
					p.sendMessage(ChatColor.BLUE + "/iteamspeak");
			}
			e.setCancelled(true);
			}
			else{
				p.sendMessage(this.main.getConfig().getString("messages.no-permission").replace("&", "§"));
			}
		}
		
		if(this.main.getConfig().getBoolean("bwebsite") == true ) {
			if (args[0].equalsIgnoreCase("/iwebsite")){
				if (p.hasPermission("smoothinfo.website")){
					p.sendMessage(this.main.getConfig().getString("messages.show-website").replace("&", "§"));
					p.sendMessage(this.main.getConfig().getString("social.website").replace("&", "§"));
				}
				else{
					p.sendMessage(this.main.getConfig().getString("messages.no-permission").replace("&", "§"));
				}
				e.setCancelled(true);
			}
		}
		  
		if(this.main.getConfig().getBoolean("bdiscord") == true ) {
			if (args[0].equalsIgnoreCase("/idiscord")){
				if (p.hasPermission("smoothinfo.discord")){
					p.sendMessage(this.main.getConfig().getString("messages.show-discord").replace("&", "§"));
					p.sendMessage(this.main.getConfig().getString("social.discord").replace("&", "§"));
				}
				else{
					p.sendMessage(this.main.getConfig().getString("messages.no-permission").replace("&", "§"));
				}
				e.setCancelled(true);
			}
		}
		
		if(this.main.getConfig().getBoolean("bforum") == true ) {
			if (args[0].equalsIgnoreCase("/iforum")){
				if (p.hasPermission("smoothinfo.forum")){
					p.sendMessage(this.main.getConfig().getString("messages.show-forum").replace("&", "§"));
					p.sendMessage(this.main.getConfig().getString("social.forum").replace("&", "§"));
				}
				else{
					p.sendMessage(this.main.getConfig().getString("messages.no-permission").replace("&", "§"));
				}
				e.setCancelled(true);
			}
		}
		
		if(this.main.getConfig().getBoolean("bteamspeak") == true ) {
			if (args[0].equalsIgnoreCase("/iteamspeak")){
				if (p.hasPermission("smoothinfo.teamspeak")){
					p.sendMessage(this.main.getConfig().getString("messages.show-teamspeak").replace("&", "§"));
					p.sendMessage(this.main.getConfig().getString("social.teamspeak").replace("&", "§"));
				}
				else{
					p.sendMessage(this.main.getConfig().getString("messages.no-permission").replace("&", "§"));
				}
				e.setCancelled(true);
			}
		}
	}
}
