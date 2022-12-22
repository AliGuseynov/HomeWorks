package com.company;

import java.util.Scanner;

public class Main {

    public static int numOfIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter arr size: ");
        int size = scan.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter arr elements: ");
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = scan.nextInt();
        }
        System.out.println("Number of identical pairs: " + numOfIdenticalPairs(arr));
    }
}
