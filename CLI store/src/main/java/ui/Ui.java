package ui;

import models.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class Ui {

    public static void startCLI(){

        System.out.println("========== Welcome to store app");
        System.out.println("\n1 - Show all items" +
                "\n2 - Add sale" +
                "\n3 - Show all receipts");
        Scanner scanner = new Scanner(System.in);
        Integer input = 0;
        Boolean whilebreaker = true;
        while (true){

            System.out.print("Enter Option :");
            try {
                input  = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){

            }


        if (input == 1 || input == 2 || input == 3) {
                break;
            } else {
                System.out.println("Wrong option...\n");
            }
        }

        switch (input){
            case 1:
                selectAllItems();
                startCLI();
                break;
            case 2:
                break;
            case 3:
                break;
        }

        }

        private static void selectAllItems(){

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.Store");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();


//            Product pr = Product.builder().product_name("Test thing").product_price(24.6).product_category("thing").build();

//            em.merge(pr);

            List<Product> products = em.createNamedQuery("all_products").getResultList();

            products.forEach(System.out::println);

//            em.getTransaction().commit();


            em.close();
        }


    }

