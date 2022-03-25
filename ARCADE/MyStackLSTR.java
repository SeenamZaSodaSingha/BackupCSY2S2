public class MyStackLSTR {
    public class Node{
        String data = "";
        Node next;
        public Node(String d){
            data = d;
        }
    }
    Node top = null;
    public void push(String d){
        Node p = new Node(d);
        p.next = top;
        top = p;
    }
    public String pop(){
        String d = top.data;
        top = top.next;
        return d;
    }
    public String top(){
        return top.data;
    }
    public boolean isFull(){
        return false;
    }
    public boolean isEmpty(){
        return top==null;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer("top");
        Node p = top;
        while(p!=null){
            sb.append("-->[");
            sb.append(p.data);
            sb.append("]");
            p = p.next;
        }
        sb.append("-->bottom");
        return new String(sb);
    }
}
