package com.liujx.queue;

import java.util.Scanner;

public class MyQueue {

    private int maxSize;

    private int front = -1;

    private int rear = -1;

    private int[] array;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    public boolean isFull(){
        return rear >= maxSize - 1;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public void addQueue(int newData){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }

        array[++rear] = newData;


    }

    public int get(){
        if (isEmpty()){
            throw new RuntimeException("队列已空");
        }

        return array[++front];
    }

    public int getHead(){
        if (isEmpty()){
            throw new RuntimeException("队列已空");
        }

        return array[front + 1];
    }

    public void list(){
        if (isEmpty()){
            System.out.println("队列已空");
            return;
        }
        System.out.print("index\t");
        for (int i = 0; i < array.length; i++){
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.print("value\t");
        for (int arr : array){
            System.out.print(arr + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        MyQueue queue = new MyQueue(3);
        CircleQueue queue = new CircleQueue(3);
        boolean flag = true;

        while (flag){
            System.out.println("l——list");
            System.out.println("a——add");
            System.out.println("g——gethead");
            System.out.println("p——pop");
            System.out.println("e——exit");
            char c = scanner.next().charAt(0);
            switch (c){
                case 'l': queue.list();break;
                case 'a': queue.addQueue(scanner.nextInt());break;
                case 'g':
                    try{
                        System.out.println("得头" + queue.getHead());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try {
                        System.out.println("取头"  + queue.get());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    flag = false;
                    break;
                case 's':
                    System.out.println(queue.size());
                    default:
            }

        }
        System.out.println("关闭程序");
    }
}
