public class MyStackA {
    int MAX_SIZE = 100;
    double stack[] = new double[MAX_SIZE];
    int top = 0;
    public void push(double d){
        stack[top++] = d;
    }
    public double pop(){
        //if(top == 0) return stack[0];
        return stack[--top];
    }
    public double top(){
        return stack[top-1];
    }
    public boolean isFull(){
        return top==MAX_SIZE;
    }
    public boolean isEmpty(){
        return top==0;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i = 0; i < top-1; i++){
            sb.append(stack[i]);
            sb.append(",");
        }
        if(top > 0) sb.append(stack[top-1]);
        sb.append("]");
        return sb.toString();
    }
}
