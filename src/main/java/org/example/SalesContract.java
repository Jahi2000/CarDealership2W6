package org.example;

public class SalesContract extends Contract {

    final private double salestaxAmount = 0.05;
    final private double recordingFee = 100;
    private boolean isFinance;

    public SalesContract(String contractDate, String customerName, String customerEmail, Vehicle soldVehicle, boolean isFinance) {
        super(contractDate, customerName, customerEmail, soldVehicle);
        this.isFinance = isFinance;
    }

    public double processingfee() {
        if (getSoldVehicle().getPrice() < 10000) {
            return 295;
        } else {
            return 495;
        }
    }

    public double getSalesTax(){
       return (getSoldVehicle().getPrice() / 100) * this.salestaxAmount;
    }

    public double getTotalPrice() {
        return getSoldVehicle().getPrice() + getSalesTax() + recordingFee + processingfee();
    }


    @Override
    public double getMonthlyPayment() {
        if (isFinance) {
            if (getSoldVehicle().getPrice() >= 10000) {
                return getTotalPrice() * (4.25 * Math.pow(1 + 4.25, 48)) / (Math.pow(1 + 4.25, 48) - 1);
            } else {
                return getTotalPrice() * (5.25 * Math.pow(1 + 5.25, 24)) / (Math.pow(1 + 5.25, 24) - 1);
            }
        } else {
            return 0;
        }
    }

    public double getRecordingFee() {
        return recordingFee;
    }


    public String isFinance() {
        if(this.isFinance) {
            return "Yes";
        }
        else {
            return "No";
        }
    }

    public void setFinance(boolean finance) {
        isFinance = finance;
    }
}
