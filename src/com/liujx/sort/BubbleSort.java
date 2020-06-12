package com.liujx.sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort implements Sort {
    @Override
    public int[] sort(int[] array) {

        boolean flag = false;
        int tmp = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - i - 1; j++){
                if (array[j] > array[j + 1]){
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }else {
                flag = false;
            }
//            System.out.println("第" + (i + 1)  + "次排序结果: " + Arrays.toString(array));
        }

        return array;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        Random random = new Random(256);
        int[] array = random.ints(80000).toArray();
        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
//        System.out.println("timestamp-start " + start);
        int[] sort = bubbleSort.sort(array);
//        System.out.println(Arrays.toString(sort));
        long end = System.currentTimeMillis();
//        System.out.println("timestamp-end " + end);
        System.out.println((end - start));
    }
}
