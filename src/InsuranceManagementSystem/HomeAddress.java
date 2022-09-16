package InsuranceManagementSystem;

public class HomeAddress implements Address{
    public int hId = 1;
    private String city;
    private String district;
    private String addressDetails;

    public HomeAddress(String city, String district, String addressDetails) {
        this.city = city;
        this.district = district;
        this.addressDetails = addressDetails;
        hId++;
    }

    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
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

    @Override
    public void showAdress() {
        System.out.println("Şehir: " + getCity() + "İlçe: "+ getDistrict()+ "Adres: "+ getDistrict());
    }
}
