package com.company.leetcode;

public class ClimbStairs {

    public int climbStairs(int n) {
        int dpPre = 1;//n= 1时一种可能
        int dpN = 2;

        if (n == 1) return dpPre;
        if (n == 2) return dpN;


        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = dpPre + dpN;
            dpPre = dpN;
            dpN = res;
        }
        return res;
    }
}
