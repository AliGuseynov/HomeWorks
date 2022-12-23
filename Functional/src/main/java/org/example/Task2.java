package org.example;

import java.util.*;

/*
Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 */
public class Task2 {
    public static void main(String[] args) {
        int [] arr={1,2,3,1,1,3};
        System.out.println(way2(arr));
    }

    public static int way2(int[] nums) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int count=0;
        for (int i=0;i<nums.length;i++){
            if (hashMap.containsKey(nums[i])){
                int temp = hashMap.get(nums[i])+1;
                count=count+temp;
                hashMap.put(nums[i],temp);
            }else {
                hashMap.put(i,0);
            }
        }
        return count;

    }
    public static void way1() {
        List<Integer> list=new ArrayList<>();
        Map<Integer,Integer> mymap=new HashMap<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(1);
        list.add(3);
        int count=0;
        for (int i=0;i<list.size();i++){
            mymap.put(i,list.get(i));
            for (int k=i+1;k<list.size();k++){
                if (list.get(i)==list.get(k)){
                    System.out.println("["+i+","+k+"]");
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}