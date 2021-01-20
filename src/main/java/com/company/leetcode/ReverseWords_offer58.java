package com.company.leetcode;

public class ReverseWords_offer58 {


    public String reverseWords(String s) throws  Exception {

        if(s == null || s.isEmpty()) return "";
        String str = s.trim();
        StringBuilder res = new StringBuilder();
        int l = str.length()-1;
        int r = l;
        int index = l;
        while (r >=0) {
            if (l>=0 && str.charAt(l) != ' ') {
                l--;
            }else {
                res.append(str.substring(l + 1, r + 1));
                if ( l >=0 ) res.append(" ");
                while (l>0 && str.charAt(l) == ' ') {
                    l--;
                }
                r = l;
            }
        }
        return res.toString();
    }
}
