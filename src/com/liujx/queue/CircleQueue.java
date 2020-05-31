package com.liujx.queue;

public class CircleQueue {
    private int maxSize;
    private int front = 0;
    private int rear = 0;

    private int[] array;

    public CircleQueue(int maxSize){
        this.maxSize = maxSize + 1;
        array = new int[maxSize + 1];
    }

    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    public void addQueue(int newData){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }



        array[rear] = newData;
        rear = (rear + 1) % maxSize;
    }

    public int get(){
        if (isEmpty()){
            throw new RuntimeException("队列已空");
        }

        int result = array[front];
        front = (front + 1) % maxSize;
        return result;
    }

    public int getHead(){
        if (isEmpty()){
            throw new RuntimeException("队列已空");
        }
        return array[front];
    }

    public void list(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }

        System.out.print("index\t");
        for (int i = front; i < front + size(); i++){
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println("value\t");
        for (int i = front; i < front + size(); i++){
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
