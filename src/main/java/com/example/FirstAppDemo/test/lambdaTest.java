package com.example.FirstAppDemo.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class lambdaTest {

    /**
     * 例1：替换掉匿名类
     */
    @Test
    public void example1(){
        // Java 8之前：
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();

        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
    }

    @Test
    public void example2(){
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));

        features.forEach(System.out::println);
    }

    @Test
    public void example3(){

        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp","JJ");
        filter(languages, (str)->str.toString().startsWith("J"));
    }

    public void filter(List<String> names, Predicate condition) {
        for(String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    public void filter2(List<String> names,Predicate condition){
        names.stream().filter((name)->(condition.test(name))).forEach((name) -> {
            System.out.println(name + " ");
        });
    }
}
