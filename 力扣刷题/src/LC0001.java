import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. 两数之和
 */
public class LC0001 {
    public static void main(String[] args) {
        int[] num = {7,2,11,15};
        int[] ints = twoSum(num, 9);
        System.out.println(String.valueOf(ints));
    }
    public static int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> hashmap = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            if (hashmap.containsKey(target-nums[i])){
                list.add(hashmap.get(target-nums[i]));
                list.add(i);
                hashmap.remove(target-nums[i]);
            }else
                hashmap.put(nums[i],i);
        }
        int[] arr = new int[list.size()];
        for (int i = 0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }//通过
}
