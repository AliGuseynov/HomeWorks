import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) {


        List<Author> authors = createAuthors();
        List<Publisher> publishers = createPublishers();
        List<Store> stores = createStore();
        List<Branch> branches = createBranch(stores);
        List<Book> books = createBooks(authors, publishers);

        int lastBookId = 0;

        List<BookInstance> bookInstances = generateRandomBookInstances(books, lastBookId, publishers, branches );

//        for (int i = 0; i<books.size();i++){
//            System.out.println(books.get(i));
//        }

//        System.out.println("==========================");
//        for (int i = 0; i<bookInstances.size();i++){
//            System.out.println(bookInstances.get(i));
//        }


        // Task 1.1 ==================================
        // System.out.println(findBookInstance(bookInstances,1996));

        // Task 1.2 ==================================
        //findBookInstance2(bookInstances, "William Shakespeare", "World Publishing Company");

        Task2("matata", 'j');

    }


    public static List<Author> createAuthors(){
        List<Author> authors = new ArrayList<>();

        Author wShakespeare = new Author("William Shakespeare", "England", 1564);
        authors.add(wShakespeare);
        Author fKafka = new Author("Franz Kafka", "Czechia", 1883);
        authors.add(fKafka);
        Author eHemingway = new Author("Ernest Hemingway", "England", 1564);
        authors.add(eHemingway);

        return authors;
    }

    public static List<Publisher> createPublishers(){

        List<Publisher> publishers = new ArrayList<>();

        Publisher azpoliqraf = new Publisher("Azpoliqraf", "Azerbaijan", true);
        publishers.add(azpoliqraf);
        Publisher yazichi = new Publisher("Yazıçı", "Azerbaijan", true);
        publishers.add(yazichi);
        Publisher wpc = new Publisher("World Publishing Company", "USA", false);
        publishers.add(wpc);

        return publishers;
    }

    public static List<Store> createStore(){
        List<Store> stores = new ArrayList<>();

        Store libraff = new Store("Libraff", "Azerbaijan");
        stores.add(libraff);
        Store aliandnino = new Store("Ali və Nino", "Azerbaijan");
        stores.add(aliandnino);
        Store wallmart = new Store("Wallmart", "USA");
        stores.add(wallmart);

        return stores;
    }

    public static List<Branch> createBranch(List<Store> stores){
        List<Branch> branches = new ArrayList<>();


        Branch ganjlik = new Branch(stores.get(0),"Libraff Gənclik mall", "Gənclik mall, Baku", 18);
        branches.add(ganjlik);
        Branch iyirmiSekkizMall = new Branch(stores.get(1),"Ali & Nino 28 mall", "28 mall, Baku", 12);
        branches.add(iyirmiSekkizMall);
        Branch NewYork = new Branch(stores.get(2),"Wallmart 1568", "New York", 16);
        branches.add(NewYork);
        Branch nizamiStr = new Branch(stores.get(1),"Ali & Nino, Nizami", "Nizami street, Baku", 8);
        branches.add(nizamiStr);

        return branches;
    }

    public static List<Book> createBooks(List<Author> authors, List<Publisher> Publishers){

        List<Book> booksList = new ArrayList<>();

        Random rand = new Random();

        for (int i = 0; i < 10; i++){
            Author author = authors.get(rand.nextInt(0,3));
            int randomyear = author.getBirthYear()+20;
            Book book = new Book("Test kitab" + i, author,
                    rand.nextInt(randomyear, randomyear + 16)+rand.nextInt(16), 10+i*5);
            booksList.add(book);
        }
            return booksList;
    }

    public static List<BookInstance> generateRandomBookInstances(List<Book> books, int ids,
                                                         List<Publisher> publishers, List<Branch> Branches){
        List<BookInstance> bookInstances = new ArrayList<>();

        Random rand = new Random();
        for (int i = 0; i<25; i++){
            Book tempBook = books.get(rand.nextInt(books.size()));
            Publisher tempPublisher = publishers.get(rand.nextInt(publishers.size()));
            Branch tempBranch = Branches.get(rand.nextInt(Branches.size()));

            List<String> states = new ArrayList<>();
            states.add("In stock");
            states.add("Sold");

            int year = rand.nextInt(1950, 2022);
            for (int j = 0; j < rand.nextInt(500, 5000);j++){
            BookInstance bookInstanceN = new BookInstance( tempBook,
                    tempPublisher, tempBranch,
                    ids ++, year, states.get(rand.nextInt(2)));

                bookInstances.add(bookInstanceN);}
        }
        return bookInstances;
    }


    //       Task 1.1 find by id ------------------------------------------------------------
    public static BookInstance findBookInstance (List<BookInstance> bookInstances, int id){

        BookInstance foundBook = null;
        for (int i = 0; i < bookInstances.size(); i++){
            BookInstance temp = bookInstances.get(i);
            if (temp.getID() == id){
                foundBook = temp;
            }
        }
        return foundBook;

    }

    //       Task 1.2 find by author/Publisher ------------------------------------------------------------
    public static void findBookInstance2 (List<BookInstance> bookInstances, String authorName, String publisherName){

        List<BookInstance> foundBooks = new ArrayList<>();
        int found = 0;
        int sold = 0;
        int inStock = 0;
        BookInstance foundBook = null;
        for (int i = 0; i < bookInstances.size(); i++){
            BookInstance temp = bookInstances.get(i);
            if (temp.authorName() == authorName && temp.publishername() == publisherName){
                foundBooks.add(temp);
                found++;
                if (temp.getBookState() == "Sold"){
                    sold++;
                }else {
                    inStock++;
                }
            }
        }
        System.out.println("==========================");
        for (int i = 0; i<foundBooks.size();i++){
            System.out.println(foundBooks.get(i));
        }
        System.out.println("Tapılan kitab = " + found
        +"\nSatılmış kitab = " + sold
                +"\nSatışda olan = " + inStock);




    }



    public static void Task2(String word, char character){

        char[] arr = word.toCharArray();
        int counter = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == character){
                counter++;
            }
        }

        if (counter > 0){
            System.out.println(character + " hərfi " + counter + " dəfə təkrarlanır");
        } else {
            System.out.println(word + " sozündə " + character + " hərfi yoxdur");
        }

    }

 }