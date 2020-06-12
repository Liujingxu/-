package com.liujx.queue;

import java.util.ArrayList;
import java.util.List;

public class TT {
    public static void main(String[] args) {

    }

    public List<Integer> find(int[] A, int L, int U){
        int i = 0;
        int j = A.length;

        while (A[i] <= L){
            i++;
        }

        while (A[j] >= U){
            j--;
        }

        List<Integer> list = new ArrayList<>();
        for (int k = i; k <= j; k++){
            list.add(A[k]);
        }

        return list;
    }
}
