package UniversiteYonetimi;

public class OgretimGorevlisi extends Akademisyen {
    private int kapiNo;

    public OgretimGorevlisi(String adSoyad, String telefon, String eposta, String bolum, String unvan, int kapiNo) {
        super(adSoyad, telefon, eposta, bolum, unvan);
        this.kapiNo = kapiNo;
    }

    public int getKapiNo() {
        return kapiNo;
    }

    public void setKapiNo(int kapiNo) {
        this.kapiNo = kapiNo;
    }
    public void senatoToplanti(){
        System.out.println(getAdSoyad() + " Senato Toplantısına girdi..!!");
    }
    public void sinavYap(){
        System.out.println(getAdSoyad() + " Sınav Yapıyor");
    }
}
