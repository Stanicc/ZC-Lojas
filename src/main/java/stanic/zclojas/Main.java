package stanic.zclojas;

import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import stanic.zclojas.bukkit.ShopCommand;
import stanic.zclojas.database.MongoDB;
import stanic.zclojas.factory.model.Shop;

import java.util.HashMap;

public class Main extends JavaPlugin {

    public static Main instance;

    public MongoDB db;
    public HashMap<String, Shop> shop = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;
        saveResource("settings.yml", false);
        getCommand("shop").setExecutor(new ShopCommand());

        db = new MongoDB();
        db.start();

        loadShops();

        Bukkit.getConsoleSender().sendMessage("§e[ZC-Lojas] &fAtivado!");
    }

    private void loadShops() {
        for (Document shopDocument : db.getDatabase().getCollection("shops").find()) {
            String player = shopDocument.getString("player");
            String[] location = shopDocument.getString("location").split("/");

            double x = Double.parseDouble(location[1]);
            double y = Double.parseDouble(location[2]);
            double z = Double.parseDouble(location[3]);
            float yaw = Float.parseFloat(location[4]);
            float pitch = Float.parseFloat(location[5]);

            Shop model = new Shop(player, new Location(Bukkit.getWorld(location[0]), x, y, z, yaw, pitch));
            shop.put(player, model);
        }
    }

}