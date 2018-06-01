package com.travel.agency.Entity;

import java.util.Random;

public class RandomHotelBuilder {
    private static final int MAX_STAR = 5;

    private static final String[] HOTEL_NAMES = {"Grand hotel", "Awesome", "Poor hostel", "Wonderful hotel",
            "Lovely place", "Radisson Blu", "Cheap motel", "Prestige"};

    private static final String[] STREETS = {"Primary Avenue", "Long Street", "Broadway",
            "Sunny Street", "Highway Street", "Another street",
            "Apple Street", "Flying Road", "Some Lane", "Unnamed Road", "FarFarAway Street"};

    private String country;

    private Random random = new Random();

    private RandomHotelBuilder(String country) {
        this.country = country;
    }

    public static RandomHotelBuilder getInstance(String country) {
        return new RandomHotelBuilder(country);
    }

    public Hotel build() {
        Hotel hotel = new Hotel();
        hotel.setName(getRandomItem(HOTEL_NAMES));
        hotel.setStar(getRandomStar());
        hotel.setAddress(getRandomAddress());

        return hotel;
    }

    private String getRandomAddress() {
        return country + ", " + getRandomItem(STREETS) + ", " + (random.nextInt(100) + 1);
    }

    private int getRandomStar() {
        return random.nextInt(MAX_STAR ) + 1;
    }

    private String getRandomItem(String... args) {

        random = new Random();
        int position = random.nextInt(args.length);
        String item = args[position];
        return item;
    }
}
