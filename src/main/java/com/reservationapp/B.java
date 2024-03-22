package com.reservationapp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class B {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 15, 14, 23, 25);
        List<Integer> collect = list.stream().sorted(Comparator.reverseOrder()).skip(1).limit(1).collect(Collectors.toList());
        System.out.println(collect);
    }
}
