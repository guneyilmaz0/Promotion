package net.swade.formapi.types;

import cn.nukkit.Player;
import cn.nukkit.form.window.FormWindowModal;
import net.swade.formapi.Form;
import net.swade.formapi.responses.ModalFormResponse;

public class ModalForm extends Form {
    public ModalForm(FormWindowModal form) {
        this.form = form;
    }

    public ModalForm() {
        this.form = new FormWindowModal("", "", "", "");
    }

    public ModalForm(String title) {
        this.form = new FormWindowModal(title, "", "", "");
    }

    public ModalForm(String title, String content) {
        this.form = new FormWindowModal(title, content, "", "");
    }

    public ModalForm(String title, String content, String trueButton) {
        this.form = new FormWindowModal(title, content, trueButton, "");
    }

    public ModalForm(String title, String content, String trueButton, String falseButton) {
        this.form = new FormWindowModal(title, content, trueButton, falseButton);
    }

    public void send(Player player, ModalFormResponse response) {
        playersForm.put(player.getName(), response);
        player.showFormWindow(this.form);
    }

    public ModalForm setTitle(String value) {
        ((FormWindowModal)this.form).setTitle(value);
        return this;
    }

    public ModalForm setContent(String value) {
        ((FormWindowModal)this.form).setContent(value);
        return this;
    }

    public ModalForm setButton1(String value) {
        ((FormWindowModal)this.form).setButton1(value);
        return this;
    }

    public ModalForm setButton2(String value) {
        ((FormWindowModal)this.form).setButton2(value);
        return this;
    }
}