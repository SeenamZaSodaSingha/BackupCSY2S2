import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class R2Q1 {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher((strNum)).matches();
    }

    public static void main(String[] args) {
        Stack<String> symStack = new Stack<>();// stack
        Stack<String> stack = new Stack<>();// stackD
        Queue<String> numQueue = new LinkedList<>();// queue
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splited = str.split("\\s+");

        for (int i = 0; i < splited.length; i++) {
            String t = splited[i];
            if (isNumeric(t)) {
                numQueue.add(t);
            } else {
                if (t.equals("*") || t.equals("/")) {
                    while (!symStack.isEmpty() && (symStack.peek().equals("*") || symStack.peek().equals("/"))) {
                        numQueue.add(symStack.pop());
                    }
                    symStack.push(t);
                } else if (t.equals("-") || t.equals("+")) {
                    while (!symStack.isEmpty()) {
                        numQueue.add(symStack.pop());
                    }
                    symStack.push(t);
                }
            }
        }

        while (!symStack.isEmpty()) {
            numQueue.add(symStack.pop());
        }

        String pervPop = "";

        while (!numQueue.isEmpty()) {
            String t = numQueue.poll();
            if (isNumeric(t))
                stack.push(t);
            else {
                if (t.equals("+")) {
                    String b = stack.pop();
                    String a = stack.pop();
                    if (!stack.isEmpty() && ((numQueue.peek().equals("*") || numQueue.peek().equals("/"))))
                        stack.push("(" + a + "+" + b + ")");
                    else if ((pervPop.equals("*") || pervPop.equals("/")))
                        stack.push("(" + a + "+" + b);
                    else
                        stack.push(a + "+" + b);
                }
                if (t.equals("-")) {
                    String b = stack.pop();
                    String a = stack.pop();
                    if (!stack.isEmpty() && ((numQueue.peek().equals("*") || numQueue.peek().equals("/"))))
                        stack.push("(" + a + "-" + b + ")");
                    else if ((pervPop.equals("*") || pervPop.equals("/")))
                        stack.push("(" + a + "-" + b);
                    else
                        stack.push(a + "-" + b);
                }
                if (t.equals("*")) {
                    String b = stack.pop();
                    String a = stack.pop();
                    if (!numQueue.isEmpty() && (numQueue.peek().equals("+") || numQueue.peek().equals("-")))
                        stack.push(a + ")" + "*" + b);
                    else
                        stack.push(a + "*" + b);
                }
                if (t.equals("/")) {
                    String b = stack.pop();
                    String a = stack.pop();
                    if (!numQueue.isEmpty() && (numQueue.peek().equals("+") || numQueue.peek().equals("-")))
                        stack.push(a + ")" + "/" + b);
                    else
                        stack.push(a + "/" + b);
                }
                pervPop = t;
            }
        }
        System.out.println(stack.pop());
        sc.close();
    }
}