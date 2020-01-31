package stanic.zclojas.factory.model;

import org.bukkit.Location;

public class Shop {

    String player;
    Location location;

    public Shop(String player, Location location) {
        this.player = player;
        this.location = location;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
