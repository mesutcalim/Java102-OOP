package UniversiteYonetimi;

public class UniversiteYonetimi {
    public static void main(String[] args) {
        Akademisyen a1= new Akademisyen("Metin","0324321234","asdfasdf@gmail.com","E-E-ENG","Docent");
        Asistan as1 = new Asistan("Mustafa","05677655432","sadasaas@gmail.com","C-ENG","YarDocent","12:30-16:30");
        BilgiIslem b1 = new BilgiIslem("Derya","09876543211","hadsafhada@gmail.com","CHE","08:30-16:30","Bilgi işlem");
        Calisan c1 = new Calisan("Yaşar", "0985432122","yasaronline@gmail.com");
        GuvenlikGorevlisi g1 = new GuvenlikGorevlisi("Bekir","05323232324","bekirtekir@gmail.com","koruma","17:00-07:00","Giriş İzni Belgesi");
        LabAsistani l1 = new LabAsistani("Samet","05955959595","samet@gmail.com","EEE","Doctor","13:30-16:30");
        Memur m1= new Memur("Ahmet","05715717171","ahmet@hotmail.com","EEM","8:45-18:45");
        OgretimGorevlisi o1 = new OgretimGorevlisi("Mesut","05415414141","mesut@gmail.com","EEE","Ordinaryus",312);

        a1.derseGir();
        as1.quizYap();
        b1.networkKurulumu();
        c1.yemekhane();
        g1.nobet();
        l1.lablaraGir();
        m1.calis();
        o1.senatoToplanti();
    }
}
