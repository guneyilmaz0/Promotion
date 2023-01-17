package net.swade.database;

import com.google.gson.Gson;

public abstract class DatabaseObject {

    public String toString() {
        return new Gson().toJson(this);
    }

}
