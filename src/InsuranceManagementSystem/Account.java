package InsuranceManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class  Account implements Comparable<Account>{
    private User user;
    private AuthenticationStatus status=AuthenticationStatus.FAIL;
    private ArrayList<Insurance> insurances = new ArrayList<Insurance>();
    public Scanner input = new Scanner(System.in);
    public abstract int compareTo(Account o, Account o1);

    public abstract int compareTo(Account o);

    enum AuthenticationStatus{
        FAIL,
        SUCCESS;
    }
    public Account(User user){
        this.user = user;
    }
    public abstract void policy();

    public void login(String email,String password,Account account) throws InvalidAuthenticationException{
        if(account.getUser().getEmail().equals(email) && account.getUser().getPassword().equals(password) ){
            status=AuthenticationStatus.SUCCESS;
        }
        else throw new InvalidAuthenticationException("Giriş işlemi başarısız oldu..!");

    }
    public final void showUserInfo(){
        System.out.println("Kullanıcı adı soyadı: " + user.getFirstName() + " "+ user.getLastName() +
                        "\nKullanıcı Yaşı: "+ user.getAge() +
                        "\nKullanıcı e-posta adresi: "+ user.getEmail() + "\nMesleği: "+ user.getJob()+
                        "\nSon giriş: " + user.getLastEntry()
                );
        printInsurances();
        printAddress();
    }
    public void printInsurances(){
        for(Insurance insurance:user.getInsuranceList()){
            System.out.println("Sigorta ismi: " + insurance.getInsuranceName() +
                    "\nSigorta ücreti: "+ insurance.getInsurancePrice() +
                    "\nSigorta başlama tarihi: " + insurance.getInsuranceStartDate() +
                    "\nSiyorta bitiş tarihi: "+insurance.getInsuranceFinishDate()
            );
        }
    }
    public void printAddress(){
        for(Address address: user.getAddressList()){
            address.showAdress();
        }
    }
    //public abstract void policy();
    public void addAddress(){
        AddressManager.addressAdd(this.user);
    }
    public void deleteAddress(){
        printAddress();
        System.out.print("Silmek istediğiniz adresin id numarasını yazın : ");
        int id=input.nextInt();
        AddressManager.deleteAddress(user,id);
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
