package com.liujx.find;

import java.util.Arrays;
import java.util.List;

public class InsertSearch implements Search {
    @Override
    public int search(int[] array, int target) {
        return insertSearch(array, 0, array.length, target);
    }

    private int insertSearch(int[] array, int left, int right, int target){
        if (left > right || target < array[0] || target > array[array.length - 1]){
            return -1;
        }

        int mid = left + ((right - left - 1) * (target - array[left]) / (array[right - 1] - array[left]));
        int midValue = array[mid];

        if (target < midValue){
            return insertSearch(array, left, mid, target);
        }else if (target > midValue){
            return insertSearch(array, mid + 1, right, target);
        }else{
            return mid;
        }

    }

    @Override
    public List<Integer> searchAll(int[] array, int target) {
        return null;
    }

    public static void main(String[] args) {
        InsertSearch insertSearch = new InsertSearch();
        int[] array = new int[100];
        for (int i = 0; i < 100; i++){
            array[i] = i * 2 + 1;
        }
        System.out.println(Arrays.toString(array));
        int search = insertSearch.search(array, 25);
        System.out.println(search);
    }
}
