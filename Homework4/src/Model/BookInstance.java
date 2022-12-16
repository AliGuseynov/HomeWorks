package Model;

public class BookInstance {
    Book book;
    Publisher publisher;
    Branch branch;
    int id;
    int printYear;
    String bookState;

    public BookInstance(Book book, Publisher publisher, Branch branch, int id, int printYear, String bookState) {
        this.book = book;
        this.publisher = publisher;
        this.branch = branch;
        this.id = id;
        this.printYear = printYear;
        this.bookState = bookState;
    }

    @Override
    public String toString() {
        return " Kitab = " +book+ " Nəşriyyat = " + publisher + " Dükan = " + branch +
                "\n id = " + id + " Çap ili = " + printYear + " Hal hazırda = " + bookState + "\n --------------------------------------------";
    }
    public int getID(){
        return id;
    }

    public String publishername(){
        return publisher.name;
    }
    public String authorName(){
        return book.getAuthorNameL();
    }
    public String getBookState(){
        return bookState;
    }
}
