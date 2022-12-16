import java.util.*;

public class Library {
    private String bookName;
    private String authorName;
    //private Date publishDate;
    private String publishDate;
    private int pageCount;
    private List<Unit> units;

    public Library(String bookName, String authorName, String publishDate, int pageCount)
    {
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishDate = publishDate;
        setPageCount(pageCount);
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPublishDate() {
        return publishDate;
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

    public String toString(){
        return authorName +  "\"" +  bookName + "\"" + publishDate;
    }

    public String details(){
        return "Əsər: " + bookName + "\nMüəllif: " + authorName + "\nNəşr ili: " + publishDate + "\nSəhifə sayı: " + pageCount;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }
}
