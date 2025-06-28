package com.prestabanco.PrestaBanco.Services;

import com.prestabanco.PrestaBanco.Entities.MCApplicationEntity;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TotalCostCalculationService {

    public List<Double> totalCostCalculation(MCApplicationEntity mcApplicationEntity) {
        double monthlyPayment = monthlyPaymentCalculation(mcApplicationEntity);
        double lienInsurance = lienInsuranceCalculation(mcApplicationEntity);
        double fireInsurance = mcApplicationEntity.getFireInsurance();
        double administrationCommission = administrationCommissionCalculation(mcApplicationEntity);
        double monthlyCost = monthlyPayment + lienInsurance + fireInsurance + administrationCommission;
        double totalCost = monthlyCost*(12*mcApplicationEntity.getLoanTerm());
        return Arrays.asList(
                monthlyPayment,
                lienInsurance,
                fireInsurance,
                administrationCommission,
                monthlyCost,
                totalCost
        );
    }

    public double monthlyPaymentCalculation(MCApplicationEntity mcApplicationEntity) {
        int P = mcApplicationEntity.getLoanAmount();
        double r = (mcApplicationEntity.getAnnualInterestRate()/12)/100;
        int n = mcApplicationEntity.getLoanTerm()*12;
        double aux = Math.pow((1+r),n);
        return (P*((r*aux)/(aux-1)));
    }

    public double lienInsuranceCalculation(MCApplicationEntity mcApplicationEntity) {
        return (mcApplicationEntity.getLoanAmount()*(mcApplicationEntity.getLienInsurance()/100));
    }

    public double administrationCommissionCalculation(MCApplicationEntity mcApplicationEntity) {
        return (mcApplicationEntity.getLoanAmount()*(mcApplicationEntity.getAdministrationCommission()/100));
    }

}
