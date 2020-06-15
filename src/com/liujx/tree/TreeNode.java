package com.liujx.tree;

public class TreeNode {

    private static int count = 0;

    private Integer no;

    private String name;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(Integer no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void preTraverse(){
        System.out.println(this);
        if (this.left != null){
            this.left.preTraverse();
        }

        if (this.right != null){
            this.right.preTraverse();
        }
    }

    public void midTraverse(){
        if (this.left != null){
            this.left.midTraverse();
        }

        System.out.println(this);

        if (this.right != null){
            this.right.midTraverse();
        }

    }

    public void postTraverse(){
        if (this.left != null){
            this.left.postTraverse();
        }

        if (this.right != null){
            this.right.postTraverse();
        }

        System.out.println(this);
    }

    public TreeNode preSearch(int no){

        System.out.println("查找，第" + (++count) + "次");

        if (this.no == no){
            return this;
        }

        TreeNode result = null;
        if (this.left != null){
            result = this.left.preSearch(no);
        }

        if (result != null){
            return result;
        }

        if (this.right != null){
            result = this.right.preSearch(no);
        }

        return result;
    }

    public TreeNode midSearch(int no){


        TreeNode result = null;
        if (this.left != null){
            result = this.left.midSearch(no);
        }

        if (result != null){
            return result;
        }
        System.out.println("查找，第" + (++count) + "次");
        if (this.no == no){
            return this;
        }

        if (this.right != null){
            result = this.right.midSearch(no);
        }

        return result;
    }

    public TreeNode postSearch(int no){


        TreeNode result = null;
        if (this.left != null){
            result = this.left.postSearch(no);
        }

        if (result != null){
            return result;
        }

        if (this.right != null){
            result = this.right.postSearch(no);
        }

        if (result != null){
            return result;
        }
        System.out.println("查找，第" + (++count) + "次");
        return this.no == no ? this : null;
    }

    public void deleteNode(int no){

        if (this.left != null && this.left.no == no){
            this.left = null;
            return ;
        }

        if (this.right != null && this.right.no == no){
            this.right = null;
            return ;
        }

        if (this.left != null){
            this.left.deleteNode(no);
        }

        if (this.right != null){
            this.right.deleteNode(no);
        }
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
