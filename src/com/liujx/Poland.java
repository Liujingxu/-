package com.liujx;

import java.util.Arrays;
import java.util.Stack;

public class Poland {

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
        int calculate = poland.polandCalculate("- * + 3 4 50 6 ");
        int result = poland.rePolandCalculate("3 4 + 50 * 6 -");
        System.out.println(calculate + ", " + result);
        System.out.println(calculate == result);
    }
}
