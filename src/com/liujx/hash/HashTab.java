package com.liujx.hash;

public class HashTab {
    private EmpLinkList[] lists = null;
    private int size;

    public HashTab(int size) {
        this.size = size;
        lists = new EmpLinkList[size];
        for (int i = 0; i < size; i++){
            lists[i] = new EmpLinkList();
        }
    }

    private int hash(int num){
        return num % size;
    }

    public void add(Employee employee){
        int hash = hash(employee.getId());
        lists[hash].add(employee);
    }

    public void list(){
        System.out.println("遍历：");
        int index = 0;
        for (EmpLinkList el : lists){
            el.list(index++);
            System.out.println();
        }
    }

    public Employee find(int id){
        int hash = hash(id);
        return lists[hash].getEmpById(id);
    }

    public Employee delete(int id){
        int hash = hash(id);
        return lists[hash].delete(id);
    }

    public static void main(String[] args) {
        HashTab hashTab = new HashTab(5);
        hashTab.add(new Employee(13, "刘晶旭"));
        hashTab.add(new Employee(16, "武鹏伟"));
        hashTab.add(new Employee(15, "赵昂"));
        hashTab.add(new Employee(17, "刘恒"));
        hashTab.add(new Employee(18, "赵锤"));
        hashTab.add(new Employee(12, "曹火锅"));
        hashTab.list();
        System.out.println("find:" + hashTab.find(16));
        System.out.println("delete:" + hashTab.delete(17));
        hashTab.list();
    }

}
