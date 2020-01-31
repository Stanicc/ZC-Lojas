package stanic.zclojas.bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import stanic.zclojas.Main;
import stanic.zclojas.bukkit.subcmds.CreateCommand;
import stanic.zclojas.bukkit.subcmds.DeleteCommand;
import stanic.zclojas.factory.ShopFactory;

public class ShopCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) sender.sendMessage("§cUse this only in-game.");
        else {
            Player player = (Player) sender;

            if (args.length == 0) {
                player.sendMessage("");
                player.sendMessage("§aCommands to §b§lZC-SHOP");
                player.sendMessage("");
                player.sendMessage("§e/shop (Player) §7- §fGo to a shop");
                player.sendMessage("§e/shop create §7- §fCreate a shop");
                player.sendMessage("§e/shop delete §7- §fDelete your shop");
                player.sendMessage("");
                return true;
            }

            switch (args[0]) {
                case "create": new CreateCommand().run(player);
                case "delete": new DeleteCommand().run(player);
                default:
                    if (!new ShopFactory().exists(args[0])) player.sendMessage("§cThis player don't have a shop!");
                    else {
                        player.teleport(Main.instance.shop.get(args[0]).getLocation());
                        player.sendMessage("§aYou went to the §f" + args[0] + " §ashop");
                    }
            }
        }
        return false;
    }
}