package Homework2;

public class Task5 {
    public static void main(String[] args) {
        int arr[]= {10,23,2,45,7};
        int max=arr[0];
        for (int i=0;i<arr.length;i++){
          if(arr[i]>max){
              max=arr[i];
          }
        }
        System.out.println(max);
    }
}
