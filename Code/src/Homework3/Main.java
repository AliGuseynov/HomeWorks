package Homework3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       Library book=new Library("Qərb bürküsü","Çingiz Abdullayev","2013",20);
//       book.setPageCount(8);
       Library book1=new Library("Martin Iden","Cek London","1909",540);
       Library book2=new Library("Ovod","E.L.Voyniç","1900",500);
       List<Library> list=new ArrayList<>();
       list.add(book);
       list.add(book1);
       list.add(book2);

        System.out.println(book);
//       for(Library lib:list){
//           System.out.println(lib);
//       }

       String ss=Library.bookCall("Qərb bürküsü");
        System.out.println(ss);


    }
}