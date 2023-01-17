package net.swade.formapi.responses;

import cn.nukkit.Player;
import cn.nukkit.form.window.FormWindowSimple;

public interface SimpleFormResponse extends FormResponse {
    void handle(Player paramPlayer, FormWindowSimple paramFormWindowSimple, int paramInt);
}
