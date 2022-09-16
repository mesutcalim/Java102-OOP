package InsuranceManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressManager {
    public static void addressAdd(User user){
        Scanner input= new Scanner(System.in);
        Address newAddress;
        System.out.println("Adres Ekleme Alanı");
        System.out.println("Eklemek istediğiniz adres türünü seçiniz: \n1-Ev Adresi\2-İş Adresi");
        int addressChoice= input.nextInt();
        System.out.println("Şehir giriniz: ");
        String city= input.nextLine();
        System.out.println("İlçe Giriniz: ");
        String district = input.nextLine();
        System.out.println("Adres açıklaması giriniz: ");
        String details = input.nextLine();
        if(addressChoice == 1){
            newAddress = new HomeAddress(city,district,details);

        }else{
            newAddress = new BusinessAddress(city,district,details);
        }
        user.setAddressList(newAddress);
    }
    public static void deleteAddress(User user,int id){
        user.getAddressList().remove(id-1);
        System.out.println("Başarıyla sildiniz.");
    }

}
