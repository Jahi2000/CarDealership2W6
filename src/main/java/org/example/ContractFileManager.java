package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class ContractFileManager {

    public void save(Contract C) {

        try {
            String word = "";
            String word1 = "";
            // This line reads in the CSV file
            BufferedWriter theFile = new BufferedWriter(new FileWriter("Contract.csv", true));

            if(C instanceof SalesContract){
                word = String.format("SALE|%s|%s|%s|%d|%d| %n    %s|%s|%s|%s|%s|%.2f| %n    %.2f|%.2f|%.2f|%.2f|%s|%.2f \n",C.getContractDate(),C.getCustomerName(),C.getCustomerEmail(),
                        C.getSoldVehicle().getVin(),C.getSoldVehicle().getYear(),C.getSoldVehicle().getMake(),C.getSoldVehicle().getModel(),
                C.getSoldVehicle().getVehicleType(),C.getSoldVehicle().getColor(),C.getSoldVehicle().getOdometer(),C.getSoldVehicle().getPrice(),((SalesContract) C).getSalesTax(),
                        ((SalesContract) C).getRecordingFee(),((SalesContract) C).processingfee(),C.getTotalPrice(),((SalesContract) C).isFinance(),C.getMonthlyPayment());
                theFile.write(word);
            } else if (C instanceof LeaseContract) {
                word1 = String.format("LEASE|%s|%s|%s|%d|%d| %n    %s|%s|%s|%s|%s|%.2f| %n    %.2f|%.2f|%.2f|%.2f \n",C.getContractDate(),C.getCustomerName(),C.getCustomerEmail(),
                C.getSoldVehicle().getVin(),C.getSoldVehicle().getYear(),C.getSoldVehicle().getMake(),C.getSoldVehicle().getModel(),C.getSoldVehicle().getVehicleType(),
                C.getSoldVehicle().getColor(),C.getSoldVehicle().getOdometer(),C.getSoldVehicle().getPrice(),((LeaseContract) C).getEndValue(),((LeaseContract) C).getLeasefee(),
                        C.getTotalPrice(),C.getMonthlyPayment());
                theFile.write(word1);
            }



            theFile.close();

        } catch (IOException E) {
           E.getMessage();
        }
    }
}
