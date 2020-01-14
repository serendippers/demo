package com.company.Lambda.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class PrimeMain {

    public static void main(String[] args) {
        Map<Boolean, List<Integer>> primeMap = IntStream.rangeClosed(2, 200).boxed().collect(new PrimeNumbersCollector());
        System.out.println(primeMap);
    }

    static boolean isPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes, integer -> integer <= candidateRoot).stream().noneMatch(integer -> candidate % integer == 0);
    }

    static <A> List<A> takeWhile(List<A> primes, Predicate<A> p) {
        int i = 0;
        for (A item : primes) {
            if (!p.test(item)) {
                return primes.subList(0, i);
            }
            i++;
        }
        return primes;
    }
}
