package com.company.Lambda.execute_around;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

    String process(BufferedReader bufferedReader) throws IOException;
}
