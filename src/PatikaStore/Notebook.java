package PatikaStore;

import java.util.ArrayList;

public class Notebook extends Product{
    private static int nId=1;
    private static ArrayList<Notebook> notebooks = new ArrayList<>();

    public Notebook(int id,String name, double price, int discountRate, int amount, Brand brand, double screenSize, int ram, int memory) {
        super(nId, name, price, discountRate, amount, brand, screenSize, ram, memory);
        nId++;
    }

    public Notebook() {

    }

    @Override
    public void menu() {
        System.out.println("1- Yeni Notebook ekle\n" +
                "2- Notebook listesini görüntüle\n" +
                "3- Notebook sil\n" +
                "4- Notebookları id numarasına göre sırala\n" +
                "5- Notebookları markaya göre filtrele");
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
        input.nextLine();
        double price = input.nextDouble();
        System.out.print("Ürün indirim oranı giriniz: %");
        int discountRate = input.nextInt();
        System.out.print("Ürün stokunu giriniz: ");
        int amount= input.nextInt();
        System.out.print("Marka Seçiniz: ");
        Brand.printBrands();
        Brand brand = Brand.getBrandByID(input.nextInt());
        System.out.print("Ürün ekran boyutu giriniz: ");
        double screenSize = input.nextDouble();
        System.out.print("Ürün ramini giriniz: ");
        int ram= input.nextInt();
        System.out.print("Ürün hafızasını giriniz: ");
        int memory= input.nextInt();
        notebooks.add(new Notebook(nId,name,price,discountRate,amount,brand,screenSize,ram,memory));
        System.out.println("Eklenen notebook ıd'si: "+ (nId-1));
    }

    @Override
    public void getProducts() {
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyatı          | Markası         | Stoğu        | İndirim Oranı      | RAM    | Ekran Boyutu      | Hafızası   |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        for(Notebook nb:notebooks){
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | \n",
                    nb.getId(),nb.getName(),nb.getPrice(),nb.getBrand().getBrandName(),nb.getAmount(),
                    nb.getDiscountRate(),nb.getRam(),nb.getScreenSize(),nb.getMemory());
        }
    }

    @Override
    public void deleteItem() {
        getProducts();
        System.out.print("Silinmesini istediğiniz notebook Id numarasını giriniz : ");
        int id=input.nextInt();
        notebooks.remove(id-1);
        System.out.println("Güncel notebook listesi ");
        getProducts();
    }
    @Override
    public void brandFilter(){
        System.out.println("Filtrelemek istediğiniz ürünün markasını seçiniz: ");
        Brand.printBrands();
        int filter = input.nextInt();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyatı          | Markası         | Stoğu        | İndirim Oranı      | RAM    | Ekran Boyutu      | Hafızası   |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Notebook np : notebooks) {
                if (filter==np.getBrand().getId()){
                    System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | \n",
                            np.getId(),np.getName(),np.getPrice(),np.getBrand().getBrandName(),np.getAmount(),
                            np.getDiscountRate(),np.getRam(),np.getScreenSize(),np.getMemory());
                }
            }
        }

    public static int getnId() {
        return nId;
    }
}
