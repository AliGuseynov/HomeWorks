package homework23_12;

public class Merge {

    //Method 2 backwards
    public static int [] merge(int[] nums1, int m, int[] nums2, int n) {

        int m0 = m-1;
        int n0 = n-1;

        for (int i = m+n-1; i>=0; i--){

            if ((m0>-1 && n0> -1)){
                if (nums1[m0] > nums2[n0]){
                    nums1[i] = nums1[m0--];
                } else {
                    nums1[i] = nums2[n0--];
                }
            } else if (m0>-1){
                nums1[i] = nums1[m0--];
            } else {
                nums1[i] = nums2[n0--];
            }


        }


        return nums1;
    }



// Method 1 Brute force

    /*
    public static int [] merge(int[] nums1, int m, int[] nums2, int n) {

        int size = m + n;
        int[] out = new int[size];
        int m0 = m;
        int n0 = n;
        m = 0;
        n = 0;
        int temp = -1;


        int i = 0;
        boolean search = true;
        while (search) {

            if (m>=m0 && n<n0){
                out[i] = nums2[n];
                i++;
                n++;
                search = checkWhile(size, i);
            }
            else if (n>=n0 && m<m0){
                out[i] = nums1[m];
                i++;
                m++;
                search = checkWhile(size, i);

            }
            else {

                System.out.println("else");

                if (nums1[m] <= nums2[n]) {
                    out[i] = nums1[m];
                    m++;
                    i++;
                    search = checkWhile(size, i);
                } else {
                    out[i] = nums2[n];
                    n++;
                    i++;
                    search = checkWhile(size, i);
                }
            }

        }

        nums1 = out;
        return nums1;
    }
    private static boolean checkWhile(int length, int num){
        if (length>num){
            return true;
        } else {
            return false;
        }
    }
*/

}