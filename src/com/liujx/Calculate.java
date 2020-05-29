package com.liujx;

public class Calculate {

    public static void main(String[] args) {
        String func = "1+2+3+4+5+6+7+8+9+10";
        int length = func.length();
        MyStack numStack = new MyStack(length);
        MyStack opStack = new MyStack(length);
        int opt = 0;
        int num1 = 0;
        int num2 = 0;
        String realNum = "";
        for (int i = 0; i < length; i++){
            char c = func.charAt(i);
            if (isOpt(c)){
                if (opStack.isEmpty()){
                    opStack.push(c);
                }else{
                    if (getWeight(c) > getWeight(opStack.peek())){
                        opStack.push(c);
                    }else{
                        opt = opStack.pop();
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        int result = cal(num2, opt, num1);
                        numStack.push(result);
                        opStack.push(c);
                    }
                }
            }else{
                realNum += c;
                if (i == length - 1 || isOpt(func.charAt(i + 1))){
                    numStack.push(Integer.parseInt(realNum));
                    realNum = "";
                }

            }
        }

        while (!opStack.isEmpty()){
            num2 = numStack.pop();
            num1 = numStack.pop();
            opt = opStack.pop();
            int result = cal(num1, opt, num2);
            numStack.push(result);
        }

        System.out.println(numStack.pop());



    }

    public static boolean isOpt(int data){
        return data == '+' || data == '-' || data == '*' || data == '/';
    }

    public static int getWeight(int opt){
        if (opt == '*' || opt == '/'){
            return 1;
        }else{
            return 0;
        }
    }

    public static int cal(int num1, int opt, int num2){

        switch (opt){
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num1 / num2;
            default:
                return 0;
        }
    }
}
