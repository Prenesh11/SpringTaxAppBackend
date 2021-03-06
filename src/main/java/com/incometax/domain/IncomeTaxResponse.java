package com.incometax.domain;

/**
 * IncomeTaxResponse, this is one of the response formats and can be mapped to a relational db via JPA if required
 *
 * @author  Prenesh Naidoo
 * @version 1.0
 * @since  2021
 */


public class IncomeTaxResponse {

    private double taxPayableMonthlyBeforeCredit = 0.0;
    private double taxPayableAnnuallyBeforeCredit = 0.0;
    private double taxCredit = 0.0;
    private double payeDueAfterTaxCredit = 0.0;
    private double netCashPay = 0.0;

    public double getTaxPayableMonthlyBeforeCredit() {
        return taxPayableMonthlyBeforeCredit;
    }

    public void setTaxPayableMonthlyBeforeCredit(double taxPayableMonthlyBeforeCredit) {
        this.taxPayableMonthlyBeforeCredit = taxPayableMonthlyBeforeCredit;
    }

    public double getTaxPayableAnnuallyBeforeCredit() {
        return taxPayableAnnuallyBeforeCredit;
    }

    public void setTaxPayableAnnuallyBeforeCredit(double taxPayableAnnuallyBeforeCredit) {
        this.taxPayableAnnuallyBeforeCredit = taxPayableAnnuallyBeforeCredit;
    }

    public double getTaxCredit() {
        return taxCredit;
    }

    public void setTaxCredit(double taxCredit) {
        this.taxCredit = taxCredit;
    }

    public double getPayeDueAfterTaxCredit() {
        return payeDueAfterTaxCredit;
    }

    public void setPayeDueAfterTaxCredit(double payeDueAfterTaxCredit) {
        this.payeDueAfterTaxCredit = payeDueAfterTaxCredit;
    }

    public double getNetCashPay() {
        return netCashPay;
    }

    public void setNetCashPay(double netCashPay) {
        this.netCashPay = netCashPay;
    }

}
