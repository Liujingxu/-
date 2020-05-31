package com.liujx.recursive;

public class Queen8 {

    private int max = 8;
    private int[] array = new int[max];
    private int count = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(queen8.count);
    }

    public void print(){
        count++;
        for (int i = 0; i < max; i++){
            for (int j = 0; j < max; j++){
                if (array[i] == j){
                    System.out.print(1 + "\t");
                }else{
                    System.out.print(0 + "\t");
                }
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    public boolean judge(int n){
        for (int i = 0; i < n; i++){
            if (array[i] == array[n] || Math.abs(i - n) == Math.abs(array[i] - array[n])){
                return false;
            }
        }
        return true;
    }

    public void check(int n){

        if (n == max){
            print();
            return ;
        }

        for (int i = 0; i < max; i++){
            array[n] = i;
            if (judge(n)){
                check(n + 1);
            }
        }
    }
}
