package net.swade.formapi.responses;

import cn.nukkit.Player;
import cn.nukkit.form.window.FormWindowCustom;

import java.util.List;

public interface CustomFormResponse extends FormResponse {
    void handle(Player paramPlayer, FormWindowCustom paramFormWindowCustom, List<Object> paramList);
}
