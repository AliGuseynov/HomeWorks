import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(highDefineAge());
    }
    public static void printAge(String name,String surname){
        Stream.of(1,2,3,4,5,6,7,8,11,12,23,34,12,14).map(a->new Person(a,name+a,surname+a,(a+18)))
                .filter(p->p.getAge().compareTo(String.valueOf(18))>0)
                .forEach(System.out::println);
    }
    public static long printMiddleAge(){
       long sum=Stream.of(1,2,3,4,5,6,7,8,11,12,23,34,12,14).
                map(a->new Person(a,"name"+a,"surname"+a,(a+18))).
                reduce(0,(a,b)->a+Integer.parseInt(b.getAge()),Integer::sum);
       return sum/Stream.of(1,2,3,4,5,6,7,8,11,12,23,34,12,14).count();

    }
    public static long highDefineAge(){
       int ageSum= Stream.of(1,2,3,4,5,6,7,8,11,12,23,34,12,14).
                map(a->new Person(a,"name"+a,"surname"+a,(a+18))).filter(p->Integer.parseInt(p.getAge())>18).
                reduce(0,(a,b)->a+Integer.parseInt(b.getAge()),Integer::sum);
        return ageSum;
    }

}