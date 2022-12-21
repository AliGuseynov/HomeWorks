package leetcode;

import java.util.HashMap;

public class Functions {


    public static int countGoodPairs(int[] nums){
        int pairs = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (hashMap.containsKey(nums[i])){

                int tempint = hashMap.get(nums[i])+1;

                pairs = pairs+tempint;
                hashMap.put(nums[i], tempint);

            } else {
                hashMap.put(nums[i], 0);
            }
        }
        return pairs;
    }

    public static int jewelsAndStones(String jewels, String stones){
        String regex = "[^" + jewels + "]";
        String[] tempStones = stones.split(regex);

        int counter = 0;
        for (String str: tempStones){

            counter = counter + str.length();
        }

        return counter;
    }
}
