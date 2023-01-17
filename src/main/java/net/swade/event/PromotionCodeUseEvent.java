package net.swade.event;

import cn.nukkit.Player;
import cn.nukkit.event.plugin.PluginEvent;
import lombok.Getter;
import lombok.Setter;
import net.swade.Main;

public class PromotionCodeUseEvent extends PluginEvent {
    @Getter @Setter private Player player;
    @Getter @Setter private String code;

    public PromotionCodeUseEvent(Player player, String code) {
        super(Main.getInstance());
        setPlayer(player);
        setCode(code);
    }
}
