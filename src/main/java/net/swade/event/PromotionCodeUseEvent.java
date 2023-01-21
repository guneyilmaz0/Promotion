package net.swade.event;

import cn.nukkit.Player;
import cn.nukkit.event.plugin.PluginEvent;
import lombok.Getter;
import lombok.Setter;
import net.swade.Main;
import net.swade.object.Promotion;

public class PromotionCodeUseEvent extends PluginEvent {
    @Getter @Setter private Player player;
    @Getter @Setter private Promotion promotion;

    public PromotionCodeUseEvent(Player player, Promotion promotion) {
        super(Main.getInstance());
        setPlayer(player);
        setPromotion(promotion);
    }
}
