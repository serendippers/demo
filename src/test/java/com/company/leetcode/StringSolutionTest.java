package com.company.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
class StringSolutionTest {

    @Test
    void lengthOfLongestSubstring() {
        String s = "tmmzuxt";
        StringSolution solution = new StringSolution();
        int size = solution.lengthOfLongestSubstring(s);
        System.out.println(size);
    }

    @Test
    void lengthOfLongestSubstring2() {
        String s = "dvdf";
        StringSolution solution = new StringSolution();
        int size = solution.lengthOfLongestSubstring(s);
        System.out.println(size);
    }
}