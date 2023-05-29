package org.example;

public class LeaseContract extends Contract {

    private double endValue;
    private double leasefee;
    public LeaseContract(String contractDate, String customerName, String customerEmail, Vehicle soldVehicle) {
        super(contractDate, customerName, customerEmail, soldVehicle);

        this.endValue = soldVehicle.getPrice() / 2;
        this.leasefee = (soldVehicle.getPrice() / 100) * 7;
    }

   /* public double endvalue(){
        return getSoldVehicle().getPrice() / 2;
    }
   */

    /* public double leaseFee(){
        return (soldVehicle.getPrice() / 100) * 7;
    }
   */

    public double getEndValue() {
        return endValue;
    }

    public void setEndValue(double endValue) {
        this.endValue = endValue;
    }

    public double getLeasefee() {
        return leasefee;
    }

    public void setLeasefee(double leasefee) {
        this.leasefee = leasefee;
    }


    @Override
    public double getTotalPrice() {
        return (getSoldVehicle().getPrice() - getEndValue()) + getLeasefee();
    }

    @Override
    public double getMonthlyPayment() {
        return getTotalPrice() * (4.0 * Math.pow(1 + 4.0, 36)) / (Math.pow(1 + 4.0, 36) - 1);
    }
}
