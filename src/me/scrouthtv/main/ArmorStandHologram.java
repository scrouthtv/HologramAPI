package me.scrouthtv.main;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

public class ArmorStandHologram implements IHologram {
	
	ArmorStand entity;
	
	ArmorStandHologram(final Location loc) {
		entity = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
		entity.setPersistent(true);
		entity.setVisible(false);
		entity.setInvulnerable(true);
		entity.setGravity(false);
		entity.setInvulnerable(true);
	}
	
	@Override
	public boolean setLine(final String line) {
		entity.setCustomNameVisible(true);
		entity.setCustomName(line);
		return true;
	}
	
	@Override
	public void remove() {
		entity.remove();
	}
}
