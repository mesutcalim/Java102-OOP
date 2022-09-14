package PatikaStore;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.TreeSet;

public class Brand {
    private int id;
    private String brandName;
    private static TreeSet<Brand> brandList=new TreeSet<>(new Comparator<Brand>() {
        @Override
        public int compare(Brand b1, Brand b2) {
            return b1.brandName.compareTo(b2.brandName);
        }
    });
    static{
        createBrands();
    }

    public Brand(int id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    public int getId() {
        return id;
    }
    public void setId(int ID){
        this.id=ID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public static void createBrands(){
        brandList.add(new Brand(1,"Samsung"));
        brandList.add(new Brand(2,"Lenovo"));
        brandList.add(new Brand(3,"Apple"));
        brandList.add(new Brand(4,"Huawei"));
        brandList.add(new Brand(5,"Casper"));
        brandList.add(new Brand(6,"Asus"));
        brandList.add(new Brand(7,"Hp"));
        brandList.add(new Brand(8,"Xioami"));
        brandList.add(new Brand(9,"Monster"));
        int i=1;
        for(Brand b:brandList){
            b.setId(i);
            i++;
        }
    }
    public static void printBrands(){
        System.out.println("Markalarımız");
        for(Brand b:brandList){
            System.out.println(b.getId()+" "+ b.getBrandName());
        }
        System.out.println("----------------------------------");

    }
    public static Brand getBrandByID(int id){
        for(Brand b:brandList){
            if(b.getId()==id){
                return b;
            }
        }
        return null;
    }
}
