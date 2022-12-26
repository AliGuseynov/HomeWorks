package MergerSort;

/*
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 */
public class Merge {
    public static void main(String[] args) {
        int [] nums1={1,2,3,0,0,0};
        int m=3;
        int [] nums2={2,5,6};
        int n=3;
        int p1=m-1;
        int p2=n-1;
        int i=m+n-1;
        while(p2>=0){
            if(p1>=0 && nums1[p1]>nums2[p2]){
                nums1[i--]=nums1[p1--];

            }else{
                nums1[i--]=nums2[p2--];
            }
        }
        for(int k=0;k<nums1.length;k++){
            System.out.print(nums1[k]+" ");
        }
    }

}
