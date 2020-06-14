package com.liujx.hash;

public class EmpLinkList {

    private EmpNode head = null;

    public void add(Employee employee){
        if (head == null){
            head = new EmpNode(employee);
            return ;
        }

        EmpNode point = head;

        while (point.next != null){
            point = point.next;
        }

        point.next = new EmpNode(employee);
    }

    public void list(int index){

        System.out.print(index + "号链表：");

        if (head == null){
            System.out.print("链表为空");
        }

        EmpNode point = head;

        while (point != null){
            System.out.print(point.employee + "  ==>  ");
            point = point.next;
        }

    }

    public Employee getEmpById(int id){
        EmpNode point = head;
        Employee employee = null;
        while (point != null){
            if (point.employee.getId() == id){
                employee = point.employee;
                break;
            }
            point = point.next;
        }

        return employee;
    }

    public Employee delete(int id){
        EmpNode point = head;
        EmpNode pre = null;
        Employee result = null;

        while (point != null){
            if (point.employee.getId() == id){
                if (pre == null){
                    result = point.employee;
                    head = point.next;
                }else{
                    pre.next = point.next;
                    result = point.employee;
                }
                break;
            }
            pre = point;
            point = point.next;

        }

        return result;
    }

    public static void main(String[] args) {
        EmpLinkList list = new EmpLinkList();
        Employee employee = new Employee(15, "刘晶旭");
        Employee employee1 = new Employee(18, "武鹏伟");
        list.add(employee);
        list.add(employee1);
        list.list(0);
    }
}
