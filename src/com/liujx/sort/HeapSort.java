package com.liujx.sort;

import java.util.Arrays;

public class HeapSort {


    public int[] heapSort(int[] array){

        for (int i = array.length / 2 - 1; i >= 0; i--){
            adjustHeap(array, i, array.length);
        }

        int temp;
        for (int i = array.length - 1; i > 0; i--){
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            adjustHeap(array, 0, i);
        }

        return array;
    }


    public void adjustHeap(int[] array, int index, int length){
        int temp = array[index];

        for (int k = index * 2 + 1; k < length; k = k * 2 + 1){
            if (k + 1 < length && array[k] < array[k+1]){
                k++;
            }

            if (temp < array[k]){
                array[index] = array[k];
                index = k;
            }else {
                break;
            }
        }

        array[index] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] array = {1, 4, 2, 8, 5, 7};
        int[] sort = heapSort.heapSort(array);
        System.out.println(Arrays.toString(sort));
    }
}
