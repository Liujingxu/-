package com.liujx.tree;

public class ThreadedTreeNode{

    private Integer no;

    private ThreadedTreeNode left;

    private ThreadedTreeNode right;

    private boolean leftIsThread;

    private boolean rightIsThread;

    public ThreadedTreeNode(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public ThreadedTreeNode getLeft() {
        return left;
    }

    public void setLeft(ThreadedTreeNode left) {
        this.left = left;
    }

    public ThreadedTreeNode getRight() {
        return right;
    }

    public void setRight(ThreadedTreeNode right) {
        this.right = right;
    }

    public boolean isLeftIsThread() {
        return leftIsThread;
    }

    public void setLeftIsThread(boolean leftIsThread) {
        this.leftIsThread = leftIsThread;
    }

    public boolean isRightIsThread() {
        return rightIsThread;
    }

    public void setRightIsThread(boolean rightIsThread) {
        this.rightIsThread = rightIsThread;
    }

    @Override
    public String toString() {
        return "ThreadedTreeNode{" +
                "no=" + no +
                '}';
    }
}
