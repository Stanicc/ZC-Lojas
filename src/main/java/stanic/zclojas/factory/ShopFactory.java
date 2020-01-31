package stanic.zclojas.factory;

import org.bson.Document;
import stanic.zclojas.Main;
import stanic.zclojas.factory.model.Shop;

import java.util.ArrayList;

public class ShopFactory {

    public Boolean exists(String nick) {
        return Main.instance.shop.containsKey(nick);
    }

    public void save() {
        for (Shop shop : new ArrayList<>(Main.instance.shop.values())) {
            String world = shop.getLocation().getWorld().getName();
            Double x = shop.getLocation().getX();
            Double y = shop.getLocation().getY();
            Double z = shop.getLocation().getZ();
            Float yaw = shop.getLocation().getYaw();
            Float pitch = shop.getLocation().getPitch();

            Document document = new Document("player", shop.getPlayer()).append("location", String.format("%s/%s/%s/%s/%s/%s", world, x, y, z, yaw, pitch));
            Main.instance.db.getDatabase().getCollection("shops").insertOne(document);
        }
    }

    public void delete(String nick) {
        if (exists(nick)) {
            Shop shop = Main.instance.shop.get(nick);

            String world = shop.getLocation().getWorld().getName();
            Double x = shop.getLocation().getX();
            Double y = shop.getLocation().getY();
            Double z = shop.getLocation().getZ();
            Float yaw = shop.getLocation().getYaw();
            Float pitch = shop.getLocation().getPitch();

            Document document = new Document("player", shop.getPlayer()).append("location", String.format("%s/%s/%s/%s/%s/%s", world, x, y, z, yaw, pitch));
            Main.instance.db.getDatabase().getCollection("shops").findOneAndDelete(document);
        }
    }

}