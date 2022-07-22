package fr.myxbox.astshop.GUI;

import fr.myxbox.astshop.AstShop;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class ShopEvent implements Listener {

    Economy eco = AstShop.getEconomy();

    public static int getAmount(Player arg0, ItemStack arg1) {
        if (arg1 == null)
            return 0;
        int amount = 0;
        for (int i = 0; i < 36; i++) {
            ItemStack slot = arg0.getInventory().getItem(i);
            if (slot == null || !slot.isSimilar(arg1))
                continue;
            amount += slot.getAmount();
        }
        return amount;
    }

    @EventHandler
    public void OnClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();

        if(e.getCurrentItem() == null) return;

        if (e.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE &&
                ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§b>> §cRetour §b<<")) {
            player.closeInventory();
            player.openInventory(AstShop.getInstance().getPluginGUI().HubShop());
        }


        if (e.getView().getTitle().equals("§3>> §2Magasin §3<<")){

            e.setCancelled(true);

            if (e.getCurrentItem().getType() == Material.VILLAGER_SPAWN_EGG &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§aCréatures")) {
                player.closeInventory();
                player.openInventory(AstShop.getInstance().getPluginGUI().MobShop());
            }

            if (e.getCurrentItem().getType() == Material.WHEAT_SEEDS &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§bAgriculture")) {
                player.closeInventory();
                player.openInventory(AstShop.getInstance().getPluginGUI().SeedShop());
            }

            if (e.getCurrentItem().getType() == Material.GRASS_BLOCK &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Bloc")) {
                player.closeInventory();
                player.openInventory(AstShop.getInstance().getPluginGUI().BlocShop(player));
            }

        }

        if (e.getView().getTitle().equals("§3>> §2Créatures §3<<")){

            e.setCancelled(true);

            if (e.getCurrentItem().getType() == Material.COW_SPAWN_EGG &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§aVache")) {
                if (eco.getBalance(player) >= 5) {
                    ItemStack item = new ItemStack(Material.COW_SPAWN_EGG);

                    eco.withdrawPlayer(player, 5);
                    player.getInventory().addItem(item);
                    player.sendRawMessage("§b>> §aAchat effectué ! §b<<");

                } else {

                    player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                }
            }
            if (e.getCurrentItem().getType() == Material.SHEEP_SPAWN_EGG &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§aMouton")) {
                if (eco.getBalance(player) >= 5){
                    ItemStack item = new ItemStack(Material.SHEEP_SPAWN_EGG);

                    eco.withdrawPlayer(player, 5);
                    player.getInventory().addItem(item);
                    player.sendRawMessage("§b>> §aAchat effectué ! §b<<");

                } else {

                    player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                }
            }

            if (e.getCurrentItem().getType() == Material.PIG_SPAWN_EGG &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§aCochon")) {
                if (eco.getBalance(player) >= 5){
                    ItemStack item = new ItemStack(Material.PIG_SPAWN_EGG);

                    eco.withdrawPlayer(player, 5);
                    player.getInventory().addItem(item);
                    player.sendRawMessage("§b>> §aAchat effectué ! §b<<");

                } else {

                    player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                }
            }

            if (e.getCurrentItem().getType() == Material.CHICKEN_SPAWN_EGG &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§aPoule")) {
                if (eco.getBalance(player) >= 5){
                    ItemStack item = new ItemStack(Material.CHICKEN_SPAWN_EGG);

                    eco.withdrawPlayer(player, 5);
                    player.getInventory().addItem(item);
                    player.sendRawMessage("§b>> §aAchat effectué ! §b<<");

                } else {

                    player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                }
            }

            if (e.getCurrentItem().getType() == Material.VILLAGER_SPAWN_EGG &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§aVillageois")) {
                if (eco.getBalance(player) >= 5){
                    ItemStack item = new ItemStack(Material.VILLAGER_SPAWN_EGG);

                    eco.withdrawPlayer(player, 5);
                    player.getInventory().addItem(item);
                    player.sendRawMessage("§b>> §aAchat effectué ! §b<<");

                } else {

                    player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                }
            }

            if (e.getCurrentItem().getType() == Material.ZOMBIE_SPAWN_EGG &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§aZombie")) {
                if (eco.getBalance(player) >= 5){
                    ItemStack item = new ItemStack(Material.ZOMBIE_SPAWN_EGG);

                    eco.withdrawPlayer(player, 10);
                    player.getInventory().addItem(item);
                    player.sendRawMessage("§b>> §aAchat effectué ! §b<<");

                } else {

                    player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                }
            }

            if (e.getCurrentItem().getType() == Material.ZOMBIE_SPAWN_EGG &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§aSquelette")) {
                if (eco.getBalance(player) >= 5){
                    ItemStack item = new ItemStack(Material.ZOMBIE_SPAWN_EGG);

                    eco.withdrawPlayer(player, 10);
                    player.getInventory().addItem(item);
                    player.sendRawMessage("§b>> §aAchat effectué ! §b<<");

                } else {

                    player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                }
            }

        }

        if (e.getView().getTitle().equals("§3>> §bAgriculture §3<<")) {

            e.setCancelled(true);

            if (e.getCurrentItem().getType() == Material.WHEAT_SEEDS &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§bGraines de blé")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.WHEAT_SEEDS)) {

                        int number = getAmount(player, new ItemStack(Material.WHEAT_SEEDS));

                        player.getInventory().removeItem(new ItemStack(Material.WHEAT_SEEDS, number));
                        eco.depositPlayer(player, number * 0.20);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.20 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1) {

                        player.getInventory().addItem(new ItemStack(Material.WHEAT_SEEDS, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 15) {

                        player.getInventory().addItem(new ItemStack(Material.WHEAT_SEEDS, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e15 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.PUMPKIN_SEEDS &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§bGraines de citrouille")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.PUMPKIN_SEEDS)) {

                        int number = getAmount(player, new ItemStack(Material.PUMPKIN_SEEDS));

                        player.getInventory().removeItem(new ItemStack(Material.PUMPKIN_SEEDS, number));
                        eco.depositPlayer(player, number * 0.20);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.20 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1) {

                        player.getInventory().addItem(new ItemStack(Material.PUMPKIN_SEEDS, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 15) {

                        player.getInventory().addItem(new ItemStack(Material.PUMPKIN_SEEDS, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e15 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.MELON_SEEDS &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§bGraines de pastèque")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.MELON_SEEDS)) {

                        int number = getAmount(player, new ItemStack(Material.MELON_SEEDS));

                        player.getInventory().removeItem(new ItemStack(Material.MELON_SEEDS, number));
                        eco.depositPlayer(player, number * 0.20);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.20 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1) {

                        player.getInventory().addItem(new ItemStack(Material.MELON_SEEDS, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 15) {

                        player.getInventory().addItem(new ItemStack(Material.MELON_SEEDS, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e15 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.COCOA_BEANS &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§bGraines de cacao")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.COCOA_BEANS)) {

                        int number = getAmount(player, new ItemStack(Material.COCOA_BEANS));

                        player.getInventory().removeItem(new ItemStack(Material.COCOA_BEANS, number));
                        eco.depositPlayer(player, number * 0.20);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.20 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1) {

                        player.getInventory().addItem(new ItemStack(Material.COCOA_BEANS, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 15) {

                        player.getInventory().addItem(new ItemStack(Material.COCOA_BEANS, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e15 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.BEETROOT_SEEDS &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§bGraines de betterave")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.BEETROOT_SEEDS)) {

                        int number = getAmount(player, new ItemStack(Material.BEETROOT_SEEDS));

                        player.getInventory().removeItem(new ItemStack(Material.BEETROOT_SEEDS, number));
                        eco.depositPlayer(player, number * 0.20);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.20 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1) {

                        player.getInventory().addItem(new ItemStack(Material.BEETROOT_SEEDS, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 15) {

                        player.getInventory().addItem(new ItemStack(Material.BEETROOT_SEEDS, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e15 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.WHEAT &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§bBlé")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.WHEAT)) {

                        int number = getAmount(player, new ItemStack(Material.WHEAT));

                        player.getInventory().removeItem(new ItemStack(Material.WHEAT, number));
                        eco.depositPlayer(player, number * 0.20);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.20 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1) {

                        player.getInventory().addItem(new ItemStack(Material.WHEAT, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 15) {

                        player.getInventory().addItem(new ItemStack(Material.WHEAT, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e15 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.BREAD &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§bPain")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.BREAD)) {

                        int number = getAmount(player, new ItemStack(Material.BREAD));

                        player.getInventory().removeItem(new ItemStack(Material.BREAD, number));
                        eco.depositPlayer(player, number * 0.20);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.20 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1) {

                        player.getInventory().addItem(new ItemStack(Material.BREAD, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 15) {

                        player.getInventory().addItem(new ItemStack(Material.BREAD, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e15 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.APPLE &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§bPomme")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.APPLE)) {

                        int number = getAmount(player, new ItemStack(Material.APPLE));

                        player.getInventory().removeItem(new ItemStack(Material.APPLE, number));
                        eco.depositPlayer(player, number * 0.20);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.20 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1) {

                        player.getInventory().addItem(new ItemStack(Material.APPLE, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 15) {

                        player.getInventory().addItem(new ItemStack(Material.APPLE, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e15 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.MELON_SLICE &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§bTranche de melon")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.MELON_SLICE)) {

                        int number = getAmount(player, new ItemStack(Material.MELON_SLICE));

                        player.getInventory().removeItem(new ItemStack(Material.MELON_SLICE, number));
                        eco.depositPlayer(player, number * 0.20);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.20 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1) {

                        player.getInventory().addItem(new ItemStack(Material.MELON_SLICE, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 15) {

                        player.getInventory().addItem(new ItemStack(Material.MELON_SLICE, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e15 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.POTATO &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§bPomme de terre")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.POTATO)) {

                        int number = getAmount(player, new ItemStack(Material.POTATO));

                        player.getInventory().removeItem(new ItemStack(Material.POTATO, number));
                        eco.depositPlayer(player, number * 0.20);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.20 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1) {

                        player.getInventory().addItem(new ItemStack(Material.POTATO, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 15) {

                        player.getInventory().addItem(new ItemStack(Material.POTATO, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e15 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.CARROT &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§bCarotte")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.CARROT)) {

                        int number = getAmount(player, new ItemStack(Material.CARROT));

                        player.getInventory().removeItem(new ItemStack(Material.CARROT, number));
                        eco.depositPlayer(player, number * 0.20);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.20 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1) {

                        player.getInventory().addItem(new ItemStack(Material.CARROT, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 15) {

                        player.getInventory().addItem(new ItemStack(Material.CARROT, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e15 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.SWEET_BERRIES &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§bBaies sucrées")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.SWEET_BERRIES)) {

                        int number = getAmount(player, new ItemStack(Material.SWEET_BERRIES));

                        player.getInventory().removeItem(new ItemStack(Material.SWEET_BERRIES, number));
                        eco.depositPlayer(player, number * 0.20);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.20 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1) {

                        player.getInventory().addItem(new ItemStack(Material.SWEET_BERRIES, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 15) {

                        player.getInventory().addItem(new ItemStack(Material.SWEET_BERRIES, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e15 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.BEETROOT &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§bBettrave")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.BEETROOT)) {

                        int number = getAmount(player, new ItemStack(Material.BEETROOT));

                        player.getInventory().removeItem(new ItemStack(Material.BEETROOT, number));
                        eco.depositPlayer(player, number * 0.20);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.20 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1) {

                        player.getInventory().addItem(new ItemStack(Material.BEETROOT, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 15) {

                        player.getInventory().addItem(new ItemStack(Material.BEETROOT, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e15 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.MELON &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§bMelon")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.MELON)) {

                        int number = getAmount(player, new ItemStack(Material.MELON));

                        player.getInventory().removeItem(new ItemStack(Material.MELON, number));
                        eco.depositPlayer(player, number * 0.20);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.20 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1) {

                        player.getInventory().addItem(new ItemStack(Material.MELON, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 15) {

                        player.getInventory().addItem(new ItemStack(Material.MELON, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e15 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.PUMPKIN &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§bCitrouille")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.PUMPKIN)) {

                        int number = getAmount(player, new ItemStack(Material.PUMPKIN));

                        player.getInventory().removeItem(new ItemStack(Material.PUMPKIN, number));
                        eco.depositPlayer(player, number * 0.20);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.20 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1) {

                        player.getInventory().addItem(new ItemStack(Material.PUMPKIN, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 15) {

                        player.getInventory().addItem(new ItemStack(Material.PUMPKIN, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e15 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.SUGAR_CANE &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§bCanne à sucre")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.SUGAR_CANE)) {

                        int number = getAmount(player, new ItemStack(Material.SUGAR_CANE));

                        player.getInventory().removeItem(new ItemStack(Material.SUGAR_CANE, number));
                        eco.depositPlayer(player, number * 0.20);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.20 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1) {

                        player.getInventory().addItem(new ItemStack(Material.SUGAR_CANE, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 15) {

                        player.getInventory().addItem(new ItemStack(Material.SUGAR_CANE, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e15 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.EGG &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§bŒuf")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.EGG)) {

                        int number = getAmount(player, new ItemStack(Material.EGG));

                        player.getInventory().removeItem(new ItemStack(Material.EGG, number));
                        eco.depositPlayer(player, number * 0.20);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.20 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1) {

                        player.getInventory().addItem(new ItemStack(Material.EGG, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 15) {

                        player.getInventory().addItem(new ItemStack(Material.EGG, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e15 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }
        }

        if (e.getView().getTitle().equals("§3>> §7Bloc §3<<")) {

            e.setCancelled(true);

            if (e.getCurrentItem().getType() == Material.STONE &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Roche")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.STONE)) {

                        int number = getAmount(player, new ItemStack(Material.STONE));

                        player.getInventory().removeItem(new ItemStack(Material.STONE, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.STONE, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.STONE, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.COBBLESTONE &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Pierres")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.COBBLESTONE)) {

                        int number = getAmount(player, new ItemStack(Material.COBBLESTONE));

                        player.getInventory().removeItem(new ItemStack(Material.COBBLESTONE, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                        } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.STONE, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }


            if (e.getCurrentItem().getType() == Material.GRAVEL &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Gravier")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.GRAVEL)) {

                        int number = getAmount(player, new ItemStack(Material.GRAVEL));

                        player.getInventory().removeItem(new ItemStack(Material.GRAVEL, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.GRAVEL, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.GRAVEL, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }


            if (e.getCurrentItem().getType() == Material.ANDESITE &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Andesite")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.ANDESITE)) {

                        int number = getAmount(player, new ItemStack(Material.ANDESITE));

                        player.getInventory().removeItem(new ItemStack(Material.ANDESITE, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.ANDESITE, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.ANDESITE, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }


            if (e.getCurrentItem().getType() == Material.TUFF &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Tuf")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.TUFF)) {

                        int number = getAmount(player, new ItemStack(Material.TUFF));

                        player.getInventory().removeItem(new ItemStack(Material.TUFF, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.TUFF, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.TUFF, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }


            if (e.getCurrentItem().getType() == Material.DRIPSTONE_BLOCK &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Bloc de spéléothème")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.DRIPSTONE_BLOCK)) {

                        int number = getAmount(player, new ItemStack(Material.DRIPSTONE_BLOCK));

                        player.getInventory().removeItem(new ItemStack(Material.DRIPSTONE_BLOCK, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.DRIPSTONE_BLOCK, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.DRIPSTONE_BLOCK, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }


            if (e.getCurrentItem().getType() == Material.COBBLED_DEEPSLATE &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Pierres des abîmes")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.COBBLED_DEEPSLATE)) {

                        int number = getAmount(player, new ItemStack(Material.COBBLED_DEEPSLATE));

                        player.getInventory().removeItem(new ItemStack(Material.COBBLED_DEEPSLATE, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.COBBLED_DEEPSLATE, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.COBBLED_DEEPSLATE, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                        }
                    }
                }

            if (e.getCurrentItem().getType() == Material.DEEPSLATE &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Adroise des abîmes")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.DEEPSLATE)) {
                        int number = getAmount(player, new ItemStack(Material.DEEPSLATE));

                        player.getInventory().removeItem(new ItemStack(Material.DEEPSLATE, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.DEEPSLATE, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.DEEPSLATE, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.POLISHED_DEEPSLATE &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Adroise des abîmes polie")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.POLISHED_DEEPSLATE)) {

                        int number = getAmount(player, new ItemStack(Material.POLISHED_DEEPSLATE));

                        player.getInventory().removeItem(new ItemStack(Material.POLISHED_DEEPSLATE, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.POLISHED_DEEPSLATE, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.POLISHED_DEEPSLATE, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.POLISHED_ANDESITE &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Andésite polie")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.POLISHED_ANDESITE)) {

                        int number = getAmount(player, new ItemStack(Material.POLISHED_ANDESITE));

                        player.getInventory().removeItem(new ItemStack(Material.POLISHED_ANDESITE, number));
                        eco.depositPlayer(player, number * 0.50);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.20 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.POLISHED_ANDESITE, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.POLISHED_ANDESITE, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.CALCITE &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Calcite")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.CALCITE)) {

                        int number = getAmount(player, new ItemStack(Material.CALCITE));

                        player.getInventory().removeItem(new ItemStack(Material.CALCITE, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.CALCITE, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.CALCITE, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }


            if (e.getCurrentItem().getType() == Material.GRASS_BLOCK &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Bloc d'herbe")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.GRASS_BLOCK)) {

                        int number = getAmount(player, new ItemStack(Material.GRASS_BLOCK));

                        player.getInventory().removeItem(new ItemStack(Material.GRASS_BLOCK, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                            player.getInventory().addItem(new ItemStack(Material.GRASS_BLOCK, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                        } else {

                            player.closeInventory();
                            player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                        }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.GRASS_BLOCK, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }


            if (e.getCurrentItem().getType() == Material.DIRT &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Terre")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.DIRT)) {

                        int number = getAmount(player, new ItemStack(Material.DIRT));

                        player.getInventory().removeItem(new ItemStack(Material.DIRT, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.DIRT, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.DIRT, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }


            if (e.getCurrentItem().getType() == Material.SAND &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Sable")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.SAND)) {

                            int number = getAmount(player, new ItemStack(Material.SAND));

                            player.getInventory().removeItem(new ItemStack(Material.SAND, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                        } else {

                            player.closeInventory();
                            player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                        }

                    } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                        if (eco.getBalance(player) >= 1.50) {

                            player.getInventory().addItem(new ItemStack(Material.SAND, 1));
                            player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                        } else {

                            player.closeInventory();
                            player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                        }

                    } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                        if (eco.getBalance(player) >= 22.5) {

                            player.getInventory().addItem(new ItemStack(Material.SAND, 15));
                            player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                        } else {

                            player.closeInventory();
                            player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                        }
                    }
                }

            if (e.getCurrentItem().getType() == Material.RED_SAND &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Sable rouge")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.RED_SAND)) {
                        int number = getAmount(player, new ItemStack(Material.RED_SAND));

                        player.getInventory().removeItem(new ItemStack(Material.RED_SAND, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.RED_SAND, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.RED_SAND, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }

            }

            if (e.getCurrentItem().getType() == Material.GRANITE &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Granite")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.GRANITE)) {
                        int number = getAmount(player, new ItemStack(Material.GRANITE));

                        player.getInventory().removeItem(new ItemStack(Material.GRANITE, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.GRANITE, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.GRANITE, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }

            }

            if (e.getCurrentItem().getType() == Material.POLISHED_GRANITE &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Granite polie")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.POLISHED_GRANITE)) {
                        int number = getAmount(player, new ItemStack(Material.POLISHED_GRANITE));

                        player.getInventory().removeItem(new ItemStack(Material.POLISHED_GRANITE, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");
                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.POLISHED_GRANITE, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.POLISHED_GRANITE, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.DIORITE &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Diorite")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.DIORITE)) {
                        int number = getAmount(player, new ItemStack(Material.DIORITE));

                        player.getInventory().removeItem(new ItemStack(Material.DIORITE, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.DIORITE, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.DIORITE, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.POLISHED_DIORITE &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Diorite polie")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.POLISHED_DIORITE)) {
                        int number = getAmount(player, new ItemStack(Material.POLISHED_DIORITE));

                        player.getInventory().removeItem(new ItemStack(Material.POLISHED_DIORITE, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.POLISHED_DIORITE, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.POLISHED_DIORITE, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.NETHERRACK &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Netherrack")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.NETHERRACK)) {
                        int number = getAmount(player, new ItemStack(Material.NETHERRACK));

                        player.getInventory().removeItem(new ItemStack(Material.NETHERRACK, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.NETHERRACK, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.NETHERRACK, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.BASALT &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Basalt")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.BASALT)) {
                        int number = getAmount(player, new ItemStack(Material.BASALT));

                        player.getInventory().removeItem(new ItemStack(Material.BASALT, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.BASALT, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.BASALT, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.BLACKSTONE &&
                    ((ItemMeta) Objects.requireNonNull(e.getCurrentItem().getItemMeta())).getDisplayName().equals("§7Roche noire")) {
                if (e.getClick().isRightClick()) {
                    if (player.getInventory().contains(Material.BLACKSTONE)) {
                        int number = getAmount(player, new ItemStack(Material.BLACKSTONE));



                        player.getInventory().removeItem(new ItemStack(Material.BLACKSTONE, number));
                        eco.depositPlayer(player, number * 0.10);
                        player.sendRawMessage("§b>> §aVous venez de vendre §e" + number + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e" + number * 0.10 + " coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas l'item requis !");

                    }

                } else if (e.getClick().isLeftClick() && !(e.getClick().isShiftClick())) {

                    if (eco.getBalance(player) >= 1.50) {

                        player.getInventory().addItem(new ItemStack(Material.BLACKSTONE, 1));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e1" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e1.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }

                } else if (e.getClick().isLeftClick() && e.getClick().isShiftClick()){
                    if (eco.getBalance(player) >= 22.5) {

                        player.getInventory().addItem(new ItemStack(Material.BLACKSTONE, 15));
                        player.sendRawMessage("§b>> §aVous venez d'acheter §e15" + " " + e.getCurrentItem().getItemMeta().getDisplayName() + " §apour §e22.50 coins ! §b<<");

                    } else {

                        player.closeInventory();
                        player.sendMessage("§7§l>> §cVous n'avez pas assez d'argent !");

                    }
                }
            }

        }
    }
}
