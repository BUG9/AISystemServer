package com.swpu.utils;

import com.google.gson.Gson;

/**
 * Created by BUG666 on 2017/1/4.
 */
public class GsonUtils {
    private static Gson gson = new Gson();

    public static  <T> T fromJson(String json, Class<T> classOfT){
        return gson.fromJson(json, classOfT);
    }

}
