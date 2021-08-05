/**
 * 4. 寻找两个正序数组的中位数
 *      给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数
 */
public class LC0004 {
    /*public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        boolean flag = length%2 == 1 ? true : false;    //true为奇数，false为偶数

        int mid = length/2;
        int i1=0,i2=0;
        if (flag){
            for (int i = 0;i<mid;i++){
                if (nums1[i1] > nums2[i2]) {
                    i1++;
                } else {
                    i2++;
                }
            }
        }

    }*/

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        boolean flag = length%2 ==1 ? true :false;
        int[] num = new int[length];

        int i1 = 0,i2 = 0,i0 = 0;
        while (i1<nums1.length && i2<nums2.length){
            int temp;
            if (nums1[i1]<nums2[i2]){
                temp = nums1[i1++];
            }else {
                temp = nums2[i2++];
            }
            num[i0++] = temp;
        }

        if (i1==nums1.length){
            while (i2<nums2.length) {
                num[i0++] = nums2[i2++];
            }
        }else {
            while (i1<nums1.length){
                num[i0++] = nums1[i1++];
            }
        }

        double result ;
        if (flag){
            result = num[length/2];
        }else {
            result = (double) (num[length/2] + num[length/2-1])/2;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = {1,3},num2={2,3};
        double medianSortedArrays = findMedianSortedArrays(num1, num2);
        System.out.println(medianSortedArrays);
    }
}















