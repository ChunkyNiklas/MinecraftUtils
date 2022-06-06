# MinecraftUtils
Minecraft Utils for Coding

You'll find different JAVA Classes here for Bukkit/Spigot. You can use them in your Project / give credits uwu

#Examples
##LocationAPI
### Initialize
```java
LocationAPI locationAPI;

@Override
public void onEnable() {
	//LocationAPI initialize
	locationAPI = new LocationAPI("TestPlugin","Locations.yml");
}
```

### Usage
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
