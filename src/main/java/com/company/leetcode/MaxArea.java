package com.company.leetcode;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 *示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class MaxArea {

    public int maxArea(int[] height) {

        //左指针
        int l = 0;

        //右指针
        int r = height.length - 1;

        int res = 0;

        while (l != r) {
            res = Math.max(res, (r - l) * (height[l] > height[r] ? height[r--] : height[l++]));
        }
        return res;
    }
}
