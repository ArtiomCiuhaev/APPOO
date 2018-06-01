package com.travel.agency.Entity;

import java.time.LocalDate;

public class Tour extends AbstractTour {

    private Hotel hotel;

    private LocalDate dateFrom;

    private LocalDate dateTo;

    private Transport transport;

    private boolean hot;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tour tour = (Tour) o;

        if (price != tour.price) return false;
        if (hot != tour.hot) return false;
        if (title != null ? !title.equals(tour.title) : tour.title != null) return false;
        if (hotel != null ? !hotel.equals(tour.hotel) : tour.hotel != null) return false;
        if (dateFrom != null ? !dateFrom.equals(tour.dateFrom) : tour.dateFrom != null) return false;
        if (dateTo != null ? !dateTo.equals(tour.dateTo) : tour.dateTo != null) return false;
        return transport == tour.transport;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (hotel != null ? hotel.hashCode() : 0);
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        result = 31 * result + (transport != null ? transport.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (hot ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tour{" +
                String.format("title=%35s %40s to %10s", title, dateFrom, dateTo) +
                ",\n     " + hotel +
                String.format("\n     transport: %5s", transport) +
                "        price=" + price / 100.0 +
                (hot?" HOT PRICE":"") +
                '}';
    }
}
