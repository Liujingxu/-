package com.liujx.stack;

public class MyStack{

    private int maxSize;

    private int[] array;

    private int top = -1;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int data){
        if (isFull()){
            System.out.println("栈已满");
            return ;
        }

        array[++top] = data;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈为空");
        }

        return array[top--];
    }

    public void list(){
        if (isEmpty()){
            System.out.println("栈为空");
            return;
        }

        for (int i = 0; i <= top; i++){
            System.out.println(array[i]);
        }
    }

    public int peek(){
        return array[top];
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        for (int i = 1; i <= 5; i++){
            stack.push(i);
        }
        stack.list();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
