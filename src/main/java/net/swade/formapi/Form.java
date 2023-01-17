package net.swade.formapi;

import cn.nukkit.Player;
import cn.nukkit.form.window.FormWindow;
import net.swade.formapi.responses.CustomFormResponse;
import net.swade.formapi.responses.FormResponse;
import net.swade.formapi.responses.ModalFormResponse;
import net.swade.formapi.responses.SimpleFormResponse;

import java.util.HashMap;

public abstract class Form {
    public static HashMap<String, FormResponse> playersForm = new HashMap<>();

    protected FormWindow form;

    public void send(Player player) {
        player.showFormWindow(this.form);
    }

    public static void sendForm(Player player, FormWindow form, ModalFormResponse response) {
        playersForm.put(player.getName(), response);
        player.showFormWindow(form);
    }

    public static void sendForm(Player player, FormWindow form, CustomFormResponse response) {
        playersForm.put(player.getName(), response);
        player.showFormWindow(form);
    }

    public static void sendForm(Player player, FormWindow form, SimpleFormResponse response) {
        playersForm.put(player.getName(), response);
        player.showFormWindow(form);
    }
}
