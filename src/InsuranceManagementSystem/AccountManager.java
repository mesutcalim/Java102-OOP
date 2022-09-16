package InsuranceManagementSystem;

import java.time.LocalDate;
import java.util.Date;
import java.util.TreeSet;

public class AccountManager {
    TreeSet<Account> accounts = new TreeSet<>();

    public void addUsers() throws  ClassCastException{
        Address adres1 = new HomeAddress("Niğde","Merkez","Bim Yanı");
        User user1=new User("Mesut","Çalım","mesutcalim.eee@gmail.com","1234567890","Yazılımcı",24,adres1,"Individual");
        Account account = new Individual(user1);

        Address adres2 = new BusinessAddress("Ankara","Çankaya","Gazi Teknokent 5.Blok 8.Kat");
        User user2=new User("Ali", "Veli", "aliveli@gmail.com", "456", "doktor", 43, adres2,"Business" );
        Account account2=new Enterprise(user2);
        accounts.add(account);
        accounts.add(account2);
    }
    public Account login(String email, String password){
        addUsers();
        try{
            for(Account a:accounts){
                if(a.getUser().getEmail().equals(email)&& a.getUser().getPassword().equals(password)){
                    a.login(email,password,a);
                    return a;
                }
            }
            throw new InvalidAuthenticationException("Şifre veya email yanlış girildi!");
        }
        catch (InvalidAuthenticationException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
