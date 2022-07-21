package fr.myxbox.astshop;

import fr.myxbox.astshop.Commands.OtherEvent;
import fr.myxbox.astshop.Commands.ShopCommand;
import fr.myxbox.astshop.GUI.ShopEvent;
import fr.myxbox.astshop.GUI.ShopGUI;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class AstShop extends JavaPlugin {

    private static AstShop instance;

    public static AstShop getInstance() {
        return instance;
    }

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;

    private ShopGUI gServer;

    @Override
    public void onEnable() {
        instance = this;

        this.gServer = new ShopGUI();

        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        //Listeners
        getServer().getPluginManager().registerEvents(new ShopGUI(), this);
        getServer().getPluginManager().registerEvents(new OtherEvent(), this);
        getServer().getPluginManager().registerEvents(new ShopEvent(), this);

        ///Commands
        getCommand("shop").setExecutor(new ShopCommand());

    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Economy getEconomy() {
        return econ;
    }

    public ShopGUI getPluginGUI() {
        return this.gServer;
    }

}
