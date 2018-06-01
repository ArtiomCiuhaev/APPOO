package com.travel.agency.Entity;

import java.util.Random;

public enum Transport {
    BUS("bus"), TRAIN("train"), PLANE("airplane"), SHIP("ship");

    private final String name;

    private Transport(String name) {
        this.name = name;
    }



    private static Random random = new Random();

    public static Transport randomTransport() {
        int size = values().length;
        int position = random.nextInt(size);
        return values()[position];
    }

    @Override
    public String toString() {
        return this.name;
    }
}
