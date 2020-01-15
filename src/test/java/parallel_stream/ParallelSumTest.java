package parallel_stream;

import com.company.Lambda.parallel_stream.ParallelSum;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class ParallelSumTest {

    @Test
    public void sequentialSum() {
        ParallelSum parallelSum = new ParallelSum();
        System.out.println("Sequential sum done in:" + parallelSum.measureSumPerf(parallelSum::sequentialSum, 10_000_000) + " msecs");
    }

    @Test
    public void sequentialRangedSum() {
        ParallelSum parallelSum = new ParallelSum();
        System.out.println("sequentialRangedSum sum done in:" + parallelSum.measureSumPerf(parallelSum::sequentialRangedSum, 10_000_000) + " msecs");
    }

    @Test
    public void parallelSum() {
        ParallelSum parallelSum = new ParallelSum();
        System.out.println("parallel sum done in:" + parallelSum.measureSumPerf(parallelSum::parallelSum, 10_000_000) + " msecs");
    }

    @Test
    public void parallelRangedSum() {
        ParallelSum parallelSum = new ParallelSum();
        System.out.println("parallelRangedSum sum done in:" + parallelSum.measureSumPerf(parallelSum::parallelRangedSum, 10_000_000) + " msecs");
    }
}
