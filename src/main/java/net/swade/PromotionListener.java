package net.swade;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.response.FormResponseCustom;
import cn.nukkit.form.window.FormWindowCustom;
import net.lldv.llamaeconomy.LlamaEconomy;
import net.swade.event.PromotionCodeUseEvent;
import net.swade.object.Promotion;

@SuppressWarnings("unused")
public class PromotionListener implements Listener {

    @EventHandler
    public void promotionCodeUse(PromotionCodeUseEvent event) {
        Player player = event.getPlayer();
        Promotion promotion = event.getPromotion();
        player.sendMessage("§aSuccessfully used promo code named §b" + promotion.getCode());
        LlamaEconomy.getAPI().addMoney(player, promotion.getMoney());

    }

    @EventHandler
    public void playerFormResponded(PlayerFormRespondedEvent event){
        if (event.getResponse() == null) return;

        FormWindowCustom form = (FormWindowCustom) event.getWindow();
        FormResponseCustom response = form.getResponse();
        Player player = event.getPlayer();

        if (event.getFormID() == "promotion".hashCode()){
            String code = response.getInputResponse(0);
            if (code == null || code.isEmpty() || code.equals(" ")){
                player.sendMessage("§cThe promo code cannot be empty.");
                return;
            }

            if (!Main.getPromotionConfig().exists(code)) {
                player.sendMessage("§eNo such promo code was found.");
                return;
            }

            Promotion promotion = Promotion.getPromotion(code);
            if (promotion.getPlayers().contains(player.getName().toLowerCase())) {
                player.sendMessage("§eYou have already used this promo code.");
                return;
            }

            if (!promotion.isInfinity() && promotion.getMaxUse() == promotion.getUse()) {
                player.sendMessage("§eThis promo code has reached maximum usage.");
                return;
            }

            promotion.setUse(promotion.getUse() + 1);
            promotion.getPlayers().add(player.getName().toLowerCase());
            promotion.setPlayers(promotion.getPlayers());
            Main.getPromotionConfig().set(code, promotion.toString());
            Main.getPromotionConfig().save();
            PromotionCodeUseEvent promotionCodeUseEvent = new PromotionCodeUseEvent(player, promotion);
            Server.getInstance().getPluginManager().callEvent(promotionCodeUseEvent);
            return;
        }

        if (event.getFormID() == "promotion-create".hashCode()){
            String code = response.getInputResponse(0);
            if (code == null || code.isEmpty() || code.equals(" ")){
                player.sendMessage("§cThe promo code cannot be empty.");
                return;
            }

            if (Main.getPromotionConfig().exists(code)) {
                player.sendMessage("§eThis promo code already exists.");
                return;
            }

            String input = response.getInputResponse(3);

            if (!isDouble(input)){
                player.sendMessage("§eThe value you enter must be a numeric value.");
                return;
            }

            double money = Double.parseDouble(input);

            if (money <= 0){
                player.sendMessage("§eThe value you entered must be greater than 0.");
                return;
            }

            Promotion promotion = Promotion.createPromotion(code, player.getName(), response.getToggleResponse(1), Math.round(response.getSliderResponse(2)), money);
            Main.getPromotionConfig().set(code, promotion.toString());
            Main.getPromotionConfig().save();
            player.sendMessage("§aThe promo code named §f" + code + " §ahas been successfully created.");
        }
    }

    private boolean isDouble(String input) {
        try {
            Double money = Double.valueOf(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
