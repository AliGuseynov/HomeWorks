package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
      int sum=  List.of(1,2,3,4,5,6,7,8,9,10)
              .stream()
              .map(a->new Person(a,"name"+a,"surname"+a,a+10))
                .collect(Collectors.toList())
                .stream().filter(a->a.getAge()>18)
                .reduce(0,(a,b)->a+b.getAge(),Integer::sum)
              ;
        System.out.println(sum);
//------------------------------------------------------------------------------------------------
        int avarage=  List.of(1,2,3,4,5,6,7,8,9,10)
                .stream()
                .map(a->new Person(a,"name"+a,"surname"+a,a+10))
                .collect(Collectors.toList()).stream()
                .reduce(0,(a,b)->a+b.getAge(),Integer::sum);
        System.out.println(avarage);
    }
}