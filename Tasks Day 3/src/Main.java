import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner inn = new Scanner();

        ArrayList<Library> bookList = new ArrayList<>();

        Library book1 = new Library("Crime and Punishment", "Fyodr Dostoyevski",
                                    "2019", 300);
        //System.out.println(book1);
        bookList.add(book1);
        bookList.add(new Library("Hardboiled wonderland and the end of the world", "Haruki Murakami",
                                 "2020", 350));
        bookList.add(new Library("Confessions of a Mask", "Yukio Mishima",
                "2022", 200));
        bookList.add(new Library("Idiot", "Fyodr Dostoyevski",
                "2021", 400));
        bookList.add(new Library("No longer human", "Osamu Dazai",
                "2022", 150));

        //for(Library e: bookList) System.out.println(e);

        /*for(Library e: bookList){
            ArrayList<Unit> units = new ArrayList<>();
            for(int j = 0; j < 3; j++){
                units.add(new Unit("header_" + e.getBookName() + "_" +j, 10, "header" + j));
            }
            myBook.setUnits(units);
        }
         */



        //for(Library e: bookList)


        System.out.println(book1.details());



    }
}
