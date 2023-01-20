package net.swade.object;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.swade.Main;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Promotion {
    @Getter @Setter private String code;
    @Getter @Setter private String owner;
    @Getter @Setter private boolean infinity;
    @Getter @Setter private int use;
    @Getter @Setter private int maxUse;
    @Getter @Setter private List<String> players;
    @Getter @Setter private double money;

    public static Promotion createPromotion(String code, String owner, boolean infinity, int maxUse, double money) {
        return new Promotion(code, owner, infinity, 0, maxUse, new ArrayList<>(), money);
    }

    public static Promotion getPromotion(String promotion) {
        return new Gson().fromJson(Main.getPromotionConfig().getString(promotion), Promotion.class);
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}