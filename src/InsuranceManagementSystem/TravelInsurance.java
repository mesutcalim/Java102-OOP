package InsuranceManagementSystem;

import java.util.Date;

public class TravelInsurance extends Insurance{
    public TravelInsurance(String insuranceType) {
        super("Sağlık sigortası", new Date(), new Date());
        calculate(insuranceType);
    }

    @Override
    public void calculate(String insuranceType) {
        double price=99.99;
        if(insuranceType.equals("Individual"))
        {
            setInsurancePrice(price);
        }
        if(insuranceType.equals("Enterprise")){
            setInsurancePrice(price*1.2);
        }
    }
}
