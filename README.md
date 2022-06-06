# MinecraftUtils
Minecraft Utils for Coding

You'll find different JAVA Classes here for Bukkit/Spigot. You can use them in your Project / give credits uwu

# Examples
## LocationAPI

### Initialize
```java
LocationAPI locationAPI;

@Override
public void onEnable() {
	//LocationAPI initialize
	locationAPI = new LocationAPI("TestPlugin","Locations.yml");
}
```

### Get Location
```java
@EventHandler
public void onJoin(PlayerJoinEvent event) {
	Player player = event.getPlayer();

	// Clear Inventory and Armor
	if(locationAPI.getLocation("Spawn") != null) {
		player.teleport(locationAPI.getLocation("Spawn"));
	}else{
		player.sendMessage("§cNo spawn has been set.");
	}
}
```

### Set Location
```java
@Override
public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	if(sender instanceof Player) {
		if(args.length == 1) {
			String name = args[0];
		// Set the Location
				if(locationAPI.setLocation(((Player) sender).getLocation(), name, true)) {
				sender.sendMessage("Successfully saved location");
			}else
				sender.sendMessage("Could not save Location");
		}else
			sender.sendMessage("Use '/setspawn name'");
	}
	return true;
}
```

