package com.company.Lambda.stream;

import java.util.IntSummaryStatistics;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class gouGuNumber {

    public static void main(String[] args) {
        int test = 3;
        Stream<int[]> arr = IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(test * test + b * b) % 1 == 0)
                .boxed()
                .map(b -> new int[]{test, b, (int) Math.sqrt(test * test + b * b)});
        System.out.println(arr);
        arr.limit(10).forEach(t-> System.out.println(t[1]+ "," + t[2]));
        arr = IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(test * test + b * b) % 1 == 0)
                .mapToObj(b -> new int[]{test, b, (int) Math.sqrt(test * test + b * b)});
        System.out.println(arr);
        arr.limit(10).forEach(t-> System.out.println(t[1]+ "," + t[2] ));


        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                        .mapToObj(b ->
                                                new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                        );
        pythagoreanTriples.limit(5)
                .forEach(t ->
                        System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        IntSupplier supplier = new IntSupplier() {
            private int a = 0;
            private int b = 1;
            @Override
            public int getAsInt() {
                int t = a;
                int n = b + t;
                a = b;
                b = n;
                return b;
            }
        };
        IntStream.generate(supplier).limit(10).forEach(System.out::println);
    }

}
