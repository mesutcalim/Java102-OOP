package InsuranceManagementSystem;

import java.util.Date;

public abstract class Insurance {
    private String insuranceName;
    private double insurancePrice;
    private Date insuranceStartDate;
    private Date insuranceFinishDate;
    public abstract void calculate(String insuranceType);

    public Insurance(String insuranceName, Date insuranceStartDate, Date insuranceFinishDate) {
        this.insuranceName = insuranceName;
        this.insuranceStartDate = insuranceStartDate;
        this.insuranceFinishDate = insuranceFinishDate;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public double getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(double insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public Date getInsuranceStartDate() {
        return insuranceStartDate;
    }

    public void setInsuranceStartDate(Date insuranceStartDate) {
        this.insuranceStartDate = insuranceStartDate;
    }

    public Date getInsuranceFinishDate() {
        return insuranceFinishDate;
    }

    public void setInsuranceFinishDate(Date insuranceFinishDate) {
        this.insuranceFinishDate = insuranceFinishDate;
    }
}
