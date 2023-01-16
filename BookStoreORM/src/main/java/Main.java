import az.code.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("code");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("start");
        entityManager.getTransaction().begin();


        Store store = Store.builder().storeName("Ali&Nino").build();
        List<Branch> branchList = List.of(
                Branch.builder().branchName("28may").store(store).build(),
                Branch.builder().branchName("Genclik").store(store).build());

        Branch branch1=Branch.builder().branchName("28may").store(store).build();


        store.setBranches(branchList);
//?????????????????????????????????????????????
        BookInstance bookInstance=BookInstance.builder().barcode("1212").branch(branch1).build();


//
//        Book book = Book.builder().bookName("name1").build();
//        List<Publisher> publishers=List.of(Publisher.builder().book(book).build();
//        book.setPublishers(publishers);





        entityManager.persist(bookInstance);


//        List<Author> authorList = Arrays.asList(Author.builder().authorName("author1").build(),
//                Author.builder().authorName("author2").build(),
//                Author.builder().authorName("author3").build()
//        );
//
//        for (Author auth : authorList) {
//            entityManager.merge(auth);
//        }
//        List<Book> books = Arrays.asList(
//                Book.builder().bookName("book 1").build(),
//                Book.builder().bookName("book 2").build(),
//                Book.builder().bookName("book 3").build()
//        );
//        for (Book book : books) {
//            entityManager.merge(book);
//        }

//        List<Author> authors = entityManager.createQuery("SELECT a from Author a").getResultList();
//        List<Book> books = entityManager.createQuery("SELECT a FROM Book a").getResultList();
//
//        authors.get(2).setBookList(Arrays.asList(books.get(0), books.get(1), books.get(2)));
//        authors.get(1).setBookList(Arrays.asList(books.get(0)));
//        authors.get(0).setBookList(Arrays.asList(books.get(1), books.get(2)));
















        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
