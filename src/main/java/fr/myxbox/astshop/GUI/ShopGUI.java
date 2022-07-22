package fr.myxbox.astshop.GUI;

import fr.myxbox.astshop.AstShop;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShopGUI implements Listener {

    Economy eco = AstShop.getEconomy();

    public Inventory HubShop() {
        Inventory gui = Bukkit.createInventory(null, 27, "§3>> §2Magasin §3<<");

        ItemStack bloc = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta bloc_meta = bloc.getItemMeta();
        bloc_meta.setDisplayName("§7Bloc");
        bloc.setItemMeta(bloc_meta);

        gui.setItem(1, bloc);

        ItemStack mob = new ItemStack(Material.VILLAGER_SPAWN_EGG);
        ItemMeta mobMeta = mob.getItemMeta();
        mobMeta.setDisplayName("§aCréatures");
        mob.setItemMeta(mobMeta);

        gui.setItem(22, mob);

        ItemStack seed = new ItemStack(Material.WHEAT_SEEDS);
        ItemMeta seedMeta = seed.getItemMeta();
        seedMeta.setDisplayName("§bAgriculture");
        seed.setItemMeta(seedMeta);

        gui.setItem(3, seed);

        return gui;
    }

    public Inventory MobShop() {
        Inventory gui = Bukkit.createInventory(null, 27, "§3>> §2Créatures §3<<");

        int vache_prix = 5;
        int moutons_prix = 5;
        int cochon_prix = 5;
        int poule_prix = 5;
        int villager_prix = 5;
        int zombie_prix = 10;
        int skellette_prix = 10;

        ItemStack vache = new ItemStack(Material.COW_SPAWN_EGG);
        ItemMeta vacheMeta = vache.getItemMeta();
        vacheMeta.setDisplayName("§aVache");
        List<String> vacheLore = new ArrayList<String>();
        vacheLore.add("§7Prix: §f"+vache_prix);
        vacheMeta.setLore(vacheLore);
        vache.setItemMeta(vacheMeta);
        gui.setItem(1, vache);

        ItemStack mouton = new ItemStack(Material.SHEEP_SPAWN_EGG);
        ItemMeta moutonMeta = mouton.getItemMeta();
        moutonMeta.setDisplayName("§aMouton");
        List<String> moutonLore = new ArrayList<String>();
        moutonLore.add("§7Prix: §f"+moutons_prix);
        moutonMeta.setLore(moutonLore);
        mouton.setItemMeta(moutonMeta);
        gui.setItem(3, mouton);

        ItemStack cochon = new ItemStack(Material.PIG_SPAWN_EGG);
        ItemMeta cochonMeta = cochon.getItemMeta();
        cochonMeta.setDisplayName("§aCochon");
        List<String> cochonLore = new ArrayList<String>();
        cochonLore.add("§7Prix: §f"+cochon_prix);
        cochonMeta.setLore(cochonLore);
        cochon.setItemMeta(cochonMeta);
        gui.setItem(5, cochon);

        ItemStack poule = new ItemStack(Material.CHICKEN_SPAWN_EGG);
        ItemMeta pouleMeta = poule.getItemMeta();
        pouleMeta.setDisplayName("§aPoule");
        List<String> pouleLore = new ArrayList<String>();
        pouleLore.add("§7Prix: §f"+poule_prix);
        pouleMeta.setLore(pouleLore);
        poule.setItemMeta(pouleMeta);
        gui.setItem(7, poule);

        ItemStack vil = new ItemStack(Material.VILLAGER_SPAWN_EGG);
        ItemMeta vilMeta = vil.getItemMeta();
        vilMeta.setDisplayName("§aVillageois");
        List<String> vilLore = new ArrayList<String>();
        vilLore.add("§7Prix: §f"+villager_prix);
        vilMeta.setLore(vilLore);
        vil.setItemMeta(vilMeta);
        gui.setItem(10, vil);

        ItemStack zom = new ItemStack(Material.ZOMBIE_SPAWN_EGG);
        ItemMeta zomMeta = zom.getItemMeta();
        zomMeta.setDisplayName("§aZombie");
        List<String> zomLore = new ArrayList<String>();
        zomLore.add("§7Prix: §f"+zombie_prix);
        zomMeta.setLore(zomLore);
        zom.setItemMeta(zomMeta);
        gui.setItem(12, zom);

        ItemStack skel = new ItemStack(Material.SKELETON_SPAWN_EGG);
        ItemMeta skelMeta = skel.getItemMeta();
        skelMeta.setDisplayName("§aSquelette");
        List<String> skelLore = new ArrayList<String>();
        skelLore.add("§7Prix: §f"+skellette_prix);
        skelMeta.setLore(skelLore);
        skel.setItemMeta(skelMeta);
        gui.setItem(14, skel);

        return gui;
    }

    public Inventory SeedShop() {
        Inventory gui = Bukkit.createInventory(null, 54, "§3>> §bAgriculture §3<<");

        String seed_sell = "0.20";
        String seed_buy = "1";

        ItemStack wheat = new ItemStack(Material.WHEAT_SEEDS);
        ItemMeta wheat_meta = wheat.getItemMeta();
        wheat_meta.setDisplayName("§bGraines de blé");
        List<String> wheat_lore = new ArrayList<String>();
        wheat_lore.add("§7Vendre (clique droit): §f"+seed_sell);
        wheat_lore.add("§7Acheter (clique gauche): §f"+seed_buy);
        wheat_meta.setLore(wheat_lore);
        wheat.setItemMeta(wheat_meta);

        gui.setItem(0, wheat);

        ItemStack pumpkins = new ItemStack(Material.PUMPKIN_SEEDS);
        ItemMeta pumpkins_meta = pumpkins.getItemMeta();
        pumpkins_meta.setDisplayName("§bGraines de citrouille");
        List<String> pumpkins_lore = new ArrayList<String>();
        pumpkins_lore.add("§7Vendre (clique droit): §f"+seed_sell);
        pumpkins_lore.add("§7Acheter (clique gauche): §f"+seed_buy);
        pumpkins_meta.setLore(pumpkins_lore);
        pumpkins.setItemMeta(pumpkins_meta);

        gui.setItem(2, pumpkins);

        ItemStack melons = new ItemStack(Material.MELON_SEEDS);
        ItemMeta melons_meta = melons.getItemMeta();
        melons_meta.setDisplayName("§bGraines de pastèque");
        List<String> melons_lore = new ArrayList<String>();
        melons_lore.add("§7Vendre (clique droit): §f"+seed_sell);
        melons_lore.add("§7Acheter (clique gauche): §f"+seed_buy);
        melons_meta.setLore(melons_lore);
        melons.setItemMeta(melons_meta);

        gui.setItem(4, melons);

        ItemStack cocoas = new ItemStack(Material.COCOA_BEANS);
        ItemMeta cocoas_meta = cocoas.getItemMeta();
        cocoas_meta.setDisplayName("§bGraines de cacao");
        List<String> cocoas_lore = new ArrayList<String>();
        cocoas_lore.add("§7Vendre (clique droit): §f"+seed_sell);
        cocoas_lore.add("§7Acheter (clique gauche): §f"+seed_buy);
        cocoas_meta.setLore(cocoas_lore);
        cocoas.setItemMeta(cocoas_meta);

        gui.setItem(6, cocoas);

        ItemStack bees = new ItemStack(Material.BEETROOT_SEEDS);
        ItemMeta bees_meta = bees.getItemMeta();
        bees_meta.setDisplayName("§bGraines de betterave");
        List<String> bees_lore = new ArrayList<String>();
        bees_lore.add("§7Vendre (clique droit): §f"+seed_sell);
        bees_lore.add("§7Acheter (clique gauche): §f"+seed_buy);
        bees_meta.setLore(bees_lore);
        bees.setItemMeta(bees_meta);

        gui.setItem(8, bees);

        ItemStack ble = new ItemStack(Material.WHEAT);
        ItemMeta ble_meta = ble.getItemMeta();
        ble_meta.setDisplayName("§bBlé");
        List<String> ble_lore = new ArrayList<String>();
        ble_lore.add("§7Vendre (clique droit): §f"+seed_sell);
        ble_lore.add("§7Acheter (clique gauche): §f"+seed_buy);
        ble_meta.setLore(ble_lore);
        ble.setItemMeta(ble_meta);

        gui.setItem(18, ble);

        ItemStack bread = new ItemStack(Material.BREAD);
        ItemMeta bread_meta = bread.getItemMeta();
        bread_meta.setDisplayName("§bPain");
        List<String> bread_lore = new ArrayList<String>();
        bread_lore.add("§7Vendre (clique droit): §f"+seed_sell);
        bread_lore.add("§7Acheter (clique gauche): §f"+seed_buy);
        bread_meta.setLore(bread_lore);
        bread.setItemMeta(bread_meta);

        gui.setItem(20, bread);

        ItemStack pomme = new ItemStack(Material.APPLE);
        ItemMeta pomme_meta = pomme.getItemMeta();
        pomme_meta.setDisplayName("§bPomme");
        List<String> pomme_lore = new ArrayList<String>();
        pomme_lore.add("§7Vendre (clique droit): §f"+seed_sell);
        pomme_lore.add("§7Acheter (clique gauche): §f"+seed_buy);
        pomme_meta.setLore(pomme_lore);
        pomme.setItemMeta(pomme_meta);

        gui.setItem(22, pomme);

        ItemStack tpas = new ItemStack(Material.MELON_SLICE);
        ItemMeta tpas_meta = tpas.getItemMeta();
        tpas_meta.setDisplayName("§bTranche de melon");
        List<String> tpas_lore = new ArrayList<String>();
        tpas_lore.add("§7Vendre (clique droit): §f"+seed_sell);
        tpas_lore.add("§7Acheter (clique gauche): §f"+seed_buy);
        tpas_meta.setLore(tpas_lore);
        tpas.setItemMeta(tpas_meta);

        gui.setItem(24, tpas);

        ItemStack patate = new ItemStack(Material.POTATO);
        ItemMeta patate_meta = patate.getItemMeta();
        patate_meta.setDisplayName("§bPomme de terre");
        List<String> patate_lore = new ArrayList<String>();
        patate_lore.add("§7Vendre (clique droit): §f"+seed_sell);
        patate_lore.add("§7Acheter (clique gauche): §f"+seed_buy);
        patate_meta.setLore(patate_lore);
        patate.setItemMeta(patate_meta);

        gui.setItem(26, patate);

        ItemStack carrot = new ItemStack(Material.CARROT);
        ItemMeta carrot_meta = carrot.getItemMeta();
        carrot_meta.setDisplayName("§bCarotte");
        List<String> carrot_lore = new ArrayList<String>();
        carrot_lore.add("§7Vendre (clique droit): §f"+seed_sell);
        carrot_lore.add("§7Acheter (clique gauche): §f"+seed_buy);
        carrot_meta.setLore(carrot_lore);
        carrot.setItemMeta(carrot_meta);

        gui.setItem(27, carrot);

        ItemStack sweet = new ItemStack(Material.SWEET_BERRIES);
        ItemMeta sweet_meta = sweet.getItemMeta();
        sweet_meta.setDisplayName("§bBaies sucrées");
        List<String> sweet_lore = new ArrayList<String>();
        sweet_lore.add("§7Vendre (clique droit): §f"+seed_sell);
        sweet_lore.add("§7Acheter (clique gauche): §f"+seed_buy);
        sweet_meta.setLore(sweet_lore);
        sweet.setItemMeta(sweet_meta);

        gui.setItem(29, sweet);

        ItemStack bet = new ItemStack(Material.BEETROOT);
        ItemMeta bet_meta = bet.getItemMeta();
        bet_meta.setDisplayName("§bBettrave");
        List<String> bet_lore = new ArrayList<String>();
        bet_lore.add("§7Vendre (clique droit): §f"+seed_sell);
        bet_lore.add("§7Acheter (clique gauche): §f"+seed_buy);
        bet_meta.setLore(bet_lore);
        bet.setItemMeta(bet_meta);

        gui.setItem(31, bet);

        ItemStack past = new ItemStack(Material.MELON);
        ItemMeta past_meta = past.getItemMeta();
        past_meta.setDisplayName("§bMelon");
        List<String> past_lore = new ArrayList<String>();
        past_lore.add("§7Vendre (clique droit): §f"+seed_sell);
        past_lore.add("§7Acheter (clique gauche): §f"+seed_buy);
        past_meta.setLore(past_lore);
        past.setItemMeta(past_meta);

        gui.setItem(45, past);

        ItemStack cit = new ItemStack(Material.PUMPKIN);
        ItemMeta cit_meta = cit.getItemMeta();
        cit_meta.setDisplayName("§bCitrouille");
        List<String> cit_lore = new ArrayList<String>();
        cit_lore.add("§7Vendre (clique droit): §f"+seed_sell);
        cit_lore.add("§7Acheter (clique gauche): §f"+seed_buy);
        cit_meta.setLore(cit_lore);
        cit.setItemMeta(cit_meta);

        gui.setItem(47, cit);

        ItemStack sug = new ItemStack(Material.SUGAR_CANE);
        ItemMeta sug_meta = sug.getItemMeta();
        sug_meta.setDisplayName("§bCanne à sucre");
        List<String> sug_lore = new ArrayList<String>();
        sug_lore.add("§7Vendre (clique droit): §f"+seed_sell);
        sug_lore.add("§7Acheter (clique gauche): §f"+seed_buy);
        sug_meta.setLore(sug_lore);
        sug.setItemMeta(sug_meta);

        gui.setItem(49, sug);

        ItemStack egg = new ItemStack(Material.EGG);
        ItemMeta egg_meta = egg.getItemMeta();
        egg_meta.setDisplayName("§bŒuf");
        List<String> egg_lore = new ArrayList<String>();
        egg_lore.add("§7Vendre (clique droit): §f"+seed_sell);
        egg_lore.add("§7Acheter (clique gauche): §f"+seed_buy);
        egg_meta.setLore(egg_lore);
        egg.setItemMeta(egg_meta);

        gui.setItem(51, egg);

        return gui;
    }

    public Inventory BlocShop(Player user) {
        Inventory gui = Bukkit.createInventory(null, 54, "§3>> §7Bloc §3<<");

        String bloc_sell = "0.10";
        String bloc_buy = "1.50";
        //---------------------------------------------------
        ItemStack vitre = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta vitre_meta = vitre.getItemMeta();
        vitre_meta.setDisplayName(" ");
        vitre.setItemMeta(vitre_meta);

        ItemStack back = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta player_meta = back.getItemMeta();
        player_meta.setDisplayName("§b>> §cRetour §b<<");
        back.setItemMeta(player_meta);

        ItemStack player = new ItemStack(Material.SKELETON_SKULL);
        ItemMeta pl_meta = player.getItemMeta();
        pl_meta.setDisplayName("§b>> §eVotre compte §b<<");
        List<String> player_lore = new ArrayList<String>();
        player_lore.add("§7Votre balance: §f"+AstShop.getEconomy().getBalance(user, null));
        pl_meta.setLore(player_lore);
        player.setItemMeta(pl_meta);

        gui.setItem(0, back);
        gui.setItem(1, vitre);
        gui.setItem(2, vitre);
        gui.setItem(3, vitre);
        gui.setItem(4, player);
        gui.setItem(5, vitre);
        gui.setItem(6, vitre);
        gui.setItem(7, vitre);
        gui.setItem(8, vitre);
        //---------------------------------------------------

        ItemStack stone = new ItemStack(Material.STONE);
        ItemMeta stone_meta = stone.getItemMeta();
        stone_meta.setDisplayName("§7Roche");
        List<String> stone_lore = new ArrayList<String>();
        stone_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        stone_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        stone_meta.setLore(stone_lore);
        stone.setItemMeta(stone_meta);

        gui.setItem(9, stone);

        ItemStack cobble = new ItemStack(Material.COBBLESTONE);
        ItemMeta cobble_meta = cobble.getItemMeta();
        cobble_meta.setDisplayName("§7Pierres");
        List<String> cobble_lore = new ArrayList<String>();
        cobble_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        cobble_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        cobble_meta.setLore(cobble_lore);
        cobble.setItemMeta(cobble_meta);

        gui.setItem(10, cobble);

        ItemStack gravel = new ItemStack(Material.GRAVEL);
        ItemMeta gravel_meta = gravel.getItemMeta();
        gravel_meta.setDisplayName("§7Gravier");
        List<String> gravel_lore = new ArrayList<String>();
        gravel_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        gravel_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        gravel_meta.setLore(gravel_lore);
        gravel.setItemMeta(gravel_meta);

        gui.setItem(11, gravel);

        ItemStack and = new ItemStack(Material.ANDESITE);
        ItemMeta and_meta = and.getItemMeta();
        and_meta.setDisplayName("§7Andesite");
        List<String> and_lore = new ArrayList<String>();
        and_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        and_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        and_meta.setLore(and_lore);
        and.setItemMeta(and_meta);

        gui.setItem(12, and);

        ItemStack tuf = new ItemStack(Material.TUFF);
        ItemMeta tuf_meta = tuf.getItemMeta();
        tuf_meta.setDisplayName("§7Tuf");
        List<String> tuf_lore = new ArrayList<String>();
        tuf_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        tuf_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        tuf_meta.setLore(tuf_lore);
        tuf.setItemMeta(tuf_meta);

        gui.setItem(13, tuf);

        ItemStack sph = new ItemStack(Material.DRIPSTONE_BLOCK);
        ItemMeta sph_meta = sph.getItemMeta();
        sph_meta.setDisplayName("§7Bloc de spéléothème");
        List<String> sph_lore = new ArrayList<String>();
        sph_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        sph_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        sph_meta.setLore(sph_lore);
        sph.setItemMeta(sph_meta);

        gui.setItem(14, sph);

        ItemStack ab = new ItemStack(Material.COBBLED_DEEPSLATE);
        ItemMeta ab_meta = ab.getItemMeta();
        ab_meta.setDisplayName("§7Pierres des abîmes");
        List<String> ab_lore = new ArrayList<String>();
        ab_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        ab_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        ab_meta.setLore(ab_lore);
        ab.setItemMeta(ab_meta);

        gui.setItem(15, ab);

        ItemStack ard = new ItemStack(Material.DEEPSLATE);
        ItemMeta ard_meta = ard.getItemMeta();
        ard_meta.setDisplayName("§7Adroise des abîmes");
        List<String> ard_lore = new ArrayList<String>();
        ard_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        ard_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        ard_meta.setLore(ard_lore);
        ard.setItemMeta(ard_meta);

        gui.setItem(16, ard);

        ItemStack ardp = new ItemStack(Material.POLISHED_DEEPSLATE);
        ItemMeta ardp_meta = ardp.getItemMeta();
        ardp_meta.setDisplayName("§7Adroise des abîmes polie");
        List<String> ardp_lore = new ArrayList<String>();
        ardp_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        ardp_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        ardp_meta.setLore(ardp_lore);
        ardp.setItemMeta(ardp_meta);

        gui.setItem(17, ardp);

        ItemStack andp = new ItemStack(Material.POLISHED_ANDESITE);
        ItemMeta andp_meta = andp.getItemMeta();
        andp_meta.setDisplayName("§7Andésite polie");
        List<String> andp_lore = new ArrayList<String>();
        andp_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        andp_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        andp_meta.setLore(andp_lore);
        andp.setItemMeta(andp_meta);

        gui.setItem(18, andp);

        ItemStack cal = new ItemStack(Material.CALCITE);
        ItemMeta cal_meta = cal.getItemMeta();
        cal_meta.setDisplayName("§7Calcite");
        List<String> cal_lore = new ArrayList<String>();
        cal_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        cal_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        cal_meta.setLore(cal_lore);
        cal.setItemMeta(cal_meta);

        gui.setItem(19, cal);

        ItemStack diorite = new ItemStack(Material.DIORITE);
        ItemMeta diorite_meta = diorite.getItemMeta();
        diorite_meta.setDisplayName("§7Diorite");
        List<String> diorite_lore = new ArrayList<String>();
        diorite_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        diorite_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        diorite_meta.setLore(diorite_lore);
        diorite.setItemMeta(diorite_meta);

        gui.setItem(20, diorite);

        ItemStack dpolie = new ItemStack(Material.POLISHED_DIORITE);
        ItemMeta dpolie_meta = dpolie.getItemMeta();
        dpolie_meta.setDisplayName("§7Diorite polie");
        List<String> dpolie_lore = new ArrayList<String>();
        dpolie_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        dpolie_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        dpolie_meta.setLore(dpolie_lore);
        dpolie.setItemMeta(dpolie_meta);

        gui.setItem(21, dpolie);

        ItemStack granite = new ItemStack(Material.GRANITE);
        ItemMeta granite_meta = granite.getItemMeta();
        granite_meta.setDisplayName("§7Granite");
        List<String> granite_lore = new ArrayList<String>();
        granite_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        granite_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        granite_meta.setLore(granite_lore);
        granite.setItemMeta(granite_meta);

        gui.setItem(22, granite);

        ItemStack gpolie = new ItemStack(Material.POLISHED_GRANITE);
        ItemMeta gpolie_meta = gpolie.getItemMeta();
        granite_meta.setDisplayName("§7Granite polie");
        List<String> gpolie_lore = new ArrayList<String>();
        gpolie_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        gpolie_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        granite_meta.setLore(gpolie_lore);
        gpolie.setItemMeta(granite_meta);

        gui.setItem(23, gpolie);

        ItemStack neth = new ItemStack(Material.NETHERRACK);
        ItemMeta neth_meta = neth.getItemMeta();
        neth_meta.setDisplayName("§7Netherrack");
        List<String> neth_lore = new ArrayList<String>();
        neth_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        neth_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        neth_meta.setLore(neth_lore);
        neth.setItemMeta(neth_meta);

        gui.setItem(24, neth);

        ItemStack bas = new ItemStack(Material.BASALT);
        ItemMeta bas_meta = bas.getItemMeta();
        bas_meta.setDisplayName("§7Basalt");
        List<String> bas_lore = new ArrayList<String>();
        bas_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        bas_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        bas_meta.setLore(bas_lore);
        bas.setItemMeta(bas_meta);

        gui.setItem(25, bas);

        ItemStack rochn = new ItemStack(Material.BLACKSTONE);
        ItemMeta rochn_meta = rochn.getItemMeta();
        rochn_meta.setDisplayName("§7Roche noire");
        List<String> rochn_lore = new ArrayList<String>();
        rochn_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        rochn_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        rochn_meta.setLore(rochn_lore);
        rochn.setItemMeta(rochn_meta);

        gui.setItem(26, rochn);


        ItemStack gra = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta gra_meta = gra.getItemMeta();
        gra_meta.setDisplayName("§7Bloc d'herbe");
        List<String> gra_lore = new ArrayList<String>();
        gra_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        gra_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        gra_meta.setLore(gra_lore);
        gra.setItemMeta(gra_meta);

        gui.setItem(36, gra);

        ItemStack dirt = new ItemStack(Material.DIRT);
        ItemMeta dirt_meta = dirt.getItemMeta();
        dirt_meta.setDisplayName("§7Terre");
        List<String> dirt_lore = new ArrayList<String>();
        dirt_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        dirt_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        dirt_meta.setLore(dirt_lore);
        dirt.setItemMeta(dirt_meta);

        gui.setItem(37, dirt);

        ItemStack sand = new ItemStack(Material.SAND);
        ItemMeta sand_meta = sand.getItemMeta();
        sand_meta.setDisplayName("§7Sable");
        List<String> sand_lore = new ArrayList<String>();
        sand_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        sand_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        sand_meta.setLore(sand_lore);
        sand.setItemMeta(sand_meta);

        gui.setItem(38, sand);
        ItemStack sandr = new ItemStack(Material.RED_SAND);
        ItemMeta sandr_meta = sandr.getItemMeta();
        sandr_meta.setDisplayName("§7Sable rouge");
        List<String> sandr_lore = new ArrayList<String>();
        sandr_lore.add("§7Vendre (clique droit): §f"+bloc_sell);
        sandr_lore.add("§7Acheter (clique gauche): §f"+bloc_buy);
        sandr_meta.setLore(sandr_lore);
        sandr.setItemMeta(sandr_meta);

        gui.setItem(39, sandr);


        return gui;
    }


}
