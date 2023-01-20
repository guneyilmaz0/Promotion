package net.swade.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.element.ElementSlider;
import cn.nukkit.form.element.ElementToggle;
import cn.nukkit.form.window.FormWindowCustom;

import java.util.Arrays;

public class PromotionCommand extends Command {
    public PromotionCommand() {
        super("promotion", "Promotion command");
        setAliases(new String[]{"promo"});
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (commandSender.hasPermission("admin.promo") && strings.length != 0 && Arrays.asList("cr", "create", "create").contains(strings[0])) {
            createPromotionForm((Player) commandSender);
        } else {
            mainForm((Player) commandSender);
        }
        return false;
    }

    private void mainForm(Player player) {
        FormWindowCustom form = new FormWindowCustom("Promotion Code");
        form.addElement(new ElementInput("§3Promotion code here:", "Example: Happy New Year"));
        player.showFormWindow(form, "promotion".hashCode());
    }

    private void createPromotionForm(Player player) {
        FormWindowCustom form = new FormWindowCustom("Promotion Code Create");
        form.addElement(new ElementInput("§3Promotion code here:", "eg. Happy New Year"));
        form.addElement(new ElementToggle("§3Infinity"));
        form.addElement(new ElementSlider("§3Max use", 1, 1000, 1, 5));
        form.addElement(new ElementInput("§3Prize money", "eg. 5000"));
        player.showFormWindow(form, "promotion-create".hashCode());
    }
}