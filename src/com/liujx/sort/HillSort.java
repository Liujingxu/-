package com.liujx.sort;

import java.util.Arrays;
import java.util.Random;

public class HillSort implements Sort{
    @Override
    public int[] sort(int[] array) {
        return sortByMove(array);
    }

    public int[] sortByChange(int[] array){
        int temp = 0;
        for (int gap = array.length / 2; gap > 0; gap /= 2){
            for (int i = gap; i < array.length; i++){
                for (int j = i - gap; j >= 0; j -= gap){
                    if (array[j] > array[j + gap]){
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
        }

        return array;
    }

    public int[] sortByMove(int[] array){

        for (int gap = array.length / 2; gap > 0; gap /= 2){
            for (int i = gap; i < array.length; i++){
                int index = i - gap;
                int value = array[i];
                while (index >= 0 && array[index] > value){
                    array[index + gap] = array[index];
                    index -= gap;
                }

                array[index + gap] = value;
            }

        }

        return array;
    }

    public static void main(String[] args) {
        HillSort hillsort = new HillSort();
//        int[] array = new int[]{6, 5, 4, 3, 2, 1};
        Random random = new Random(256);
        int[] array = random.ints(80000).toArray();
        long start = System.currentTimeMillis();
        int[] sort = hillsort.sort(array);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(sort));
        System.out.println(end - start);
    }
}
