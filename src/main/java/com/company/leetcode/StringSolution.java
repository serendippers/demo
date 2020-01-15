package com.company.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */

public class StringSolution {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int size = 0;
        if (null == s || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        while (left < s.length()) {
            if (map.containsKey(s.charAt(left))) {
                map.remove(s.charAt(right++));
            } else {
                map.put(s.charAt(left), left);
                left++;
                size = Math.max(size, left - right);
            }
        }
        return size;
    }

}
