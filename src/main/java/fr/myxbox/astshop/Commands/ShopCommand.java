package fr.myxbox.astshop.Commands;

import fr.myxbox.astshop.AstShop;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ShopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;

            player.openInventory(AstShop.getInstance().getPluginGUI().HubShop());

        } else {

            sender.sendMessage("Vous ne pouvez pas faire cette commande dans la console !");

        }

        return false;
    }
}
