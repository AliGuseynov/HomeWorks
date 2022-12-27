package MergeSort;

public class Main {

    public static void main(String[] args) {
        Solution obj = new Solution();
        int arr1[] = {1, 3, 5, 7, 0};
        int n1 = arr1.length;

        int arr2[] = {2, 4, 6, 8};
        int n2 = arr2.length;

        int arr3[] = new int[n1 + n2];
        obj.mergeArrays(arr1, arr2, n1, n2, arr3);

        System.out.println("Array after merging");
        for (int i=0; i < n1+n2; i++)
        {
            if(arr3[i] != 0)
            System.out.print(arr3[i] + " ");
        }
    }
}
