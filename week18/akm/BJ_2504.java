package week_18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BJ_2504 {
    public static void main(String[] args) {
        new BJ_2504().solve();
    }

    String parth;
    int result;

    final String OPEN_MIDDLE = "(";
    final String CLOSE_MIDDLE = ")";
    final String OPEN_BIG = "[";
    final String CLOSE_BIG = "]";

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            parth = br.readLine();
            if (!isValidParth(parth)) {
                System.out.println(0);
                return;
            }

            parth = parth.replaceAll("\\(\\)", "2");
            parth = parth.replaceAll("\\[]", "3");
            String[] sArr = parth.split("");

            ArrayList<String> list = new ArrayList<>(Arrays.asList(sArr));
            int orgSize;
            while (true) {
                orgSize = list.size();

                for (int i = 0; i < list.size() - 2; i++) {
                    if (isNumber(list.get(i)) && isNumber(list.get(i + 1))) {
                        list.set(i, String.valueOf(Integer.parseInt(list.get(i)) + Integer.parseInt(list.get(i + 1))));
                        list.remove(i + 1);
                        continue;
                    }

                    switch (list.get(i)) {
                        case OPEN_MIDDLE:
                            if (isNumber(list.get(i + 1)) && list.get(i + 2).equals(CLOSE_MIDDLE)) {
                                list.set(i, String.valueOf(Integer.parseInt(list.get(i + 1)) * 2));
                                list.remove(i + 1);
                                list.remove(i + 1);
                            }

                            break;
                        case OPEN_BIG:
                            if (isNumber(list.get(i + 1)) && list.get(i + 2).equals(CLOSE_BIG)) {
                                list.set(i, String.valueOf(Integer.parseInt(list.get(i + 1)) * 3));
                                list.remove(i + 1);
                                list.remove(i + 1);
                            }
                            break;
                    }
                }


                if (orgSize == list.size()) {
                    break;
                }
            }

            for (String s : list) {
                result += Integer.parseInt(s);
            }

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    boolean isNumber(String s) {
        boolean isNum = true;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                isNum = false;
                break;
            }
        }

        return isNum;
    }

    boolean isValidParth(String parth) {
        Stack<Character> stack = new Stack<>();
        for (char c : parth.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    }
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    }
                    stack.pop();
                    break;
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
