package com.company.Lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class flatMapDemo {

    public static void main(String[] args) {
        String[] words = new String[]{"Hello", "world"};
        List<String> list = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list);

        List<Integer> list12 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list1 = list12.stream()
                .map(integer -> integer * integer)
                .collect(Collectors.toList());
        System.out.println(list1);


        List<Integer> list2 = Arrays.asList(1, 2, 3);
        List<Integer> list3 = Arrays.asList(3, 4);
        list2.stream()
                .forEach(i-> list3.stream().forEach(j->System.out.println(i +"," + j)));

        List<int[]> list4 = list2.stream()
                .flatMap(i-> list3.stream().filter(j-> (i+j)%3==0).map(j->new int[]{i,j}))
                .collect(Collectors.toList());
        list4.forEach(ints -> System.out.println(Arrays.toString(ints)));

        Optional<Integer> first = list12.stream()
                .map(i -> i * i)
                .filter(i -> i % 3 == 0)
                .findFirst();
        System.out.println(first);

        int temp = list12.stream().reduce(0, (a, b) -> a + b);
        System.out.println(temp);
        temp = list12.stream().reduce(0, Integer::sum);
        System.out.println(temp);
        temp = list12.stream().reduce(0, Integer::max);
        System.out.println(temp);

    }

}
