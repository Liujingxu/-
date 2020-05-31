package com.liujx.recursive;

public class TestStart  {

    public void print(int n){
        if (n > 1){
            print(n - 1);
        }
        System.out.println("n = " + n);
    }

    public int factorial(int n){
        if (n == 1){
            return n;
        }else{
            return factorial(n - 1) * n;
        }
    }

    public static void main(String[] args) {
        TestStart start = new TestStart();
        start.print(5);
        System.out.println(start.factorial(5));
    }

}
