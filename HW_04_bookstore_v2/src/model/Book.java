package model;

import java.util.List;

public class Book {
    private String name;
    private Author authorName;
    private int publishedYear;
    private int pageCount;
    private List<Unit> units;

    private  Publisher publisher;

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Book() {
    }

    public Book(String name, String authorName, Publisher publisher, int publishedYear, int pageCount) {
        this.name = name;
        this.authorName = new Author(authorName);
        this.publisher = publisher;
        this.publishedYear = publishedYear;
        setPageCount(pageCount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        if(pageCount < 10){
            throw new RuntimeException("Page count should be more than 10");
        }
        this.pageCount = pageCount;
    }

    public Author getAuthorName() {
        return authorName;
    }

    public void setAuthorName(Author authorName) {
        this.authorName = authorName;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public String getDetails(){

        return "Əsər: " + name + "\n"
                + "Müəllif: " + authorName + "\n"
                + "Nəşr ili: " + publishedYear + "\n"
                + "Səhifə sayı: " + pageCount + "\n";
     }

    @Override
    public String toString() {
        return authorName + " \"" + name + "\" " + publishedYear;
    }
}
