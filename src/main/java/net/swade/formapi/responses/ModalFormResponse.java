package net.swade.formapi.responses;

import cn.nukkit.Player;
import cn.nukkit.form.window.FormWindowModal;

public interface ModalFormResponse extends FormResponse {
    void handle(Player paramPlayer, FormWindowModal paramFormWindowModal, int paramInt);
}
