import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三树之和
 *      给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 *   解法： 1、将数组排序
 *          2、将第一个元素限定住，把题目转换成两数之和，
 *          3、使用双指针进行求解。
 */
public class LC0008 {
    public static void main(String[] args) {
        //int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {-2,0,1,1,2};
        List<List<Integer>> list = threeSum(nums);
        System.out.println(list.toString());
    }
    public static List<List<Integer>> threeSum(int[] nums) {
     List<List<Integer>> list = new ArrayList<>();
     if (nums ==null || nums.length < 3) return list;

     Arrays.sort(nums);

     for (int i = 0;i<nums.length-2 && nums[i]<=0 ;i++){
        if (i>0 && nums[i] == nums[i-1]) continue;
        int left = i+1,right = nums.length-1,target = -nums[i];
        while (left<right){
            if (target == nums[left] + nums[right]){
                list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                left++;right--;
                while (left<right && nums[left] == nums[left-1]) left++;
                while (left<right && nums[right] == nums[right+1] ) right--;
            }else if (target < nums[left] + nums[right])
                right --;
            else
                left++;
        }
     }
     return list;
    }

}

/*
class Solution {    //LeetCode中较好的解法解析
    public List<List<Integer>> threeSum(int[] nums) {// 总时间复杂度：O(n^2)
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;

        Arrays.sort(nums); // O(nlogn)  //数组排序

        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)       //将第一个数限定住
            if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了   //过滤
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int target = -nums[i];          //将三数之和转换为两数之和
            int left = i + 1, right = nums.length - 1;      //双指针
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++; right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }
}
*/
