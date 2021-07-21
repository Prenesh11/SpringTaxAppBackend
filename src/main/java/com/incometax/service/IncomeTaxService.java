package com.incometax.service;

import com.incometax.domain.IncomeTaxRequest;
import com.incometax.domain.IncomeTaxResponse;
import com.incometax.domain.TaxFrequencyEnum;
import org.springframework.stereotype.Service;

@Service
public class IncomeTaxService {


    public IncomeTaxResponse calculateTax(IncomeTaxRequest incomeTaxRequest) {
        IncomeTaxResponse incomeTaxResponse = new IncomeTaxResponse();

        incomeTaxResponse.setTaxPayableAnnuallyBeforeCredit(calculateTaxAmount(incomeTaxRequest));
        incomeTaxResponse.setTaxPayableMonthlyBeforeCredit(incomeTaxResponse.getTaxPayableAnnuallyBeforeCredit()/12);

        if(TaxFrequencyEnum.MONTHLY_TAX.getValue() == incomeTaxRequest.getTaxFrequency())
        {
            incomeTaxResponse.setTaxCredit(calculateTaxCredit(incomeTaxRequest));
            incomeTaxResponse.setPayeDueAfterTaxCredit(incomeTaxResponse.getTaxPayableMonthlyBeforeCredit() - incomeTaxResponse.getTaxCredit());
            incomeTaxResponse.setNetCashPay(incomeTaxRequest.getTotalTaxableEarning() - incomeTaxResponse.getPayeDueAfterTaxCredit());
        }else{
            incomeTaxResponse.setTaxCredit(calculateTaxCredit(incomeTaxRequest)*12);
            incomeTaxResponse.setPayeDueAfterTaxCredit(incomeTaxResponse.getTaxPayableAnnuallyBeforeCredit() - incomeTaxResponse.getTaxCredit());
            incomeTaxResponse.setNetCashPay(incomeTaxRequest.getTotalTaxableEarning() - incomeTaxResponse.getPayeDueAfterTaxCredit());
        }

        return incomeTaxResponse;
    }

    private double calculateTaxCredit(IncomeTaxRequest incomeTaxRequest) {

        if(incomeTaxRequest.getTaxYear() == 2021)
        {
            return calculateTaxCreditFor2021(incomeTaxRequest.getMedicalAidMainMemberAndDependants());
        }else
        {
            return calculateTaxCreditFor2020(incomeTaxRequest.getMedicalAidMainMemberAndDependants());
        }


    }

    private double calculateTaxCreditFor2021(int medicalAidMainMemberAndDependants) {
        if(medicalAidMainMemberAndDependants == 0)
        {
            return 0;
        }
        else if(medicalAidMainMemberAndDependants == 1)
        {
            return 319;
        }else if(medicalAidMainMemberAndDependants == 2)
            return 638;
        else
        {
            return 638 + ((medicalAidMainMemberAndDependants-2) * 215);
        }
    }

    private double calculateTaxCreditFor2020(int medicalAidMainMemberAndDependants) {
        if(medicalAidMainMemberAndDependants == 0)
        {
            return 0;
        }
        else if(medicalAidMainMemberAndDependants == 1)
        {
            return 310;
        }else if(medicalAidMainMemberAndDependants == 2)
            return 620;
        else
        {
            return 620 + ((medicalAidMainMemberAndDependants-2) * 209);
        }
    }


    private double calculateTaxAmount(IncomeTaxRequest incomeTaxRequest) {

        double grossIncome = 0.0;
        double TotalAnnualTaxableAmount = 0.0;
        int taxYear = incomeTaxRequest.getTaxYear();

        if(TaxFrequencyEnum.MONTHLY_TAX.getValue()==incomeTaxRequest.getTaxFrequency())
        {
            grossIncome = incomeTaxRequest.getTotalTaxableEarning() * 12;
        }
        else
        {
            grossIncome = incomeTaxRequest.getTotalTaxableEarning();
        }

        if(taxYear == 2021)
        {
            return calculateTaxFor2021(grossIncome) - calculateRebate2021(incomeTaxRequest.getAge());
        }else{
            return calculateTaxFor2020(grossIncome) - calculateRebate2020(incomeTaxRequest.getAge());
        }
    }

