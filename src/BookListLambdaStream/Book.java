package BookListLambdaStream;

import java.util.ArrayList;

public class Book {
    private String name;
    private int page;
    private String authorName;
    private String publishDate;

    public Book(String name, int page, String authorName, String publishDate) {
        this.name = name;
        this.page = page;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
