package com.liujx;

import java.util.SimpleTimeZone;
import java.util.Stack;

public class SingleLinkList {

    private HeroNode head = null;

    

    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "马超", "house over");
        HeroNode node2 = new HeroNode(2, "孙策", "grandson");
        HeroNode node3 = new HeroNode(3, "杨玉环", "sheep");
        HeroNode node4 = new HeroNode(4, "蒙鸭", "duck");
        HeroNode node5 = new HeroNode(5, "吕布", "bitch");
        SingleLinkList singleLinkList = new SingleLinkList();
        SingleLinkList singleLinkList1 = new SingleLinkList();
        singleLinkList.addByOrder(node1);
        singleLinkList1.addByOrder(node4);
        singleLinkList.addByOrder(node3);
        singleLinkList1.addByOrder(node2);
        singleLinkList.addByOrder(node5);
        singleLinkList.list();
        System.out.println();
        singleLinkList1.list();
        SingleLinkList merge = singleLinkList.merge(singleLinkList1);
        System.out.println();

        merge.list();
//        singleLinkList.delete(2);
//        singleLinkList.list();
//        singleLinkList.addByOrder(node2);
//        singleLinkList.list();
//        HeroNode node6 = new HeroNode(4, "刘晶旭", "少爷");
//        singleLinkList.update(node6);
//        singleLinkList.list();
//        System.out.println(singleLinkList.size());
//        System.out.println(singleLinkList.getLastIndex(6));
//        singleLinkList.reversePrint();
//
//        singleLinkList.list();
//        singleLinkList.reverse();
//        singleLinkList.list();
//        singleLinkList.reverse();
//        singleLinkList.list();


    }

    public SingleLinkList() {
        head = new HeroNode(0, "", "");

    }

    public SingleLinkList(HeroNode node){
        head = node;
    }

    public HeroNode reverse(){
        HeroNode tmp = head.next;
        HeroNode newHead = new HeroNode(0, "", "");
        HeroNode newTmp = newHead;
        HeroNode next = null;
        while (tmp != null){
            next = tmp.next;
            tmp.next = newTmp.next;
            newTmp.next = tmp;
            tmp = next;
        }

        head = newHead;
        return head;
    }

    public void reversePrint(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        Stack<HeroNode> stack = new Stack<>();
        HeroNode tmp = head.next;
        while (tmp != null){
            stack.push(tmp);
            tmp = tmp.next;
        }

        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }

    public HeroNode getLastIndex(int k){
        HeroNode heroNode = head.next;
        if ( heroNode == null){
            return null;
        }
        int size = size();

        if (k > size){
            return null;
        }
        for (int i = 0; i < size - k; i++){
            heroNode = heroNode.next;
        }
        return heroNode;
    }

    public int size(){
        HeroNode tmp = head.next;
        int count = 0;
        while (tmp != null){
            count++;
            tmp = tmp.next;
        }

        return count;
    }

    public void add(HeroNode node){
        HeroNode heroNode = head;
        while (heroNode.next != null){
            heroNode = heroNode.next;
        }

        heroNode.next = node;
    }

    public void addByOrder(HeroNode node){
        HeroNode heroNode = head;
        boolean flag = false;
        while (heroNode.next != null){
            if (heroNode.next.no > node.no){
                break;
            }
            if (heroNode.next.no == node.no){
                flag = true;
                break;
            }
            heroNode =  heroNode.next;
        }

        if (flag){
            System.out.println("节点已存在[" + node.no + "]");
        }else {
            node.next = heroNode.next;
            heroNode.next = node;
        }


    }

    public void update(HeroNode node){
        HeroNode heroNode = head.next;

        while (heroNode != null){
            if (heroNode.no == node.no){
                heroNode.name = node.name;
                heroNode.nickName = node.nickName;
                return ;
            }
            heroNode = heroNode.next;
        }
    }

    public void delete(int no){
        HeroNode heroNode = head;

        if (heroNode.next == null){
            System.out.println("链表为空");
            return;
        }

        while (heroNode.next != null){
            if (heroNode.next.no == no) {
                heroNode.next = heroNode.next.next;
                return;
            }
            heroNode = heroNode.next;
        }
    }

    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode heroNode = head.next;

        while (heroNode != null){
            System.out.println(heroNode);
            heroNode = heroNode.next;
        }
    }

    public HeroNode getHead() {
        return head;
    }

    static class HeroNode {
        private int no;

        private String name;

        private String nickName;

        private HeroNode next = null;

        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }

    public SingleLinkList merge(SingleLinkList other){
        HeroNode node1 = head;
        HeroNode node2 = other.getHead();
        if (node1.next == null){
            return other;
        }
        if (node2.next == null){
            return this;
        }

        HeroNode tmp1 = node1.next;
        HeroNode tmp2 = node2.next;

        HeroNode tmp = new HeroNode(0, "", "");
        HeroNode result = tmp;

        while (tmp1 != null && tmp2 != null){
            if (tmp1.no < tmp2.no){
                tmp.next = tmp1;
                tmp = tmp.next;
                tmp1 = tmp1.next;
            }else if (tmp1.no > tmp2.no){
                tmp.next = tmp2;
                tmp = tmp.next;
                tmp2 = tmp2.next;
            }else {
                throw new RuntimeException("存在相同编号");
            }
        }

        if (tmp1 == null){
            tmp.next = tmp2;
        }

        if (tmp2 == null){
            tmp.next = tmp1;
        }

        return new SingleLinkList(result);
    }
}
