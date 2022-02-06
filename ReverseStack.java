package com.company;


import java.util.Stack;

public class ReverseStack {
    static Stack<Character> st = new Stack<>();

    static void pushBottom(char y) {
        if (st.empty())
            st.push(y);
        else {
            char x = st.peek();
            st.pop();
            pushBottom(y);
            st.push(x);
        }
    }

    static void reverse() {
        if (st.size() > 0) {
            char y = st.peek();
            st.pop();
            reverse();
            pushBottom(y);
        }
    }

    public static void main(String[] args) {

        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');
        System.out.println("Original Stack");

        System.out.println(st);

        // function to reverse
        // the stack
        reverse();

        System.out.println("Reversed Stack");

        System.out.println(st);
    }


}
