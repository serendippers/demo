package com.company.leetcode;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*int n1 = 0;
        int n2 = 0;
        int t = 0;
        int t2 = 0;
        int index = (nums1.length + nums2.length) / 2;
        for (int i = 0; i <= index; i++) {
            t = t2;
            if (n1 < nums1.length && (nums1[n1] <= nums2[n2]) ) {
                t2 = nums1[n1];
                n1++;

            } else if(n2<nums2.length) {
                t2 = nums2[n2];
                n2++;
            }
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (t + t2) / 2.0;
        }
        return t2;
    }*/
        return 0;
    }
}
