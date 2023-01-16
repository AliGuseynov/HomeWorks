import az.code.models.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("org.example.store");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
//        Store store=buildNewStore();







//        Author author=Author.builder().name("Cek London").build();
//        List<Author> authors = Arrays.asList(Author.builder().name("Mayn Rio").build(),
//        Author.builder().name("Chingiz Abdullayev").build(),Author.builder().name("Misir Merdenov").build());
//
//        for(Author auth : authors){
//            em.merge(auth);
//        }
//
//
//        List<Book> books = Arrays.asList(
//                Book.builder().bookName("Book 1").build(),
//                Book.builder().bookName("Book 2").build(),
//                Book.builder().bookName("Book 3").build()
//        );
//        for(Book book : books){
//            em.merge(book);
//        }


//
//        List<Author> authors = em.createNamedQuery("all").getResultList();
//        List<Book> books = em.createQuery("SELECT a FROM Book a").getResultList();
//
//
//            authors.get(2).setBooks(Arrays.asList(books.get(0), books.get(1), books.get(2)));
//            authors.get(1).setBooks(Arrays.asList(books.get(0)));
//            authors.get(0).setBooks(Arrays.asList(books.get(1), books.get(2)));
//
//        System.out.println(authors.get(0).getBooks().size());

//            books.get(0).setAuthors(Arrays.asList(authors.get(0), authors.get(2)));
//            books.get(1).setAuthors(Arrays.asList(authors.get(1), authors.get(2)));
//            books.get(2).setAuthors(Arrays.asList(authors.get(1), authors.get(2)));

//        author=author.toBuilder().books(
//                List.of(Book.builder().bookName("The Gadfly").author(author).build(),
//                        Book.builder().bookName("Olive Latham").author(author).build())
//        ).build();
        Book book = Book.builder().bookName("Shahmat").build();
        List<Publisher> publishers=List.of(Publisher.builder().book(book).name("Qanun").build(),
                Publisher.builder().book(book).name("Sherq neshriyyat").build());
        book.setPublishers(publishers);
//        Store store=Store.builder().storeName("BookStore").build();
//        Branch branch=Branch.builder().branchName("Sahil").store(store).build();
//        Publisher publisher=Publisher.builder().name("Qanun").book(book).build();
//        Branch branch = em.find(Branch.class, 9l);
//        BookInstance bookInstance=BookInstance.builder().barcode("LL123472").branch(branch).book(book).build();
//        for(Author auth : authors){
//            em.merge(auth);
//        }
        em.merge(book);
        em.getTransaction().commit();
        em.close();
    }


    public static Store buildNewStore(){
        Store store=Store.builder().storeName("BakuBookCenter").build();
        List<Branch> branches = List.of(Branch.builder().branchName("Sahil").store(store).build(),
                        Branch.builder().branchName("Ehmedli").store(store).build());
        store.setBranches(branches);
        return store;
    }
}