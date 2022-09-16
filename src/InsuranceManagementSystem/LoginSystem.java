package InsuranceManagementSystem;

import java.util.Scanner;

public class LoginSystem {
    AccountManager accountManager=new AccountManager();
    Scanner input = new Scanner(System.in);
    public void Login() {
        System.out.println("Hoşgeldiniz.!! \nEpostanızı giriniz:" );
        String eposta=input.nextLine();
        System.out.println("Şifrenizi giriniz:" );
        String pw=input.nextLine();
        Account loginAccount= accountManager.login(eposta,pw);
        if(loginAccount!=null){
            loginAccount.showUserInfo();
            menu(loginAccount);
        }else{
            System.out.println("Kullanıcı bulunamadı");
        }
    }
    private void menu(Account account){
        while(true){
            System.out.println("İşlem Listesi");
            System.out.println("1- Kullanıcı bilgilerini göster\n" +
                    "2- Kullanıcıya yeni poliçe yap\n" +
                    "3- Kullanıcıya yeni adres ekle\n" +
                    "4- Kullanıcı adresi sil\n" +
                    "0- Programdan çıkış yap.");
            System.out.print("Yapmak istediğiniz işlem numarasını yazın : ");
            int menuChoice= input.nextInt();
            switch (menuChoice){
                case 1:
                    account.showUserInfo();
                    break;
                case 2:
                    account.policy();
                    break;
                case 3:
                    account.addAddress();
                    break;
                case 4:
                    account.deleteAddress();
                    break;
                case 0:
                default:
                    System.exit(0);
            }
        }
    }
}
