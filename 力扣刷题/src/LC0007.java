/**
 * LC11.盛最多水的容器
 *      双指针
 *    决定容器中水的高度的是容器最外两侧中短板的一侧，容量为短板的高度*容器左右两边之间的间隙。
 *    对短板一侧进行移动，继续求容量，以此类推
 */
public class LC0007 {
    public int maxArea(int[] height) {
        int left = 0,right = height.length-1,ans,max = 0;
        while (left<right){
            ans = Math.min(height[left],height[right]) * (right-left);
            max = Math.max(max, ans);
            if (height[left]<height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}
