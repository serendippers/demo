package com.company.Lambda.method_reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MethodReference {

    public static void main(String[] args) {
	// write your code here
        List<String> list = Arrays.asList("a", "b", "A", "B");
        list.sort((s1, s2) -> s2.compareToIgnoreCase(s1));
        System.out.println(list);
        list.sort(String::compareToIgnoreCase);
        System.out.println(list);
    }
}
