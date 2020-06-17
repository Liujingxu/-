package com.liujx.tree;

public class ArrBinaryTree {

    private int[] array;

    public ArrBinaryTree(int[] array) {
        this.array = array;
    }

    public void preOrder(int index){

        if (array == null || array.length == 0){
            System.err.println("二叉树为空");
            return ;
        }

        System.out.println(array[index]);

        if ((index * 2 + 1) < array.length){
            preOrder(index * 2 + 1);
        }

        if ((index * 2 + 2) < array.length){
            preOrder(index * 2 + 2);
        }

    }

    public void preOrder(){
        preOrder(0);
    }

    public void midOrder(int index){
        if (array == null || array.length == 0){
            System.err.println("二叉树为空");
        }

        if ((index * 2 + 1) < array.length){
            midOrder(index * 2 + 1);
        }

        System.out.println(array[index]);

        if ((index * 2 + 2) < array.length){
            midOrder(index * 2 + 2);
        }

    }

    public void midOrder(){
        midOrder(0);
    }

    public void postOrder(int index){
        if (array == null || array.length == 0){
            System.err.println("二叉树为空");
        }

        if ((index * 2 + 1) < array.length){
            postOrder(index * 2 + 1);
        }

        if ((index * 2 + 2) < array.length){
            postOrder(index * 2 + 2);
        }

        System.out.println(array[index]);
    }

    public void postOrder(){
        postOrder(0);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        ArrBinaryTree tree = new ArrBinaryTree(array);
        tree.preOrder();
        tree.midOrder();
        tree.postOrder();

    }
}
