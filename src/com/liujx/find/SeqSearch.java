package com.liujx.find;

import java.util.ArrayList;
import java.util.List;

public class SeqSearch implements Search {


    public static void main(String[] args) {
        SeqSearch search = new SeqSearch();
        int[] array = new int[]{1, 2, 5, 5, 6, 8};
        List<Integer> search1 = search.searchAll(array, 5);
        System.out.println(search1);

    }
    @Override
    public int search(int[] array, int target) {
        for (int i = 0; i < array.length; i++){
            if (array[i] == target){
                return i;
            }
        }

        return -1;
    }

    @Override
    public List<Integer> searchAll(int[] array, int target) {
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            if (array[i] == target){
                index.add(i);
            }
        }
        return index;
    }
}
