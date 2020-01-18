package com.company.leetcode;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        int l = 0;
        int r = 0;
        int lenght = 0;
        int maxL = 0;
        int maxR = 0;
        for (int i = 1; i < s.length(); i++) {
            l = i - 1;
            //处理bb类型回文
            if (s.charAt(l) == s.charAt(r = i)) {
                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }
                if (r - l - 1 > lenght) {
                    maxL = l + 1;
                    maxR = r - 1;
                    lenght = r - l - 1;
                }
                l = i - 1;
            }
            //处理aba类型回文
            if ((r = i + 1) < s.length() && s.charAt(l) == s.charAt(r)) {
                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }
                if (r - l - 1 > lenght) {
                    maxL = l + 1;
                    maxR = r - 1;
                    lenght = r - l - 1;
                }
            }
        }
        return s.substring(maxL, maxR + 1);
    }
}
