package com.liujx;

public class SingleLinkList {

    private HeroNode head = null;

    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "马超", "house over");
        HeroNode node2 = new HeroNode(2, "孙策", "grandson");
        HeroNode node3 = new HeroNode(3, "杨玉环", "sheep");
        HeroNode node4 = new HeroNode(4, "蒙鸭", "duck");
        HeroNode node5 = new HeroNode(5, "吕布", "bitch");
        SingleLinkList singleLinkList = new SingleLinkList();
        singleLinkList.addByOrder(node1);
        singleLinkList.addByOrder(node4);
        singleLinkList.addByOrder(node3);
        singleLinkList.addByOrder(node2);
        singleLinkList.addByOrder(node5);
        singleLinkList.list();
        singleLinkList.delete(2);
        singleLinkList.list();
        singleLinkList.addByOrder(node2);
        singleLinkList.list();
        HeroNode node6 = new HeroNode(4, "刘晶旭", "少爷");
        singleLinkList.update(node6);
        singleLinkList.list();
    }

    public SingleLinkList() {
        head = new HeroNode(0, "", "");

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
        }

        HeroNode heroNode = head.next;

        while (heroNode != null){
            System.out.println(heroNode);
            heroNode = heroNode.next;
        }
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
}
