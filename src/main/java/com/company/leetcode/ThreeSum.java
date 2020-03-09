package com.company.leetcode;

import java.util.*;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) return list;
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) return list;

        int right = 0;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > 0) break;
            if(i>0 && nums[i] == nums[i-1]) continue;

            left = i + 1;
            right = nums.length - 1;

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left<right && nums[left] == nums[left+1]) left++; // 去重
                    while (left<right && nums[right] == nums[right-1]) right--; // 去重
                    left++;
                    right--;
                }
                else if(sum>0) right--;
                else if(sum<0) left++;
            }
        }
        return list;
    }
}
