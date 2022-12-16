public class Book {
    String bookName;
    String authorName;
    int publishedDate;
    int pageCount;


    public Book(String bookName, String authorName, int publishedDate, int pageCount) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishedDate = publishedDate;
        setPageCount(pageCount);
    }

    @Override
    public String toString() {
        return authorName + " \"" + bookName + "\" " + publishedDate;
    }

    public String getBook(){
        return "" + bookName + "\n"
                + "" + authorName + "\n"
                + "" + publishedDate + "\n"
                + "" + pageCount + "\n";
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

    public int getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(int publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        if (pageCount < 10) {
            throw new RuntimeException("Səhifə sayı 10-dan azdır");
        }
        this.pageCount = pageCount;
    }
}
