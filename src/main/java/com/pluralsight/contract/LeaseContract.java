package com.pluralsight.contract;

import com.pluralsight.Vehicle;

public class LeaseContract extends Contract {

    private double endingValue;
    private double leaseFeeRate;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail,
                         Vehicle vehicleSold, double totalPrice, double monthlyPayment,
                         double endingValue, double leaseFeeRate) {
        super(dateOfContract, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.endingValue = 0.5;
        this.leaseFeeRate = 0.07;
    }

    public double getEndingValue() {
        return endingValue;
    }

    public double getLeaseFee() {
        return leaseFeeRate;
    }

    @Override
    public double getTotalPrice(){

        Vehicle vehicle = super.getVehicleSold();
        double basePrice = vehicle.getPrice();
        double expectedEndingValue = basePrice * endingValue;
        double leaseFee = leaseFeeRate * basePrice;

        return basePrice + expectedEndingValue + leaseFee;
    }

    @Override
    public double getMonthlyPayment(){

        Vehicle vehicle = super.getVehicleSold();
        double totalPrice = this.getTotalPrice();

        double leaseRate = 0.04;
        int leaseMonthlyTerm = 36;

        double leaseMonthlyRate = leaseRate /12;

        return (totalPrice * leaseMonthlyRate) / (1 - Math.pow(1 + leaseMonthlyTerm, - leaseMonthlyTerm));

    }
}
