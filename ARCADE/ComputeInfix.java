import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ComputeInfix {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher((strNum)).matches();
    }
    public static void main(String[] args) {
        MyStackLSTR stack = new MyStackLSTR();
        MyStackL stackD = new MyStackL();
        MyQueueL queue = new MyQueueL();
        Scanner sc = new Scanner(System.in);
        String cpi = sc.nextLine();
        StringTokenizer str = new StringTokenizer(cpi);
        while(str.hasMoreTokens()){
            String t = str.nextToken();
            if(isNumeric(t)) queue.enqueue(t);
            else{
                if(t.equals("(")) stack.push(t);
                else if(t.equals(")")){
                    while(!stack.isEmpty() && !stack.top().equals("(")){
                        queue.enqueue(stack.pop());
                    }
                    stack.pop();
                }
                if(t.equals("*")|| t.equals("/")){
                    while(!stack.isEmpty() && !stack.top().equals("(") && (stack.top().equals("*")|| stack.top().equals("/"))){
                        queue.enqueue(stack.pop());
                    }
                    stack.push(t);
                } else if(t.equals("+") || t.equals("-")) {
                    while(!stack.isEmpty() && !stack.top().equals("(")){
                        queue.enqueue(stack.pop());
                    }
                    stack.push(t);
                }
            }
        } 
        while(!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }
        // System.out.println(stack.toString());
        // System.out.println(queue.toString());
        //compute rpn
        while(!queue.isEmpty()){
            String t = queue.dequeue();
            if(isNumeric(t)) stackD.push(Double.parseDouble(t));
            else {
                if(t.equals("+")) {
                    double b = stackD.pop();
                    double a = stackD.pop();
                    stackD.push(a+b);
                }
                if(t.equals("-")) {
                    double b = stackD.pop();
                    double a = stackD.pop();
                    stackD.push(a-b);
                }
                if(t.equals("*")) {
                    double b = stackD.pop();
                    double a = stackD.pop();
                    stackD.push(a*b);
                }
                if(t.equals("/")) {
                    double b = stackD.pop();
                    double a = stackD.pop();
                    stackD.push(a/b);
                }
            }
            System.out.println("---------------------------");
            System.out.println(stackD.toString());
            System.out.println(queue.toString());
        }
        System.out.print("result: " + stackD.pop());
    }
}
