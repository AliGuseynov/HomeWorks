import Model.Item;
import Model.ItemCategory;
import Repositories.Repository;

import UI.UI;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Repository repository = new Repository();

        UI.run(repository);

    }


}