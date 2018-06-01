package com.travel.agency.Entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class RandomTourBuilder {
    private static final String[] COUNTRIES = {"Russia", "Belarus", "Poland", "Italy", "Bulgaria",
            "Egypt", "India", "Sri Lanka", "Japan", "Cuba", "Caribbean Islands"};

    private static final int START_IN_NEXT_DAYS = 180;

    private static final int MAX_DURATION = 30;

    private static final int MAX_PRICE = 1000000;

    private Random random = new Random();

    private RandomTourBuilder(int countryNumber) {
        this.countryNumber = countryNumber;
    }

    private int countryNumber;

    public static RandomTourBuilder getInstance(int countryNumber) {
        if (countryNumber < 0 || countryNumber >= COUNTRIES.length) {
            throw new IllegalArgumentException("COUNTRIES.length == " + COUNTRIES.length
                    + "   countriesNumber = " + countryNumber);
        }

        return new RandomTourBuilder(countryNumber);
    }

    public Tour build() {
        return build(0);
    }

    public Tour build(int id) {
        String country = COUNTRIES[countryNumber];
        LocalDate from = generateDate();

        Tour tour = new Tour();

        tour.setId(id);
        tour.setTitle(generateTitle(country));
        tour.setHotel(getRandomHotel(country));
        tour.setDateFrom(from);
        tour.setDateTo(from.plus(random.nextInt(MAX_DURATION), ChronoUnit.DAYS));
        tour.setTransport(Transport.randomTransport());
        tour.setHot(random.nextInt() % 2 == 0);
        tour.setPrice(random.nextInt(MAX_PRICE));

        return tour;
    }


    private LocalDate generateDate() {
        LocalDate start = LocalDate.now();
        return start
                .plus(random.nextInt(START_IN_NEXT_DAYS), ChronoUnit.DAYS);
    }

    private String generateTitle(String country) {
        return "Tour to "
                + country
                + "  (#" + (random.nextInt(899_999) + 100_000) + ")";
    }

    private Hotel getRandomHotel(String country) {
        return RandomHotelBuilder
                .getInstance(country)
                .build();
    }


    public static int getCountryCount() {
        return COUNTRIES.length;
    }
}
