package com.sureshCS50.gameofclones.utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class Utils {

    public static <T> String convertObjectToStringJson(T object, Type type) {
        if (object != null) {
            return new Gson().toJson(object, type);
        }
        return null;
    }

    public static <T> T getObjectFromJson(String json, Type type) {
        if (json != null && !json.isEmpty()) {
            return new Gson().fromJson(json, type);
        }
        return null;
    }

}
