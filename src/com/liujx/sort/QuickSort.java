package com.liujx.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        return qSort(array, 0, array.length - 1);
    }

    public int[] qSort(int[] array, int left, int right){
        int mid = array[(left + right) / 2];
        int l = left;
        int r = right;
        while (l < r) {
            while (array[l] < mid){
                l++;
            }

            while (array[r] > mid){
                r--;
            }

            if (l >= r){
                break;
            }
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            if (array[l] == mid){
                r--;
            }
            if (array[r] == mid){
                l++;
            }



        }

        if (l == r){
            l++;
            r--;
        }

        if (left < r){
            qSort(array, left, r);
        }
        if (right > l){
            qSort(array, l, right);
        }


        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{6, 5, 3, 2, 8, 1};
//        Random random = new Random(256);
//        int[] array = random.ints(10).toArray();
        QuickSort quickSort = new QuickSort();
        int[] sort = quickSort.sort(array);
        System.out.println(Arrays.toString(sort));
    }
}
