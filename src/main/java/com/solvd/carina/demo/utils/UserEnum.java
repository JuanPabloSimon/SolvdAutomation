package com.solvd.carina.demo.utils;

public enum UserEnum {
    STANDARD("standard_user"),
    LOCKED_OUT("locked_out_user"),
    PROBLEM("problem_user"),
    PERFORMANCE_GLITCH("performance_glitch_user");

    private String credential;

    UserEnum(String credential) {
        this.credential = credential;
    }

    public String getCredential() {
        return credential;
    }
}
