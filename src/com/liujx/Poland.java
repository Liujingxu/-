package com.liujx;

import java.util.*;

public class Poland {

    public Queue<String> toInFix(String func){
        List<String> translate = translate(func);

        Stack<String> s1 = new Stack<>();
        Queue<String> result = new ArrayDeque<>();



        for (String str : translate){
            if (str.matches("\\d+")){
                result.add(str);
            }else if (")".equals(str)){
                while (!"(".equals(s1.peek())){
                    result.add(s1.pop());
                }
                s1.pop();
            }else if ("(".equals(str)){
                s1.push(str);
            }else{
                if (s1.empty()){
                    s1.push(str);
                }else{
                    while (!s1.empty() && !"(".equals(s1.peek()) && getWeight(str.charAt(0)) <= getWeight(s1.peek().charAt(0))){
                        result.add(s1.pop());
                    }
                    s1.push(str);

                }
            }
        }

        while (!s1.empty()){
            result.add(s1.pop());
        }

        return result;
    }

    public List<String> translate(String func){
        List<String> list = new ArrayList<>();
        String realNum = "";
        for (int i = 0; i < func.length(); i++){
            char c = func.charAt(i);
            if (isOpt(c)){
                list.add(String.valueOf(c));
            }else{
                realNum += c;
                if (i == func.length() - 1 || isOpt(func.charAt(i + 1))){
                    list.add(realNum);
                    realNum = "";
                }
            }
        }
        return list;
    }

    public boolean isOpt(int data){
        return data < 48 || data > 57;
    }

    public int getWeight(int data){
        if (data == '+' || data == '-'){
            return 1;
        }else{
            return 2;
        }
    }

    public int polandCalculate(String func){
        String[] array = func.split(" ");
        Stack<String> stack = new Stack<>();
        for (int i = array.length - 1; i >= 0; i--){
            if (array[i].matches("\\d+")){
                stack.push(array[i]);
            }else{
                String num1 = stack.pop();
                String num2 = stack.pop();
                int n1 = Integer.parseInt(num1);
                int n2 = Integer.parseInt(num2);
                switch (array[i]){
                    case "+": stack.push(String.valueOf(n1 + n2));break;
                    case "-": stack.push(String.valueOf(n1 - n2));break;
                    case "*": stack.push(String.valueOf(n1 * n2));break;
                    case "/": stack.push(String.valueOf(n1 / n2));break;
                    default:
                        throw new RuntimeException("表达式错误");
                }
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public int rePolandCalculate(String func){
        String[] array = func.split(" ");
        Stack<String> stack = new Stack<>();
        for (String item : array){
            if (item.matches("\\d+")){
                // 是个数
                stack.push(item);
            }else{
                // 是个运算符
                String num1 = stack.pop();
                String num2 = stack.pop();
                int n2 = Integer.parseInt(num1);
                int n1 = Integer.parseInt(num2);
                switch (item){
                    case "+": stack.push(String.valueOf(n1 + n2));break;
                    case "-": stack.push(String.valueOf(n1 - n2));break;
                    case "*": stack.push(String.valueOf(n1 * n2));break;
                    case "/": stack.push(String.valueOf(n1 / n2));break;
                    default:
                        throw new RuntimeException("表达式错误");
                }
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        Poland poland = new Poland();
        List<String> list = poland.translate("(30+4)*55-66");
        System.out.println(list);
        Queue<String> queue = poland.toInFix("1+2*3/4");
        StringBuilder func = new StringBuilder();
        while (!queue.isEmpty()){
            func.append(queue.poll() + " ");
        }
        System.out.println(func);

        int calculate = poland.rePolandCalculate(func.toString());
        System.out.println(calculate);
    }
}
