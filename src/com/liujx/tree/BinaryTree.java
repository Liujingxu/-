package com.liujx.tree;

import java.util.concurrent.ThreadPoolExecutor;

public class BinaryTree {
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public void preTraverse(){
        if (root == null){
            System.out.println("二叉树为空");
            return ;
        }

        this.root.preTraverse();
    }

    public void midTraverse(){
        if (root == null){
            System.out.println("二叉树为空");
            return ;
        }

        this.root.midTraverse();
    }

    public void postTraverse(){
        if (root == null){
            System.out.println("二叉树为空");
            return ;
        }
        this.root.postTraverse();
    }

    public TreeNode preSearch(int no){
        return this.root.preSearch(no);
    }

    public TreeNode midSearch(int no){
        return this.root.midSearch(no);
    }

    public TreeNode postSearch(int no){
        return this.root.postSearch(no);
    }

    public void deleteNode(int no){
        if (root == null || root.getNo() == no){
            root = null;
        }else{
            root.deleteNode(no);
        }
    }



    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, "刘晶旭");
        TreeNode node1 = new TreeNode(2, "曹琮皓");
        TreeNode node2 = new TreeNode(3, "赵宸");
        TreeNode node3 = new TreeNode(4, "武鹏伟");
        TreeNode node4 = new TreeNode(5, "刘恒");
        node.setLeft(node1);
        node.setRight(node2);
        node1.setLeft(node3);
        node2.setRight(node4);
        BinaryTree binaryTree = new BinaryTree(node);
        binaryTree.preTraverse();
        System.out.println();
        binaryTree.midTraverse();
        System.out.println();
        binaryTree.postTraverse();
        System.out.println();
        System.out.println();

        TreeNode treeNode = binaryTree.postSearch(3);
        System.out.println(treeNode);
        System.out.println();

        binaryTree.deleteNode(3);
        binaryTree.preTraverse();


    }
}
