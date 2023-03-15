package com.solvd.carina.demo.homework.mobile.utils;

public enum EngineType {

    GOOGLE("Google"),
    YAHOO("Yahoo!"),
    BING("Bing"),
    ASK("Ask"),
    AOL("AOL");
    private String name;

    EngineType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
