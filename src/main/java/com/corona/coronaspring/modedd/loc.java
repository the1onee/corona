package com.corona.coronaspring.modedd;

public class loc {
    private String state;
    private String country;
    private int lastetotal;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLastetotal() {
        return lastetotal;
    }

    @Override
    public String toString() {
        return "loc{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", lastetotal=" + lastetotal +
                '}';
    }

    public void setLastetotal(int lastetotal) {
        this.lastetotal = lastetotal;
    }
}
