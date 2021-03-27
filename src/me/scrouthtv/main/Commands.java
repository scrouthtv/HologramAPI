package me.scrouthtv.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

class Commands {
	protected static boolean createArmorStand(CommandSender sender, Command cmd, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "This command can only be used as a player.");
			return false;
		}
		
		if (args.length < 1) {
			sender.sendMessage(ChatColor.RED + "Please specify a single line to be displayed.");
			return false;
		}
		
		Player p = (Player) sender;
		
		HologramPlugin.instance().createHologram(p.getLocation(), Arrays.stream(args).reduce("", (s1, s2) -> s1 + " " + s2));
		sender.sendMessage(ChatColor.GREEN + "Successfully created a hologram!");
		return true;
	}
}
