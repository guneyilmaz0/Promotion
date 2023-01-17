package net.swade.formapi.types;

import cn.nukkit.Player;
import cn.nukkit.form.element.*;
import cn.nukkit.form.window.FormWindowCustom;
import net.swade.formapi.Form;
import net.swade.formapi.responses.CustomFormResponse;

import java.util.List;

public class CustomForm extends Form {
    public CustomForm(FormWindowCustom form) {
        this.form = form;
    }

    public CustomForm() {
        this.form = new FormWindowCustom("");
    }

    public CustomForm(String title) {
        this.form = new FormWindowCustom(title);
    }

    public void send(Player player, CustomFormResponse response) {
        playersForm.put(player.getName(), response);
        player.showFormWindow(this.form);
    }

    public CustomForm setTitle(String value) {
        ((FormWindowCustom)this.form).setTitle(value);
        return this;
    }

    public CustomForm addLabel(String value) {
        ((FormWindowCustom)this.form).addElement(new ElementLabel(value));
        return this;
    }

    public CustomForm addInput() {
        ElementInput element = new ElementInput("");
        ((FormWindowCustom)this.form).addElement(element);
        return this;
    }

    public CustomForm addInput(String name) {
        ElementInput element = new ElementInput(name);
        ((FormWindowCustom)this.form).addElement(element);
        return this;
    }

    public CustomForm addInput(String name, String placeholder) {
        ElementInput element = new ElementInput(name, placeholder);
        ((FormWindowCustom)this.form).addElement(element);
        return this;
    }

    public CustomForm addInput(String name, String placeholder, String defaultText) {
        ElementInput element = new ElementInput(name, placeholder, defaultText);
        ((FormWindowCustom)this.form).addElement(element);
        return this;
    }

    public CustomForm addToggle() {
        ElementToggle element = new ElementToggle("");
        ((FormWindowCustom)this.form).addElement(element);
        return this;
    }

    public CustomForm addToggle(String name) {
        ElementToggle element = new ElementToggle(name);
        ((FormWindowCustom)this.form).addElement(element);
        return this;
    }

    public CustomForm addToggle(String name, boolean defaultValue) {
        ElementToggle element = new ElementToggle(name, defaultValue);
        ((FormWindowCustom)this.form).addElement(element);
        return this;
    }

    public CustomForm addDropDown(String name, List<String> list) {
        ElementDropdown element = new ElementDropdown(name, list);
        ((FormWindowCustom)this.form).addElement(element);
        return this;
    }

    public CustomForm addDropDown(String name, List<String> list, int defaultValue) {
        ElementDropdown element = new ElementDropdown(name, list, defaultValue);
        ((FormWindowCustom)this.form).addElement(element);
        return this;
    }

    public CustomForm addSlider(String name, int min, int max) {
        ElementSlider element = new ElementSlider(name, min, max);
        ((FormWindowCustom)this.form).addElement(element);
        return this;
    }

    public CustomForm addSlider(String name, int min, int max, int step) {
        ElementSlider element = new ElementSlider(name, min, max, step, 3.0F);
        ((FormWindowCustom)this.form).addElement(element);
        return this;
    }

    public CustomForm addSlider(String name, int min, int max, int step, int defaultValue) {
        ElementSlider element = new ElementSlider(name, min, max, step, defaultValue);
        ((FormWindowCustom)this.form).addElement(element);
        return this;
    }

    public CustomForm addStepSlider(String name, List<String> list) {
        ElementStepSlider element = new ElementStepSlider(name, list);
        ((FormWindowCustom)this.form).addElement(element);
        return this;
    }

    public CustomForm addStepSlider(String name, List<String> list, int defaultStep) {
        ElementStepSlider element = new ElementStepSlider(name, list, defaultStep);
        ((FormWindowCustom)this.form).addElement(element);
        return this;
    }
}