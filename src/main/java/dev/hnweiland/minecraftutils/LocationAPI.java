package dev.hnweiland.minecraftutils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/*
06.06.2022 / Mo.
@Project: MinecraftUtils 
@Author: Niklas, (NlKLAS#0001)...
*/
public class LocationAPI {

	String fileName = "Locations";
	String folderName = "Config";
	File file = new File(
			"plugins//"+folderName+"//",
			fileName+".yml"
	);
	YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

	/**
	 * Save a new Location in the Config.
	 * @param location Location of the Player or so.
	 * @param locationName LocationName to safe in the Config
	 * @param overwrite If the Location is already saved you can overwrite
	 * @return returns true if success, and false if an error occurred.
	 */
	public boolean setLocation(Location location, String locationName, boolean overwrite) {
		if(yamlConfiguration.get(locationName+".World") != null && overwrite
				|| yamlConfiguration.get(locationName+".World") == null) {

			yamlConfiguration.set(locationName+".World", location.getWorld().getName());
			yamlConfiguration.set(locationName+".X", location.getX());
			yamlConfiguration.set(locationName+".Y", location.getY());
			yamlConfiguration.set(locationName+".Z", location.getZ());
			yamlConfiguration.set(locationName+".YAW", location.getYaw());
			yamlConfiguration.set(locationName+".PITCH", location.getPitch());
			try {
				yamlConfiguration.save(file);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}

		}
		return false;

	}

	/**
	 * Get a Location from the Config
	 * @param locationName the Location's Name your using to get the Location from Config
	 * @return will return a new Location including Worldname,XYZ and YAW/PITCH
	 */
	public Location getLocation(String locationName) {
		return new Location(
				Bukkit.getWorld(yamlConfiguration.getString(locationName+".World")),
				yamlConfiguration.getInt(locationName+".X"),
				yamlConfiguration.getInt(locationName+".Y"),
				yamlConfiguration.getInt(locationName+".Z"),
				(float)yamlConfiguration.getDouble(locationName+".YAW"),
				(float)yamlConfiguration.getDouble(locationName+".PITCH")
		);
	}






}
