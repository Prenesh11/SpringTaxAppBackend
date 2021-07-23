package com.incometax.domain;

/**
 * TaxFrequencyEnum, this enum contains the look up values tax frequencies
 * and is used to make the code more readable
 *
 * @author  Prenesh Naidoo
 * @version 1.0
 * @since  2021
 */

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
