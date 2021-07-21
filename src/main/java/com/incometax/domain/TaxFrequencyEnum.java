package com.incometax.domain;

public enum TaxFrequencyEnum {

    MONTHLY_TAX(1),
    ANNUAL_TAX(2);

    private int taxFrequency;

    TaxFrequencyEnum( int value)
    {
        this.taxFrequency = value;
    }

    public int getValue()
    {
        return this.taxFrequency;
    }

}
