package InsuranceManagementSystem;

public class BusinessAddress implements Address{
    public int bId = 1;
    private String city;
    private String district;
    private String addressDetails;

    public BusinessAddress(String city, String district, String addressDetails) {
        this.city = city;
        this.district = district;
        this.addressDetails = addressDetails;
        bId++;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    @Override
    public void showAdress() {
        System.out.println("Şehir: " + getCity() + "İlçe: "+ getDistrict()+ "Adres: "+ getDistrict());
    }
}
