package com.travel.agency.Entity;

public class Order {
    private int id;

    private String client;

    private Tour tour;

    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (count != order.count) return false;
        if (client != null ? !client.equals(order.client) : order.client != null) return false;
        return tour != null ? tour.equals(order.tour) : order.tour == null;
    }

    @Override
    public int hashCode() {
        int result = client != null ? client.hashCode() : 0;
        result = 31 * result + (tour != null ? tour.hashCode() : 0);
        result = 31 * result + count;
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "client='" + client + '\'' +
                ", tour=" + tour +
                ", count=" + count +
                '}';
    }
}
