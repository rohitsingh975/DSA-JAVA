package com.company;

import java.util.Stack;

public class BalancedParenthesisStack {
    public static void main(String[] args) {
        String S = "()";
        System.out.println(isValid(S));
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                st.push(x);
                continue;
            }

            if (st.isEmpty())
                return false;

            char check;
            switch (x) {
                case ')' -> {
                    check = st.pop();
                    if (check == '{' || check == '[')
                        return false;
                }
                case '}' -> {
                    check = st.pop();
                    if (check == '(' || check == '[')
                        return false;
                }
                case ']' -> {
                    check = st.pop();
                    if (check == '(' || check == '{')
                        return false;
                }
            }
        }
        return (st.isEmpty());
    }
}
