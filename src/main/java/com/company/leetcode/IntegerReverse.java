package com.company.leetcode;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class IntegerReverse {

    public int reverse(int x) {

        int res = 0;
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        while (x != 0) {
            x = x / 10;
            if (res > max ) return 0;
            if (res < min ) return 0;
            res = res * 10 + x % 10;;
        }
        return res;
    }
}
