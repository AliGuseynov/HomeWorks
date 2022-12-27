package org.example.logger;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.exceptions.UserException;

import java.util.Scanner;

public class LoggerClass {
    //Suali tutmadim muellimin sinifde verdiyi task`in loglanmis versiyasin yazdim
    private static Logger logger = LogManager.getLogger(LoggerClass.class);
    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Name  :"); String userName = scanner.nextLine();
            if (userName.equals("dayan")){
                System.out.println("Process finished");
                break;
            }
            else {
                try {
                    UserChecker.createUser(userName);
                } catch (UserException e) {
                    logger.error("Error occured dureing call main", e);
                } finally {
                    System.out.println(UserChecker.userSet);
                }
            }
        }
    }
}
