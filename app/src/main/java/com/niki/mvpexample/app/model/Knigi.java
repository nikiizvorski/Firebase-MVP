package com.niki.mvpexample.app.model;

import javax.inject.Inject;

public class Knigi {
    private String name;

    @Inject
    public Knigi() {
    }

    @Override
    public String toString() {
        return name;
    }

    public Knigi(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
