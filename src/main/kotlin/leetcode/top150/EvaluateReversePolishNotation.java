package src.main.kotlin.leetcode.top150;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
//        System.out.println(convertStringToInt("-12"));
        System.out.println(Integer.parseInt("-15"));
    }
    public int evalRPN(String[] tokens) {
        if (tokens.length==1){
            return Integer.parseInt(tokens[0]);
        }
        Stack<String> stack = new Stack<>();
        int ans=0;
        int len=tokens.length;
        for (int i = 0; i < len; i++) {
            if (tokens[i].contentEquals("/")||tokens[i].contentEquals("*")||tokens[i].contentEquals("+")||tokens[i].contentEquals("-")){
                int first=Integer.parseInt(stack.pop());
                int second=Integer.parseInt(stack.pop());
                if (tokens[i].contentEquals("/")){
                    ans=second/first;
                }else if (tokens[i].contentEquals("+")){
                    ans=second+first;
                }else if (tokens[i].contentEquals("-")){
                    ans=second-first;
                }else if (tokens[i].contentEquals("*")){
                    ans=second*first;
                }
                stack.push(""+ans);
            }else{
                stack.push(tokens[i]);
            }
        }
        return ans;
    }
    public int evalRPNOptimized(String[] tokens) {
        Stack<Long> stack = new Stack<>();
        int n=tokens.length;
        for (int i = 0; i < n; i++) {
            if (tokens[i].length()==1 && tokens[i].charAt(0)<48){
                long num1=stack.pop();
                long num2=stack.pop();
                long ans=resolves(num1,num2,tokens[i].charAt(0));
                stack.push(ans);
            }else{
                stack.push(Long.parseLong(tokens[i]));
            }
        }
        return stack.pop().intValue();
    }
    long resolves(long a,long b,char operator){
        if (operator=='+') return a+b;
        else if (operator=='-') return a-b;
        else if (operator=='*') return a*b;
        else return a/b;
    }
}
