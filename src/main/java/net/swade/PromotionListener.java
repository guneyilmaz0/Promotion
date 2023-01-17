package net.swade;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import net.swade.event.PromotionCodeUseEvent;

@SuppressWarnings("unused")
public class PromotionListener implements Listener {

    @EventHandler
    public void onPromotionCodeUse(PromotionCodeUseEvent event) {
        Player player = event.getPlayer();
        String code = event.getCode();
        player.sendMessage("§aSuccessfully used promo code named §"+code);
    }
}
