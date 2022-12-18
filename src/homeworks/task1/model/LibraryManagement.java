package homeworks.task1.model;

public class LibraryManagement {
    private String bookName;
    private String authorName;
    private String publishedDate;
    private int pageCount;

    public LibraryManagement(String bookName, String authorName, String publishedDate, int pageCount) throws Exception {
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishedDate = publishedDate;
//        this.pageCount = pageCount;
        setPageCount(pageCount);
    }

    public LibraryManagement() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) throws Exception {
        if (pageCount < 10) {
            throw new Exception("Dont enter less than 10 digits");
        }
            this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return authorName + ' ' +
                "\"\"" + bookName + "\"\"" + ' ' +
                publishedDate + ' ';
    }

    public String information() {

        return "Əsər: " + this.bookName + '\'' +
                "Müəllif:'" + this.authorName + '\'' +
                "Nəşr ili:'" + publishedDate + '\'' +
                "Səhifə sayı" + pageCount;
    }
}
