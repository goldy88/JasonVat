package com.engeto;

public class Country {
    private String rates;
    public double standard;
    private String name;
    private String code;
    private String periods;

    public String getRates() {
        return rates;
    }

    public double getStandard() {
        return standard;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getPeriods() {
        return periods;
    }

    public Country(double standard, String name, String code) {
        this.standard = standard;
        this.name = name;
        this.code = code;
    }

    public String toString() {
        return (this.name + ", kod zeme je: " + this.code + ", standartni sazba je " + this.standard );
    }
}

