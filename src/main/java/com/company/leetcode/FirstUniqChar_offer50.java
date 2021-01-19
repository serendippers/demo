package com.company.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar_offer50 {

    public char firstUniqChar(String s) {
        if (s == null || s.isEmpty()) {
            return ' ';
        }
        Map<Character, Boolean> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), !map.containsKey(s.charAt(i)));
        }

        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) return entry.getKey();
        }

        return ' ';
    }
}
