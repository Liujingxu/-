package com.liujx.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = new int[]{6, 5, 2, 3, 4};
        Random random = new Random(256);
        int[] stream = random.ints().toArray();
        int[] tem = new int[stream.length];
        int[] sort = mergeSort.mergeSort(stream, 0, stream.length - 1, tem);
        System.out.println(Arrays.toString(sort));
    }


    public int[] mergeSort(int[] array, int left, int right, int[] temp){


        if (left < right){
            int mid = (left + right) / 2;
            array = mergeSort(array, left, mid, temp);
            array = mergeSort(array, mid + 1, right, temp);
            array = merge(array, left, mid, right, temp);
        }

        return array;
    }

    public int[] merge(int[] array, int left, int mid,  int right, int[] temp){

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right){
            if (array[i] > array[j]){
                temp[k] = array[j];
                j++;
            }else{
                temp[k] = array[i];
                i++;
            }
            k++;
        }

        while (i <= mid){
            temp[k++] = array[i++];
        }

        while (j <= right){
            temp[k++] = array[j++];
        }

        int ll = left;
        k = 0;
        while (ll <= right){
            array[ll++] = temp[k++];
        }

        return array;
    }
}
