import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inn = new Scanner(System.in);

        /*ArrayList<BookList> library = new ArrayList<>();

        for (int i = 1; i <= 10; i++)
        {
            library.add(new BookList("Book " + i, "Author " + i, "Company x", new BookInstance(getRandomInteger(1, 10), StockType.inStock), Store.AliAndNino, "28 May"));
        }

         */

        ArrayList<BookList> library = new ArrayList<>();
        ArrayList<BookInstance> bookInstanceArrayList = new ArrayList<>();

        for (int i = 1; i <= 10; i++)
        {
            library.add(new BookList("Book " + i, "Author " + i, "Company x", Store.AliAndNino, "28 May", getRandomInteger(1, 10)));

            for(int j = 1; j <= library.get(i-1).getCount(); j++ )
            {
                bookInstanceArrayList.add(new BookInstance(library.get(i-1).getBook(), getRandomInteger(1, 10), StockType.inStock));
            }
        }

        int searchInstanse = inn.nextInt();

        /*
        for (BookList e: library)
        {
            if (searchInstanse == e.bookInstance.getSerialNumber()) System.out.println(e.details();
        }
         */

        for (BookInstance e: bookInstanceArrayList){
            if (searchInstanse == e.getSerialNumber()) System.out.println(e.instanceDetails());
        }

        String searchAuthorPublisher = inn.nextLine();

        int counterAll = 0;
        int counterSold = 0;
        int counterInStock = 0;

        for (BookList e: library){
            if(e.getAuthor().contains(searchAuthorPublisher) || e.getPublisher().contains(searchAuthorPublisher))
            {
                counterAll += e.getCount();
                /*
                if(e.bookInstance.getType() == StockType.sold) counterSold++;
                else counterInStock++;
                System.out.println(e.bookInstance.getSerialNumber() + " " + e.getBook() + " " + e.getAuthor());
                 */
                for(BookInstance z: bookInstanceArrayList){
                    if(z.getBookName() == e.getBook() && z.getType() == StockType.sold) counterSold++;
                    else if(z.getBookName() == e.getBook() && z.getType() == StockType.inStock) counterInStock++;
                }
            }
        }
        System.out.println("All: " + counterAll + ". Sold: " + counterSold + ". In stock: " + counterInStock);



    }
    public static int getRandomInteger(int maximum, int minimum)
    {
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

    public static double getRandomDouble(double min, double max) {
        return (new Random().nextDouble() * (max - min)) + min;
    }

}
