package com.company.Lambda.execute_around;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

class  ExecuteAroundMain{

    public static void main(String[] args) throws IOException {
	// write your code here
        String output = new Process().processFile((BufferedReader b) -> b.readLine());

        System.out.println(output);

        System.out.println(Double.valueOf(".71"));
    }


}
