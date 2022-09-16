package InsuranceManagementSystem;

public class Individual extends Account{
    private final String individual = "İndividual";

    public Individual(User user) {
        super(user);
    }

    @Override
    public void policy() {
        System.out.println("Sigorta Türlerimiz");
        System.out.println("1- Sağlık Sigortası\n2-Seyahat Sigortası\n3-Araç Sigortası\n4-Konut Sigortası");
        System.out.println("Sigorta seçiminiz: ");
        switch (input.nextInt()){
            case 1:
                if(checkInsurance(new HealthInsurance(individual))){
                    getUser().setInsurance(new HealthInsurance(individual));
                    getUser().setInsuranceList(getUser().getInsurance());
                    System.out.println("Sigortanız yapılmıştır.");
                }
                else{
                    System.out.println("Sağlık sigortanız zaten mevcuttur.");
                }
                break;
            case 2:
                if(checkInsurance(new TravelInsurance(individual))){
                    getUser().setInsurance(new TravelInsurance(individual));
                    getUser().setInsuranceList(getUser().getInsurance());
                    System.out.println("Sigortanız yapılmıştır.");
                }
                else{
                    System.out.println("Seyehat sigortanız zaten mevcuttur.");
                }
                break;
            case 3:
                if(checkInsurance(new CarInsurance(individual))){
                    getUser().setInsurance(new CarInsurance(individual));
                    getUser().setInsuranceList(getUser().getInsurance());
                    System.out.println("Sigortanız yapılmıştır.");
                }
                else{
                    System.out.println("Araç sigortanız zaten mevcuttur.");
                }
                break;
            case 4:
                if(checkInsurance(new ResidenceInsurance(individual))){
                    getUser().setInsurance(new ResidenceInsurance(individual));
                    getUser().setInsuranceList(getUser().getInsurance());
                    System.out.println("Sigortanız yapılmıştır.");
                }
                else{
                    System.out.println("Konut sigortanız zaten mevcuttur.");
                }
                break;
            default:
                System.out.println("Geçersiz veri girdiniz.");
                break;

        }
    }
    private boolean checkInsurance(Insurance insurance){
        for(Insurance i:getUser().getInsuranceList()){
            if(i.getInsuranceName().equals(insurance.getInsuranceName())){
                return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(Account o, Account o1) {
        return this.getUser().getFirstName().compareTo(o.getUser().getFirstName());
    }

    @Override
    public int compareTo(Account o){
        return this.getUser().getFirstName().compareTo(o.getUser().getFirstName());
    }

}
