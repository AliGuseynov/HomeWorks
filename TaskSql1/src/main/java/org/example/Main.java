package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Tasks Of Sql1");

        //Task1(Navicat de student table yaratdim asagidaki columnlari var)
        /*
         INSERT into student (ID,NAME,SURNAME,AGE)
         VALUES (1,'Nezrin','Suleymanli',19)
         */
        //Task2
        /*
        SELECT DISTINCT city FROM station WHERE city RLIKE '[^aeiouAEIOU]$';
        */

        //Task3
        /*
        select firstName, lastName,Address.city,Address.state
        from Person left join Address on Person.personId=Address.personId
        */

        //Task4
        /*
        select a.name as 'Employee' from Employee as a,Employee as b
        where a.managerId=b.id and a.salary>b.salary
        */
    }
}