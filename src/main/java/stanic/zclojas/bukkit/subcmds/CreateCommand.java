package stanic.zclojas.bukkit.subcmds;

import org.bukkit.entity.Player;
import stanic.zclojas.Main;
import stanic.zclojas.factory.ShopFactory;
import stanic.zclojas.factory.model.Shop;

public class CreateCommand {

    public void run(Player sender) {
        ShopFactory factory = new ShopFactory();

        if (factory.exists(sender.getName())) sender.sendMessage("§cYou already have a shop");
        else {
            Shop model = new Shop(sender.getName(), sender.getLocation());
            Main.instance.shop.put(sender.getName(), model);

            sender.sendMessage("§aShop created!");
        }
    }

}
