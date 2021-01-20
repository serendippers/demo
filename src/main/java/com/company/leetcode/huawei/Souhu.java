package com.company.leetcode.huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Souhu {

    ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

    public static void main(String[] args) {
        Integer[] nums = {2,1,58,4,2,36,6,5,4,85,6,2,5,4,6};

        Set<Integer> treeSet = new TreeSet<Integer>();
        treeSet.addAll(Arrays.asList(nums));

        Integer[] sortedArray = treeSet.toArray(new Integer[]{});

        System.out.println(Arrays.toString(sortedArray));


    }

    public void config() {
        executor.prestartCoreThread();
        executor.prestartAllCoreThreads();
    }
}
