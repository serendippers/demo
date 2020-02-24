package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class IntToRoman {

    public String intToRoman(int num) {
        if (num == 0) {
            return "";
        }

        StringBuilder res = new StringBuilder();

        Map<Integer, String> map = new HashMap<>(4, 1);
        String str = null;

        //记录各位上的数字
        int temp = 0;

        //处理千位数
        if ((temp = num / 1000) != 0) {
            num = num % 1000;
            while (temp-- > 0) {
                res.append("M");
            }
        }

        //处理百分位
        if ((temp = num / 100) != 0) {
            num = num % 100;
            map.put(1, "C");
            map.put(5, "D");
            map.put(4, "CD");
            map.put(9, "CM");
            if ((str = map.get(temp)) == null) {
                if (temp > 5) {
                    temp = temp - 5;
                    res.append(map.get(5));
                }
                while (temp-- > 0) {
                    res.append(map.get(1));
                }
            } else {
                res.append(str);
            }
        }

        //处理十分位
        if ((temp = num / 10) != 0) {
            num = num % 10;
            map.put(1, "X");
            map.put(5, "L");
            map.put(4, "XL");
            map.put(9, "XC");
            if ((str = map.get(temp)) == null) {
                if (temp > 5) {
                    temp = temp - 5;
                    res.append(map.get(5));
                }
                while (temp-- > 0) {
                    res.append(map.get(1));
                }
            } else {
                res.append(str);
            }
        }


        //处理个位数
        if ((temp = num) != 0) {
            map.put(1, "I");
            map.put(4, "IV");
            map.put(5, "V");
            map.put(9, "IX");
            if ((str = map.get(temp)) == null) {
                if (temp > 5) {
                    temp = temp - 5;
                    res.append(map.get(5));
                }
                while (temp-- > 0) {
                    res.append(map.get(1));
                }
            } else {
                res.append(str);
            }
        }
        return res.toString();
    }


    public String intToRoman2(int num) {
        if (num == 0) {
            return "";
        }

        StringBuilder res = new StringBuilder();

        Map<Integer, String> map = new HashMap<>(4, 1);

        int temp = 0;
        int i = 0;
        while (num > 0) {
            temp = num % 10;
            num = num / 10;

            if (temp > 0) {
                if (i == 0) {
                    map.put(1, "I");
                    map.put(4, "IV");
                    map.put(5, "V");
                    map.put(9, "IX");
                } else if (i == 1) {
                    map.put(1, "X");
                    map.put(5, "L");
                    map.put(4, "XL");
                    map.put(9, "XC");
                } else if (i == 2) {
                    map.put(1, "C");
                    map.put(5, "D");
                    map.put(4, "CD");
                    map.put(9, "CM");
                } else {
                    map.put(1, "M");
                }
                if ( map.get(temp) == null) {
                    if (temp > 5) {
                        temp = temp - 5;
                        res.insert(0, map.get(5));
                        while (temp-- > 0) {
                            res.insert(1, map.get(1));
                        }
                    } else {
                        while (temp-- > 0) {
                            res.insert(0, map.get(1));
                        }
                    }
                } else {
                    res.insert(0, map.get(temp));
                }
            }
            i++;
        }
        return res.toString();
    }
}
