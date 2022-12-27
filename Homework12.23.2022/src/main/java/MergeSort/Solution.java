package MergeSort;

import java.util.Arrays;

public class Solution {
    public static void mergeArrays(int[] arr1, int[] arr2, int n1, int n2, int[] arr3){
        int i = 0;
        int j = 0;
        int k = 0;

        // traverse the arr1 and insert its element in arr3
        while(i < n1){
            arr3[k++] = arr1[i++];
        }

        // now traverse arr2 and insert in arr3
        while(j < n2){
            arr3[k++] = arr2[j++];
        }

        // sort the whole array arr3
        Arrays.sort(arr3);
    }
}
