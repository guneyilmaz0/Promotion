package net.swade.formapi.types;

import cn.nukkit.Player;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementButtonImageData;
import cn.nukkit.form.window.FormWindowSimple;
import net.swade.formapi.Form;
import net.swade.formapi.responses.SimpleFormResponse;

public class SimpleForm extends Form {
    public SimpleForm(FormWindowSimple form) {
        this.form = form;
    }

    public SimpleForm() {
        this.form = new FormWindowSimple("", "");
    }

    public SimpleForm(String title) {
        this.form = new FormWindowSimple(title, "");
    }

    public SimpleForm(String title, String content) {
        this.form = new FormWindowSimple(title, content);
    }

    public void send(Player player, SimpleFormResponse response) {
        playersForm.put(player.getName(), response);
        player.showFormWindow(this.form);
    }

    public SimpleForm setTitle(String value) {
        ((FormWindowSimple)this.form).setTitle(value);
        return this;
    }

    public SimpleForm setContent(String value) {
        ((FormWindowSimple)this.form).setContent(value);
        return this;
    }

    public SimpleForm addButton(String text) {
        ((FormWindowSimple)this.form).addButton(new ElementButton(text));
        return this;
    }

    public SimpleForm addButton(String text, ImageType type, String ico) {
        ElementButton button = new ElementButton(text);
        button.addImage(new ElementButtonImageData((type == ImageType.PATH) ? "path" : "url", ico));
        ((FormWindowSimple)this.form).addButton(button);
        return this;
    }
}