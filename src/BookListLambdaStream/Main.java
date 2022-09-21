package BookListLambdaStream;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
            ArrayList<Book> bookList = new ArrayList<>();

            bookList.add(new Book("kitap1", 1, "tolstoy", "1992,12,3"));
            bookList.add(new Book("kitap2", 11, "dostoyevski", "1992,12,3"));
            bookList.add(new Book("kitap3", 14, "namık kemal", "1992,12,3"));
            bookList.add(new Book("kitap4", 41, "teyfik fikret", "1992,12,3"));
            bookList.add(new Book("kitap5", 13, "neyzen teyfik", "1992,12,3"));
            bookList.add(new Book("kitap6", 1131, "george orwell", "1992,12,3"));
            bookList.add(new Book("kitap7", 101, "viktor hugo", "1992,12,3"));
            bookList.add(new Book("kitap8", 311, "tolga abi", "1992,12,3"));
            bookList.add(new Book("kitap9", 143, "picasso", "1992,12,3"));
            bookList.add(new Book("kitap10", 34, "harper lee", "1992,12,3"));
            bookList.add(new Book("kitap11", 1143, "selma fındıklı", "1992,12,3"));

        Map<String,String> bookMap = new LinkedHashMap<>();
        bookList.stream().forEach(book -> bookMap.put(book.getName(),book.getAuthorName()));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        bookMap.keySet().stream().forEach(i-> System.out.println(i+": "+bookMap.get(i)));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<Book> books = bookList.stream().filter(book -> book.getPage() > 100).collect(Collectors.toList());
        books.stream().forEach(i-> System.out.println(i.getName()+" "+i.getPage()+" "+ i.getAuthorName()+" "+i.getPublishDate()));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


    }


}
