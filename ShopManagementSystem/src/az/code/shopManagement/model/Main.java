package az.code.shopManagement.model;

import az.code.shopManagement.service.Marketable;
import az.code.shopManagement.service.Operation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Marketable.generateProduct();
        Operation.firstOption();

 /*       Marketable.mainMenu();
        int OPTION = scan.nextInt();
        switch (OPTION) {
            case (1): {
                Marketable.productOperations();
                break;
            }
            case (2): {

            }
            case (3): {

            }
        }

        int FIRST_OPTION = scan.nextInt();
        if(FIRST_OPTION == 1){
        switch (FIRST_OPTION) {
            case (1): {
                Marketable.createNewProduct();

                break;
            }
            case (2): {

            }
            case (3): {

            }
            case (4): {

            }
            case (5): {

            }
            case (6): {

            }
            case (7): {

            }
        }
    }

        int SECOND_OPTION = scan.nextInt();
        if(FIRST_OPTION == 2){
            switch (SECOND_OPTION){
                case(1): {
                    break;
                }
                case(2): {

                }
                case(3): {

                }
                case(4): {

                }
                case(5): {

                }
                case(6): {

                }
                case(7): {

                }

            }
        }

*/


    }
}
