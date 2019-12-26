package com.company.Lambda.execute_around;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class Process {

    public String processFile(BufferedReaderProcessor processor) throws FileNotFoundException,IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("file/lambda/test.txt"))) {
            return processor.process(br);
        }
    }
}
