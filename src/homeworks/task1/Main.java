package homeworks.task1;

import homeworks.task1.model.LibraryManagement;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        List<LibraryManagement> libraryManagementList = new ArrayList<>();

        LibraryManagement libraryManagement = new LibraryManagement();
//        libraryManagement.add("Qərb bürküsü",
//                "Çingiz Abdullayev", "2013", 100);

        libraryManagementList.add(new LibraryManagement("Qərb bürküsü",
                "Çingiz Abdullayev", "2013", 100));
        libraryManagementList.add(new LibraryManagement("Etiraflar Vadisi",
                "Çingiz Abdullayev", "2015", 3));


        for (LibraryManagement books : libraryManagementList) {
//            System.out.println(books);
            System.out.println(books.information());
        }

    }
}

