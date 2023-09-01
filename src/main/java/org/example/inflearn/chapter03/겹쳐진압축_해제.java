package org.example.inflearn.chapter03;

import javax.xml.stream.events.Characters;
import java.util.Stack;

public class 겹쳐진압축_해제 {
    public String solution(String s) {
        String answer = "";
        Stack<String> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            if (x == ')') {
                String tmp = "";

                while (!stack.isEmpty()) {
                    String c = stack.pop();

                    if (c.equals("(")) {
                        String num = "";
                        while (!stack.empty() && Character.isDigit(stack.peek().charAt(0))) {
                            num = stack.pop() + num;
                        }

                        String res = "";
                        int cnt = 0;

                        if (num.equals(""))
                            cnt = 1;
                        else
                            cnt = Integer.parseInt(num);

                        for (int i = 0; i < cnt; i++) {
                            res += tmp;
                        }
                        stack.push(res);
                        break;

                    } else {
                        tmp = c + tmp;
                    }
                }

            } else {
                stack.push(String.valueOf(x));
            }
        }

        for (String x : stack)
            answer += x;
        return answer;
    }

    public String solution1(String s) {
        String answer = "";
        Stack<String> st = new Stack<>();

        for (Character x : s.toCharArray()) {
            if (x == ')') {
                String tmp = "";

                while (!st.empty()) {
                    String c = st.pop();

                    if (c.equals("(")) {
                        String num = "";
                        while (!st.empty() && Character.isDigit(st.peek().charAt(0))) {
                            num = st.pop() + num;
                        }

                        String res = "";
                        int cnt = 0;

                        if (num.equals(""))
                            cnt = 1;
                        else
                            cnt = Integer.parseInt(num);

                        for (int i = 0; i < cnt; i++)
                            res += tmp;

                        st.push(res);
                        break;
                    }
                    tmp = c + tmp;
                }
            } else
                st.push(String.valueOf(x));
        }

        for (String x : st)
            answer += x;
        return answer;
    }

    public static void main(String[] args) {
        겹쳐진압축_해제 T = new 겹쳐진압축_해제();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}
