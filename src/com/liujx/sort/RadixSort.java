package com.liujx.sort;

import java.util.Arrays;
import java.util.Random;

public class RadixSort {

    public int[] radixSort(int[] array){
        int length = array.length;

        int max = Integer.MIN_VALUE;

        for (int a : array){
            if (max < a){
                max = a;
            }
        }

        int size = (max + "").length();

        int[][] bucket = new int[10][length];
        int[] buckSize = new int[10];

        for (int k = 0; k < size; k++) {
            for (int a : array){
                int tmp = (int) (a / Math.pow(10, k));
                int result = tmp % 10;
                bucket[result][buckSize[result]++] = a;
            }

            int index = 0;
            for (int i = 0; i < bucket.length; i++){
                for (int j = 0; j < buckSize[i]; j++){
                    array[index++] = bucket[i][j];
                }
            }

            for (int i = 0 ; i < buckSize.length;i++){
                buckSize[i] = 0;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] arr = new int[]{7, 6, 5, 2, 3, 1, 4};
//        int[] sort = radixSort.radixSort(arr);
//        System.out.println(Arrays.toString(sort));
        Random random = new Random(256);
        int[] array = random.ints(0, 8000000).limit(8000000).toArray();
        int[] sort1 = radixSort.radixSort(array);
        System.out.println(Arrays.toString(sort1));
    }
}