    private double calculateRebate2020(int age) {
        if(age<65)
        {
            return 14220;
        }else if(age < 75)
            return 7794 + 14220;
        else{
            return 2601 + 7794 + 14220;
        }
    }

    private double calculateRebate2021(int age) {
        if(age<65)
        {
            return 14958;
        }else if(age < 75)
            return 8199 + 14958;
        else{
            return 2736 + 8199 + 14958;
        }
    }

    private double calculateTaxFor2021(double grossIncome) {

        double totalAnnualTaxableAmount;
        if (grossIncome >= 1 && grossIncome <= 205900 )
        {
            totalAnnualTaxableAmount = grossIncome*0.18;
            return totalAnnualTaxableAmount;

        }else if (grossIncome >= 205901 && grossIncome <= 321600)
        {
            totalAnnualTaxableAmount = 37062 + ((grossIncome - 205900)*0.26);
            return totalAnnualTaxableAmount;

        }else if (grossIncome >= 321601 && grossIncome <= 445100)
        {
            totalAnnualTaxableAmount = 67144 + ((grossIncome - 321600)*0.31);
            return totalAnnualTaxableAmount;

        }else if (grossIncome >= 445101 && grossIncome <= 584200)
        {
            totalAnnualTaxableAmount = 105429 + ((grossIncome - 445100)*0.36);
            return totalAnnualTaxableAmount;

        }else if (grossIncome >= 584201 && grossIncome <= 744800)
        {
            totalAnnualTaxableAmount = 155505  + ((grossIncome - 584200)*0.39);
            return totalAnnualTaxableAmount;

        }else if (grossIncome >= 744801 && grossIncome <= 1577300)
        {
            totalAnnualTaxableAmount = 218139 + ((grossIncome - 744800)*0.41);
            return totalAnnualTaxableAmount;

        }else
        {
            totalAnnualTaxableAmount = 559464 + ((grossIncome - 1577300)*0.45);
            return totalAnnualTaxableAmount;
        }
    }

    private double calculateTaxFor2020(double grossIncome) {

        double totalAnnualTaxableAmount;
        if (grossIncome >= 1 && grossIncome <= 195850 )
        {
            totalAnnualTaxableAmount = grossIncome*0.18;
            return totalAnnualTaxableAmount;

        }else if (grossIncome >= 195851 && grossIncome <= 305850)
        {
            totalAnnualTaxableAmount = 35235 + ((grossIncome - 195850)*0.26);
            return totalAnnualTaxableAmount;

        }else if (grossIncome >= 305851 && grossIncome <= 423300)
        {
            totalAnnualTaxableAmount = 63853 + ((grossIncome - 305850)*0.31);
            return totalAnnualTaxableAmount;

        }else if (grossIncome >= 423301 && grossIncome <= 555600)
        {
            totalAnnualTaxableAmount = 100263 + ((grossIncome - 423300)*0.36);
            return totalAnnualTaxableAmount;

        }else if (grossIncome >= 555601 && grossIncome <= 708310)
        {
            totalAnnualTaxableAmount = 147891  + ((grossIncome - 555600)*0.39);
            return totalAnnualTaxableAmount;

        }else if (grossIncome >= 708311 && grossIncome <= 1500000)
        {
            totalAnnualTaxableAmount = 207448 + ((grossIncome - 708310)*0.41);
            return totalAnnualTaxableAmount;

        }else
        {
            totalAnnualTaxableAmount = 532041 + ((grossIncome - 1500000)*0.45);
            return totalAnnualTaxableAmount;
        }
    }
}
