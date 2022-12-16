import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        initBooks();


    }

 public static void initBooks(){
     List <Book>books = new ArrayList();

     for (int i = 0; i<10; i++) {
         Book myBook = new Book("Kitab adı "+ i, "Test author" , 1920 + i*3, 10 + i*50);

         books.add(myBook);
     }

     // task 1
     for (int i = 0; i<books.size(); i++){
         System.out.println(books.get(i));
     }

     // task 2
     for(Book bookv: books){
         System.out.println(bookv.getBook());}
     }
 }