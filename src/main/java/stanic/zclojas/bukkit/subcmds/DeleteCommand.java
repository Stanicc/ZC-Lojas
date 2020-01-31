package stanic.zclojas.bukkit.subcmds;

import org.bukkit.entity.Player;
import stanic.zclojas.Main;
import stanic.zclojas.factory.ShopFactory;

public class DeleteCommand {

    public void run(Player sender) {
        ShopFactory factory = new ShopFactory();

        if (!factory.exists(sender.getName())) sender.sendMessage("§cYou don't have a shop!");
        else {
            Main.instance.shop.remove(sender.getName());
            factory.delete(sender.getName());

            sender.sendMessage("§aShop deleted!");
        }
    }

}
