package org.example;

public abstract class Contract {

    private String contractDate;
    private String customerName;
    private String customerEmail;
    private Vehicle soldVehicle;

    public Contract(String contractDate, String customerName, String customerEmail, Vehicle soldVehicle) {
        this.contractDate = contractDate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.soldVehicle = soldVehicle;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getSoldVehicle() {
        return soldVehicle;
    }

    public void setSoldVehicle(Vehicle soldVehicle) {
        this.soldVehicle = soldVehicle;
    }

    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();
}
