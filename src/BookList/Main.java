package BookList;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> books = new TreeSet<>(new ComporatorBookName());
        books.add(new Book("Bülbülü Öldürmek",500,"Harper Lee",1986));
        books.add(new Book("1984",600,"George Orwell",1943));
        books.add(new Book("Hayvan Çiftliği",150,"George Orwell",1946));
        books.add(new Book("Sefiller",700,"Victor Hugo",1936));
        books.add(new Book("Suç ve Ceza",300,"Dostoyevski",1956));

        for(Book a : books){
            System.out.println(a.getName());
        }
        System.out.println("+++++++++++++++++++++++");
        TreeSet<Book> books2 = new TreeSet<>(new ComporatorBookPage());
        books2.addAll(books);
        for(Book a : books2){
            System.out.println(a.getName());
        }
    }
}
