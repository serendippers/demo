package com.company.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
class LeetCodeTest {

    @Test
    void longestPalindrome() {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String result = longestPalindrome.longestPalindrome("bb");
        System.out.println(result);
    }

    @Test
    void reverse() {
        IntegerReverse integerReverse = new IntegerReverse();
        int res = integerReverse.reverse(-123);
        System.out.println(res);
    }

    @Test
    void myAtoi() {
        StringToInt stringToInt = new StringToInt();
        int res = stringToInt.myAtoi("                -2147483649");
        System.out.println(res);
    }

    @Test
    void MaxArea() {
        int[] input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        MaxArea maxArea = new MaxArea();

        System.out.println(maxArea.maxArea(input));

    }

    @Test
    void intToRoman() {
        IntToRoman intToRoman = new IntToRoman();
        String res = intToRoman.intToRoman(27);
        String res2 = intToRoman.intToRoman2(27);
        System.out.println(res);
        System.out.println(res2);

    }


    @Test
    void ThreeSum() {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum.threeSum(nums));
    }

    @Test
    void stockTransaction() {
        StockTransaction test = new StockTransaction();
        int maxProfit = test.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(maxProfit);
    }
}