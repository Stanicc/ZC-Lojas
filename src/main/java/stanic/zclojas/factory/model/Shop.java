package stanic.zclojas.factory.model;

import org.bukkit.Location;

public class Shop {

    private String player;
    private Location location;

    public Shop(String player, Location location) {
        this.player = player;
        this.location = location;
    }

    public String getPlayer() {
        return player;
    }

    public Location getLocation() {
        return location;
    }

}
