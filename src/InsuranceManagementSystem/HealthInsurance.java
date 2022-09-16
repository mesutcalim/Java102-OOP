package InsuranceManagementSystem;

import java.util.Date;

public class HealthInsurance extends Insurance{
    public HealthInsurance(String insuranceType) {
        super("Sağlık sigortası", new Date(), new Date());
        calculate(insuranceType);
    }

    @Override
    public void calculate(String insuranceType) {
        double price=999.99;
        if(insuranceType.equals("Individual"))
        {
            setInsurancePrice(price);
        }
        if(insuranceType.equals("Enterprise")){
            setInsurancePrice(price*0.9);
        }
    }
}
