package com.liujx.recursive;

public class Test {

    public int test(int n){
        if (n == 1){
            return 1;
        }else{
            return test(n - 1) * n;
        }
    }

    public static void main(String[] args) {
        ;
    }
}
