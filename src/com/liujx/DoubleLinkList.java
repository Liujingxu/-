package com.liujx;

public class DoubleLinkList {

    private LinkNode head = null;

    public DoubleLinkList(LinkNode head) {
        this.head = head;
    }

    public DoubleLinkList() {
        head = new LinkNode(0, "", "");
    }




    public LinkNode getHead() {
        return head;
    }

    public void add(LinkNode node){
        LinkNode linkNode = head;
        while (linkNode.next != null){
            linkNode = linkNode.next;
        }

        linkNode.next = node;
        node.pred = linkNode;
    }

    public void update(LinkNode node){
        LinkNode linkNode = head.next;

        while (linkNode != null){
            if (node.no == linkNode.no){
                linkNode.name = node.name;
                linkNode.nickName = node.nickName;
                return;
            }
            linkNode = linkNode.next;
        }
    }

    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        LinkNode linkNode = head.next;

        while (linkNode != null){
            System.out.println(linkNode);
            linkNode = linkNode.next;
        }
    }

    public void delete(int no){
        LinkNode linkNode = head.next;

        while (linkNode != null){
            if (linkNode.no == no){
                linkNode.pred.next = linkNode.next;
                if (linkNode.next != null){
                    linkNode.next.pred = linkNode.pred;
                }
            }

            linkNode = linkNode.next;
        }
    }

    class LinkNode {
        private int no;
        private String name;
        private String nickName;
        private LinkNode pred;
        private LinkNode next;

        public LinkNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "LinkNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }
}
