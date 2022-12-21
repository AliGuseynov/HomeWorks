import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Task {
    public static void task2(){
        int [] nums = {1,2,3,1,1,3};
        int count=0;

        HashMap<Integer,Integer> hashMap=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length ;i++){
            hashMap.put(i,nums[i]);

        }
        for(int i=0;i<nums[i];i++){
            if(hashMap.containsValue(nums[i])){
                count++;
            }

        }

        System.out.println(count);
    }
    public static int task2(int[] nums)
    {
        int res = 0;
        Map<Integer,Integer> count= new HashMap<Integer,Integer>();
        for (int a: nums)
        {
            int cur=count.getOrDefault(a,0);
            res += cur;
            count.put(a,cur+1);
        }
        return res;
    }
    public static int task3(String jewels, String stones) {
        HashSet<Character> jewelSet = new HashSet<Character>();
        for(int i=0;i<jewels.length();i++)
            jewelSet.add(jewels.charAt(i));

        int answer = 0;
        for(int i=0;i<stones.length();i++){
            if(jewelSet.contains(stones.charAt(i)) == true)
                answer++;
        }
        return answer;
    }
}
