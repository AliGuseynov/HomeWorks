package bookstore;

import bookstore.models.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.Bookstore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<BookInstance> books = em.createNamedQuery("all_bookInstances").getResultList();

        books.forEach(System.out::println);

        em.close();

//        seedDB();

//        searchBookByNameCriterias();
    }

    private static void seedDB(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.Bookstore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


//        createStores(em);


//        List<Store> stores = em.createNamedQuery("all_stores").getResultList();
//
//        List<Branch> branches = em.createNamedQuery("all_branches").getResultList();

//        updateStores(stores, branches, em);


//         createBooks(em);

//        updateBooks(em);

//        createPublisher(em);

//        createBookInstance(em);



        em.getTransaction().commit();
        em.close();
    }

    private static void createStores(EntityManager em){
        Store store = Store.builder().store_name("Libraff 7").build();

        List<Branch.BranchBuilder> tempBranches = List.of(
                Branch.builder().branch_name("Ganjlik 7"),
                Branch.builder().branch_name("28 mall 7")
                );

        List<Branch> branchesBuilded = new ArrayList<>();

        for (Branch.BranchBuilder branch: tempBranches){
            Branch tempbranch2 = branch.build();
            branchesBuilded.add(tempbranch2);
            em.merge(tempbranch2);
        }

        em.merge(store);
    }

    private static void updateStores(List<Store> stores, List<Branch> branches, EntityManager em){


        System.out.println(stores.size() + " stores");

        for (Store store: stores){
            store.setBranches(branches);
            em.merge(store);
        }

        updateBranches(stores, branches, em);
    }

    private static void updateBranches(List<Store> stores, List<Branch> branches, EntityManager em){
        for (int i = 0; i< branches.size(); i++){
            Branch branch = branches.get(i);
            branch.setStore(stores.get(0));
            System.out.println(branch.getBranch_name());
            em.merge(branch);
            System.out.println(branch.getStore().getStore_name());
        }
    }


    private static void createBooks(EntityManager em){
        List<Author> authors = List.of(
                Author.builder().author_name("A.S. Pushkin").build(),
                Author.builder().author_name("Stephen Hawking").build()
                );

        List<Book> books = List.of(
          Book.builder().book_name("Dubrovsky").build(),
        Book.builder().book_name("A Brief History of Time").build(),
        Book.builder().book_name("The theory of everything").build(),
        Book.builder().book_name("The grand design").build()
        );

        for (int i = 0; i < books.size(); i++){
            em.merge(books.get(i));
        }

        for (int i = 0; i < authors.size(); i++){
            em.merge(authors.get(i));
        }
    }

    private static void updateBooks(EntityManager em){
        List<Author> authors = em.createNamedQuery("all_authors").getResultList();
        List<Book> books = em.createNamedQuery("all_books").getResultList();

        ArrayList<Book> books1 = new ArrayList<>();
        books1.add(books.get(0));
        books1.add(books.get(1));

        ArrayList<Book> books2 = new ArrayList<>();
        books1.add(books.get(1));
        books1.add(books.get(2));
        books1.add(books.get(3));


        authors.get(0).setBooks(books1);
        authors.get(1).setBooks(books2);

        for (Author author:authors){
            System.out.println(author.getAuthor_name());
            em.merge(author);
        }
        for (Book book: books){
            System.out.println(book.getBook_name());
            em.merge(book);
        }
    }

    private static void createPublisher(EntityManager em){

        Publisher pub = Publisher.builder().publisher_name("New Reality").build();
        em.merge(pub);

    }

    private static void createBookInstance(EntityManager em){

        List<Book> books = em.createNamedQuery("all_books").getResultList();
        List<Publisher> publishers = em.createNamedQuery("all_publishers").getResultList();
        List<Branch> branches = em.createNamedQuery("all_branches").getResultList();

        Book tempbook = books.get(randomint(books.size() -1, 0));
        Branch tempbranch = branches.get(randomint(branches.size() -1, 0));
        Publisher temppublisher = publishers.get(randomint(publishers.size() -1, 0));



        for (int i = 0; i < 100; i++){
            BookInstance book = BookInstance.builder()
                    .book(tempbook)
                    .branch(tempbranch)
                    .publisher(temppublisher)
                    .build();

            em.merge(book);
        }

    }

    private static void searchBookByName(EntityManager em){

        TypedQuery<Book> bookTypedQuery
                = em.createQuery(
                "SELECT e FROM Book e  JOIN e.authors auth WHERE auth.author_name LIKE 'A.S.%'", Book.class);
        List<Book> resultList = bookTypedQuery.getResultList();

        resultList.forEach(System.out::println);
    }

    private static void searchBookByNameCriterias(){
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.Bookstore");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//
//        CriteriaQuery<Book> createQuery = builder.createQuery(Book.class);
//        Root<Book> root = createQuery.from(Book.class);
//        createQuery.select(root).where(builder.like(root.get("book_name"), "The%"));
//
//        List<Book> bookList = em.createQuery(createQuery).getResultList();
//
//        bookList.forEach(System.out::println);
//
//
//
//        em.close();

    }

    private static int randomint(int max, int min){
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
