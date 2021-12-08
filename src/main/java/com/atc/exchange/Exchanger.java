package com.atc.exchange;

public class Exchanger {
    protected static Object data;

    public Exchanger() {
    }

    public static Object getData() {
        return data;
    }

    public static void setData(Object data) {
        Exchanger.data = data;
    }
}
