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
}