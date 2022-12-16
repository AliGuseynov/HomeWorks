import java.util.ArrayList;
import java.util.List;

import model.Book;

public class Main {
    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        int year = 1900;
        int page = 600;

        for(int i = 0; i < 5; i++) {

            Book myBook = new Book("name" + i, "author" + i, year++, page++);
            books.add(myBook);
        }

        for(Book book: books){
            System.out.println(book.toString());
            System.out.println("---------------------------------");
            System.out.println(book.getDetails());
        }
    }
}