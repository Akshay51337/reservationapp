package com.reservationapp;

import java.util.*;

public class FindPairsWithSum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int targetSum = 7;

        findPairsWithSum(array, targetSum);
    }

    public static void findPairsWithSum(int[] array, int targetSum) {
        Set<Integer> set = new HashSet<>();

        for (int num : array) {
            int complement = targetSum - num;
            if (set.contains(complement)) {
                System.out.println("Pair found: (" + num + ", " + complement + ")");
            }
            set.add(num);
        }
    }
}

