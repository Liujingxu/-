package com.liujx.sort;

import java.util.Arrays;
import java.util.Random;

public class SelectSort implements Sort {
    @Override
    public int[] sort(int[] array) {

        int min = 0;
        int value = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++){
            min = i;
            value = array[i];
            for (int j = i + 1; j < array.length; j++){
                if (value > array[j]){
                    min = j;
                    value = array[j];
                }
            }

            if (min != i){
                array[min] = array[i];
                array[i] = value;
            }
        }
        return array;
    }

    public static void main(String[] args) {
//        int[] array = new int[]{6,5,4,3,2,1};
        SelectSort selectSort = new SelectSort();
        Random random = new Random(256);
        int[] array = random.ints(80000).toArray();
        long start = System.currentTimeMillis();
        System.out.println("start " + start);
        int[] sort = selectSort.sort(array);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(sort));
        System.out.println("end " + end);
        System.out.println((end - start) / 1000);

    }
}
