package model;
public class Book {
    private String name;
    private String authorName;
    private int publishedYear;
    private int pageCount;

    public Book() {
    }

    public Book(String name, String authorName, int publishedYear, int pageCount) {
        this.name = name;
        this.authorName = authorName;
        this.publishedYear = publishedYear;
        setPageCount(pageCount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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
