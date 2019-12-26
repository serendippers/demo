package com.company.Lambda.stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author zhangpengpeng
 */
public class StreamMain {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .distinct()//去重复
                .forEach(System.out::println);
        System.out.println("--------------skip-------");
        menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .skip(2)
                .limit(2)
                .distinct()//去重复
                .forEach((dish)->{System.out.println(dish.getName());});


        int totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(totalCalories);
        totalCalories = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        System.out.println(totalCalories);
        totalCalories = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(totalCalories);

        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> dish = menu.stream()
                .collect(maxBy(dishComparator));


        totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories);
        double avg = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(avg);
        OptionalDouble average = menu.stream().mapToInt(Dish::getCalories).average();
        System.out.println(average);
        BinaryOperator

    }

/*    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        Integer temp = null;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (temp = map.get(nums[i])) != i) {
                return new int[]{temp,i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }*/


}
