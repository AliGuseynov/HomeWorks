package Model;

public class Book {
    String bookName;
    Author authorName;
    int publishedDate;
    int pageCount;
    Publisher publisher;

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }




    public Book(String bookName, Author authorName, int publishedDate, int pageCount) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishedDate = publishedDate;
        setPageCount(pageCount);
    }


    @Override
    public String toString() {
        return authorName.name + " \"" + bookName + "\" " + publishedDate;
    }

    public String getBook(){
        return "" + bookName + "\n"
                + "" + authorName.name + "\n"
                + "" + publishedDate + "\n"
                + "" + pageCount + "\n";
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthorName() {
        return authorName;
    }

    public String getAuthorNameL(){
        return authorName.name;
    }

    public void setAuthorName(Author authorName) {
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
