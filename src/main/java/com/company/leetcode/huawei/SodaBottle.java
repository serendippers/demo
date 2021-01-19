package com.company.leetcode.huawei;

import java.util.Scanner;

public class SodaBottle {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            num = sc.nextInt();
            if (num== 0) break;
            System.out.println(exchangeSoda(num));
        }
    }

    static int exchangeSoda(int num) {

        return num / 2;
    }
}
