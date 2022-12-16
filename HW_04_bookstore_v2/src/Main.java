import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import model.*;

public class Main {

    public static int boodsId = 0;

    public static void main(String[] args) {

        Store libraff = new Store("Libraff");
        Store aliNino = new Store("Ali & Nino");

        Branch branch1 = new Branch("28 May", "28 Mall", "559876532", libraff);
        Branch branch2 = new Branch("28 May", "28 Mall", "551234568", aliNino);

        Publisher oReilly = new Publisher("O’Reilly");
        Publisher eksmo = new Publisher("eksmo");

        Book book1 = new Book("Fundamentals of Software Architecture", "Mark Richards, Neal Ford",
                oReilly, 2020, 600);
        Book book2 = new Book("JavaScript для начинающих. 6-е издание", "Майк МакГрат",
                eksmo, 2022, 232);
        Book book3 = new Book("Head First Design Patterns, 2nd Edition", " Eric Freeman, Elisabeth Robson",
                oReilly, 2020, 548);

        List<BookInstance> allBooks = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            allBooks.add(new BookInstance(boodsId++, book1));
        }

        for(int i = 0; i < 15; i++) {
            allBooks.add(new BookInstance(boodsId++, book2));
        }

        for(int i = 0; i < 25; i++) {
            allBooks.add(new BookInstance(boodsId++, book3));
        }

        //System.out.println(allBooks);
        
        //System.out.println(searchById(allBooks, 250));
        System.out.println(oReilly.toString());

        System.out.println(searchByAuthorAndPublisher(allBooks, "Mark Richards, Neal Ford", oReilly.toString()));

    }

    public static BookInstance searchById(List<BookInstance> books, int id) {
        for (BookInstance book: books) {
            if(book.getId() == id)
                return book;
        }
        return null;
    }

    public static List<BookInstance> searchByAuthorAndPublisher(List<BookInstance> books, String author, String publisher) {
        List<BookInstance> result = new ArrayList<>();

        int countOfStock = 0;

        for (BookInstance book: books) {


            if(author.equals(book.getBook().getAuthorName().getName()) &&
                    publisher.equals(book.getBook().getPublisher().getName())) {

                if (book.isInStock()) countOfStock ++;

                result.add(book);
            }
        }

        System.out.println("Total count: " + result.size());
        System.out.println("SOld: " + (result.size() - countOfStock));
        System.out.println("In Stock: " + countOfStock);

        return result;
    }

}