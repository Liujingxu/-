package com.liujx.tree;

public class ThreadedBinaryTree {
    private ThreadedTreeNode root = null;

    private ThreadedTreeNode pre = null;

    public ThreadedTreeNode getRoot() {
        return root;
    }

    public void setRoot(ThreadedTreeNode root) {
        this.root = root;
    }

    public void midthreadTree(ThreadedTreeNode node){
        if (node == null){
            return ;
        }

        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftIsThread(true);
        }

        if (pre.getRight() == null){
            pre.setRight(node);
            pre.setRightIsThread(true);
        }

        prethreadTree(node.getLeft());
        prethreadTree(node.getRight());

    }

    public void prethreadTree(ThreadedTreeNode node){

        if (node == null){
            return ;
        }

        prethreadTree(node.getLeft());

        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftIsThread(true);
        }

        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightIsThread(true);
        }

        pre = node;

        prethreadTree(node.getRight());
    }

    public void prethreadTree(){
        prethreadTree(root);
    }

    public void listThreadTree(){
        if (root == null){
            System.err.println("二叉树为空");
        }
        ThreadedTreeNode node = root;
        while (node != null) {
            while (!node.isLeftIsThread()){
                node = node.getLeft();
            }

            System.out.println(node);
            while (node.isRightIsThread()){
                node = node.getRight();
                System.out.println(node);
            }

            node = node.getRight();
        }
    }

    public static void main(String[] args) {
        ThreadedTreeNode node = new ThreadedTreeNode(1);
        ThreadedTreeNode node2 = new ThreadedTreeNode(3);
        ThreadedTreeNode node5 = new ThreadedTreeNode(6);
        ThreadedTreeNode node6 = new ThreadedTreeNode(8);
        ThreadedTreeNode node7 = new ThreadedTreeNode(10);
        ThreadedTreeNode node8 = new ThreadedTreeNode(14);
        node.setLeft(node2);
        node.setRight(node5);
        node2.setLeft(node6);
        node2.setRight(node7);
        node5.setLeft(node8);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(node);
        threadedBinaryTree.prethreadTree();

        threadedBinaryTree.listThreadTree();
    }
}
