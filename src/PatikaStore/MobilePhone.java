package PatikaStore;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone extends  Product {
    private static int pId = 1;
    private int battery;
    private String color;
    private static ArrayList<MobilePhone> phones = new ArrayList<>();
    public MobilePhone(){

    }
    public MobilePhone(int id, String name, double price, int discountRate,
                       int amount, Brand brand, double screenSize, int ram, int memory, int battery, String color) {
        super(id, name, price, discountRate, amount, brand, screenSize, ram, memory);
        pId++;
        this.battery = battery;
        this.color = color;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void menu() {
        System.out.println("1- Yeni Telefon ekle\n" +
                "2- Telefon listesini görüntüle\n" +
                "3- Telefon sil\n" +
                "4- Telefonları id numarasına göre sırala\n" +
                "5- Telefonları markaya göre filtrele");
        System.out.print("Yapmak istediğiniz işlemi seçiniz : ");
        int value=input.nextInt();
        if(value==1) addItem();
        if(value==2 || value==4) getProducts();
        if(value==3) deleteItem();
        if(value==5) brandFilter();
    }
    @Override
    public void addItem() {
        System.out.print("Ürün adını giriniz: ");
        String name = input.next();
        System.out.print("Ürün ücretini giriniz: ");
        double price = input.nextDouble();
        System.out.print("Ürün indirim oranı giriniz: %");
        int discountRate = input.nextInt();
        System.out.print("Ürün stokunu giriniz: %");
        int amount= input.nextInt();
        System.out.print("Marka Seçiniz: ");
        Brand.printBrands();
        Brand brand = Brand.getBrandByID(input.nextInt());
        System.out.print("Ürün ekran boyutu giriniz: ");
        double screenSize = input.nextDouble();
        System.out.print("Ürün ramini giriniz: ");
        int ram= input.nextInt();
        System.out.println("Ürün hafızasını giriniz: ");
        int memory= input.nextInt();
        System.out.println("Ürün batarya kapasitesi giriniz: ");
        int battery= input.nextInt();
        System.out.println("Ürün rengi giriniz: ");
        String color = input.next();
        phones.add(new MobilePhone(pId,name,price,discountRate,amount,brand,screenSize,ram,memory,battery,color));
        System.out.println("Eklenen telefon ıd'si: "+ pId);
    }

    @Override
    public void getProducts() {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyatı          | Markası         | Stoğu        | İndirim Oranı      | RAM    | Ekran Boyutu      | Hafızası   | Pil Kapasitesi  | Renk           | Kamera    |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (MobilePhone n:phones){
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | %-15s | %-14s | %-9s | \n",
                    n.getId(),n.getName(),n.getPrice(),n.getBrand().getBrandName(),n.getAmount(),
                    n.getDiscountRate(),n.getRam(),n.getScreenSize(),n.getMemory(),n.getBattery(),n.getColor());
        }

    }

    @Override
    public void deleteItem() {
        getProducts();
        System.out.print("Silinmesini istediğiniz telefonun Id numarasını giriniz : ");
        int id=input.nextInt();
        phones.remove(id-1);
        System.out.println("Güncel telefon listesi ");
        getProducts();
    }
    @Override
    public void brandFilter(){
        System.out.println("Filtrelemek istediğiniz ürünün markasını seçiniz: ");
        for(Brand b:brands){
            System.out.println(b.getId()+" "+b.getBrandName());
        }
        int filter = input.nextInt();

        if(filter>0 && filter<=brands.size()) {
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("| ID | Ürün Adı                  | Fiyatı          | Markası         | Stoğu        | İndirim Oranı      | RAM    | Ekran Boyutu      | Hafızası   | Pil Kapasitesi  | Renk           | Kamera    |");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            for (MobilePhone mp : phones) {
                if (Brand.getBrandByID(filter)==mp.getBrand()){
                    System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | %-15s | %-14s | %-9s | \n",
                            mp.getId(),mp.getName(),mp.getPrice(),mp.getBrand().getBrandName(),mp.getAmount(),
                            mp.getDiscountRate(),mp.getRam(),mp.getScreenSize(),mp.getMemory(),mp.getBattery(),mp.getColor());
                }
            }
        }
    }

    public static int getpId() {
        return pId;
    }


}
