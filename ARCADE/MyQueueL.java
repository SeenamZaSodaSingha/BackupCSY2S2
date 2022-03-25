public class MyQueueL {
    public class Node{
        String data = "";
        Node next;
        public Node(String d){
            data = d;
        }
    }
    Node head = null, tail;
    public void enqueue(String d){
        Node p = new Node(d);
        if(head == null){
            head = tail = p;
        } else {
            tail.next = p;
            tail = tail.next;
        }
    }
    public String dequeue(){
        String d = head.data;
        head = head.next;
        return d;
    }
    public String front(){
        return head.data;
    }
    public boolean isFull(){
        return false;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer("top");
        Node p = head;
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
