package com.liujx;

import java.util.Arrays;

public class CircleLinkList {

    private JosephuNode first = null;

    public int[] out(int startNo, int countNo, int nums){

        int[] result = new int[nums];

        if (startNo < 1 || startNo > nums){
            System.out.println("参数有误");
            return null;
        }

        add(nums);

        JosephuNode helper = first;
        while(helper.next != first){
            helper = helper.next;
        }


        for (int i = 0; i < startNo - 1; i++){
            first = first.next;
            helper = helper.next;
        }

        int index = 0;
        while (first != helper){
            for (int i = 0; i < countNo - 1; i++){
                first = first.next;
                helper = helper.next;
            }

            result[index++] = first.no;
            first = first.next;
            helper.next = first;

        }

        result[index] = first.no;

        return result;


    }


    public static void main(String[] args) {
        CircleLinkList cll = new CircleLinkList();
        int[] out = cll.out(1, 2, 5);
        System.out.println(Arrays.toString(out));
    }

    public CircleLinkList(JosephuNode first) {
        this.first = first;
    }

    public CircleLinkList() {
        first = null;
    }

    public void add(int size){
        if (size < 1){
            System.out.println("size数目不正确");
        }

        JosephuNode tmp = null;
        for (int i = 1; i <= size; i++){
            JosephuNode josephuNode = new JosephuNode(i);
            if (i == 1){
                first = josephuNode;
                tmp = first;
                first.next = first;
            }else{
                josephuNode.next = tmp.next;
                tmp.next = josephuNode;
                tmp = tmp.next;
            }
        }
    }

    public void show(){
        JosephuNode tmp = first;
        if (tmp == null){
            System.out.println("无节点");
        }

        while (true){
            System.out.println(tmp);
            if (tmp.next == first){
                return ;
            }
            tmp = tmp.next;
        }
    }

    class JosephuNode {
        private int no;
        private JosephuNode next = null;

        public JosephuNode(int no) {
            this.no = no;
        }

        @Override
        public String toString() {
            return "JosephuNode{" +
                    "no=" + no +
                    '}';
        }
    }
}
