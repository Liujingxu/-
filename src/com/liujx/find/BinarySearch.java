package com.liujx.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch implements Search {

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        int[] array = new int[]{1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> search1 = search.searchAll(array, 4);
        System.out.println(search1);
    }

    private int[] array = null;

    @Override
    public int search(int[] array, int target) {
        this.array = array;
        return binarySearch(0, array.length, target);
    }

    private int binarySearch(int left, int right, int target){

        if (left >= right){
            return -1;
        }

        int mid = (left + right) / 2;
        int midValue = array[mid];
        if (target > midValue){
            return binarySearch(mid + 1, right, target);
        }else if (target < midValue){
            return binarySearch(left, mid, target);
        }else{
            return mid;
}

    }

    private List<Integer> binarySearchAll(int left, int right, int target, List<Integer> list){
        if (left >= right){
            return list;
        }

        int mid = (left + right) / 2;
        int midValue = array[mid];

        if (target > midValue){
            return binarySearchAll(mid + 1, right, target, list);
        }else if (target < midValue){
            return binarySearchAll(left, mid, target, list);
        }else{
            while (midValue == target){
                list.add(mid++);
                midValue = array[mid];
            }
            return list;
        }
    }

    @Override
    public List<Integer> searchAll(int[] array, int target) {
        List<Integer> list = new ArrayList<>();
        this.array = array;
        return binarySearchAll(0, array.length, target, list);
    }
}
