package com.company.leetcode.huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Souhu {


    public static void main(String[] args) {
        Integer[] nums = {2,1,58,4,2,36,6,5,4,85,6,2,5,4,6};

        Set<Integer> treeSet = new TreeSet<Integer>();
        treeSet.addAll(Arrays.asList(nums));

        Integer[] sortedArray = treeSet.toArray(new Integer[]{});

        System.out.println(Arrays.toString(sortedArray));
    }


}
