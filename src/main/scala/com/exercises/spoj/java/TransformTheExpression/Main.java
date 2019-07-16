package com.exercises.spoj.java.TransformTheExpression;

import java.util.Scanner;
import java.util.Stack;

class Main
{
    public static void main (String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int i;
        i = sc.nextInt();

        while(i>0){
            String str = sc.next();
            Stack stk = new Stack();
            String rnp = "";
            int len = str.length();
            char c;
            for(int k=0;k<len;k++){
                c = str.charAt(k);
                switch(c){
                    case '(': break;

                    case '+': stk.push(c);
                        break;

                    case '-': stk.push(c);
                        break;

                    case '*': stk.push(c);
                        break;

                    case '/': stk.push(c);
                        break;

                    case '^': stk.push(c);
                        break;

                    case ')': rnp = rnp + stk.pop();
                        break;

                    default : rnp = rnp + c;
                        break;
                }
            }
            System.out.println(rnp);
            i--;
        }
    }
}
