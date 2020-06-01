package com.liujx.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class InsertSort implements Sort {
    @Override
    public int[] sort(int[] array) {


        for (int i = 1; i < array.length; i++){
            int index = i - 1;
            int value = array[i];
            while (index >= 0 && array[index] > value){
                array[index + 1] = array[index];
                index--;
            }

            array[index + 1] = value;

        }

        return array;
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
//        int[] arr = new int[]{6, 5, 4, 2, 3, 1};
        Random random = new Random();
        int[] array = random.ints(80000).toArray();
        System.out.println(Arrays.toString(array));
        int[] sort = insertSort.sort(array);
        System.out.println(Arrays.toString(sort));

    }
}
