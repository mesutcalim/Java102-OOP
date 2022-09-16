package InsuranceManagementSystem;

import java.util.Date;

public class CarInsurance extends Insurance{
    public CarInsurance(String insuranceType){
        super("Araba sigortası",new Date(),new Date());
        calculate(insuranceType);
    }
    @Override
    public void calculate(String insuranceType) {
        double price = 2100.99;
        if(insuranceType.equals("Individual")){
            this.setInsurancePrice(price*0.8);
        }
        else{
            this.setInsurancePrice(price);
        }
    }
}
