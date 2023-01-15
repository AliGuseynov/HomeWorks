import org.example.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("org.example.store");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
//        Store store=buildNewStore();
        Author author=Author.builder().name("Cek London").build();
//        author=author.toBuilder().books(
//                List.of(Book.builder().bookName("The Gadfly").author(author).build(),
//                        Book.builder().bookName("Olive Latham").author(author).build())
//        ).build();
        Book book=Book.builder().bookName("Martin Iden").author(author).build();
        Store store=Store.builder().storeName("BookStore").build();
        Branch branch=Branch.builder().branchName("Sahil").store(store).build();
        Publisher publisher=Publisher.builder().name("Qanun").build();
        BookInstance bookInstance=BookInstance.builder().book(book).barcode("LL123472").branch(branch).publisher(publisher).build();
        em.merge(bookInstance);
        em.getTransaction().commit();
        em.close();
    }


    public static Store buildNewStore(){
        Store store=Store.builder().storeName("Libraff").build();
        store= store.toBuilder().branches(
                List.of(Branch.builder().branchName("Nizamikucesi").store(store).build(),
                        Branch.builder().branchName("XalqlarDostlugu").store(store).build())).build();
        return store;
    }
}