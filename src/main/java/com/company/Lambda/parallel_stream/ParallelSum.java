package com.company.Lambda.parallel_stream;

import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class ParallelSum {

    public static void main(String[] args) {
    }

    public long parallelSum(Long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public long parallelRangedSum(Long n) {
        return LongStream.rangeClosed(0, n)
                .parallel()
                .reduce(0, Long::sum);
    }

    public long sequentialSum(Long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public long sequentialRangedSum(Long n) {
        return LongStream.rangeClosed(0, n)
                .reduce(0, Long::sum);
    }

    public long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

}
