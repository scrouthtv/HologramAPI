package me.scrouthtv.main;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nullable;

public class HologramPlugin extends JavaPlugin {
	
	private static HologramPlugin instance;
	
	@Nullable
	public static HologramPlugin instance() {
		return instance;
	}
	
	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
		switch (command.getLabel()) {
			case "holo-create":
				return Commands.createArmorStand(sender, command, args);
			default:
				return false;
		}
	}
	
	@Override
	public void onEnable() {
		getLogger().info(getDescription().getName() + " v" + getDescription().getVersion() + " enabled.");
		instance = this;
	}
	
	@Override
	public void onDisable() {
		getLogger().info(getDescription().getName() + " v" + getDescription().getVersion() + " disabled.");
		instance = null;
	}
	
	public IHologram createHologram(Location position, String line) {
		ArmorStandHologram holo = new ArmorStandHologram(position);
		holo.setLine(line);
		return holo;
	}
}
