package com.currencyconversion.service;

public class CurrencyService {
    private static final double USD_VND_RATE = 23000;

    public static Double usd_to_vnd(double usd) {
        return usd * USD_VND_RATE;
    }

    public static Double vnd_to_usd(double vnd) {
        return vnd / USD_VND_RATE;
    }
}
