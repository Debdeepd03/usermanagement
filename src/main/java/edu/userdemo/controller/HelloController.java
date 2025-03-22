package edu.userdemo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.BiFunction;
import java.util.function.Function;

@RestController
public class HelloController {

    @GetMapping
    public String demo(){
        return "Hello World from SPringboot java version"+System.getProperty("java.version");
    }
    @GetMapping("/add/{a}")
    public String addNum(@PathVariable Integer a,@RequestParam Integer b){
        BiFunction<Integer,Integer,Integer>x=(a1,b1)->a1+b1;
        return "the sum is: "+x.apply(a,b);

    }
    @GetMapping("/add2/{a}")
    public String evenOdd(@PathVariable Integer a){
        Function<Integer,String> f=x->x%2==0?"even":"odd";
        return f.apply(a);
        }

    }

