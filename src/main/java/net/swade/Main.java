package net.swade;

import cn.nukkit.command.CommandMap;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import lombok.Getter;
import lombok.Setter;
import net.swade.command.PromotionCommand;
import net.swade.formapi.FormListener;

public class Main extends PluginBase {

    @Getter @Setter private static Main instance;
    @Getter @Setter private static Config promotionConfig;

    @Override
    public void onLoad() {
        setInstance(this);
    }

    @Override
    public void onEnable() {
        saveResource("promotions.json");
        setPromotionConfig(new Config(getDataFolder().getPath() + "/promotions.json"));
        getServer().getPluginManager().registerEvents(new FormListener(), this);
        CommandMap commandMap = getServer().getCommandMap();
        commandMap.register("promotion", new PromotionCommand());
        getServer().getPluginManager().registerEvents(new PromotionListener(), this);
        getLogger().info("§aSuccessfully loaded.\n§cAuthor: §bGuneyYilmaz0\n§cDiscord: §bGüney#0001");
    }

    @Override
    public void onDisable() {
        getPromotionConfig().save();
    }
}