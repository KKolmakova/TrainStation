package com.kolmakova.types;

public enum WagonType {

    RESERVED_SEAT("Reserved seat"),
    COMPARTMENT("Compartment");

    private String displayType;

    WagonType(String displayType) {
        this.displayType = displayType;
    }

    public String displayName() {
        return displayType;
    }

    @Override
    public String toString() {
        return displayType;
    }
}