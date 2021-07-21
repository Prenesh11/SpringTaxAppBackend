package com.incometax.domain;

public class IncomeTaxRequest {

 private int taxYear;
 private int age;
 private double totalTaxableEarning;
 private int medicalAidMainMemberAndDependants;
 private int taxFrequency;


    public int getTaxYear() {
        return taxYear;
    }

    public void setTaxYear(int taxYear) {
        this.taxYear = taxYear;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getTotalTaxableEarning() {
        return totalTaxableEarning;
    }

    public void setTotalTaxableEarning(double totalTaxableEarning) {
        this.totalTaxableEarning = totalTaxableEarning;
    }

    public int getMedicalAidMainMemberAndDependants() {
        return medicalAidMainMemberAndDependants;
    }

    public void setMedicalAidMainMemberAndDependants(int medicalAidMainMemberAndDependants) {
        this.medicalAidMainMemberAndDependants = medicalAidMainMemberAndDependants;
    }

    public int getTaxFrequency() {
        return taxFrequency;
    }

    public void setTaxFrequency(int taxFrequency) {
        this.taxFrequency = taxFrequency;
    }
}
