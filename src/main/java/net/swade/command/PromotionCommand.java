package net.swade.command;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import net.swade.Main;
import net.swade.event.PromotionCodeUseEvent;
import net.swade.formapi.types.CustomForm;
import net.swade.object.Promotion;

public class PromotionCommand extends Command {
    public PromotionCommand() {
        super("promotion", "Promotion command");
        setAliases(new String[]{"promo"});
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (commandSender.hasPermission("admin.promo")) {
            createPromotionForm((Player) commandSender);
        } else {
            mainForm((Player) commandSender);
        }
        return false;
    }

    private void mainForm(Player player) {
        CustomForm form = new CustomForm("Promotion Code");
        form.addInput("§3Promotion code here:", "Example: Happy New Year");
        form.send(player, (paramPlayer, paramFormWindowCustom, list) -> {
            if (list == null) return;
            if (list.get(0) == null || list.get(0).toString().isEmpty()) {
                player.sendMessage("§cThe promo code cannot be empty.");
                return;
            }
            String code = list.get(0).toString();

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

            PromotionCodeUseEvent event = new PromotionCodeUseEvent(player, code);
            Server.getInstance().getPluginManager().callEvent(event);
        });
    }

    private void createPromotionForm(Player player) {
        CustomForm form = new CustomForm("Promotion Code Create");
        form.addInput("Promotion Code:", "Example: Happy New Year");
        form.addToggle("Infinity");
        form.addSlider("Max use", 1, 1000, 1, 5);
        form.send(player, (paramPlayer, paramFormWindowCustom, list) -> {
            if (list == null) return;
            if (list.get(0) == null || list.get(0).toString().isEmpty()) {
                player.sendMessage("§cThe promo code cannot be empty.");
                return;
            }

            String code = list.get(0).toString();
            Promotion promotion = Promotion.createPromotion(code, player.getName(), (boolean) list.get(1), Math.round((float) list.get(2)));
            Main.getPromotionConfig().set(code, promotion.toString());
            Main.getPromotionConfig().save();
            player.sendMessage("§aThe promo code named §f" + code + " §ahas been successfully created.");
        });
    }
}