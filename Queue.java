
public class Queue {

    //sycnrhonized says that this method is CRITICAL and must be fully
    //completed before another thread can enter the method
    //
    // ONLY one thread can run this method a time.
  public synchronized void enqueue(String s) {
    if( head == null ) {
      head = tail = new Node(s, null);
    } else {
      tail.next = new Node(s, null);
      tail = tail.next;
    }
  }

  public String dequeue() {
    Node t = head;

    head = head.next;

    if( head == null ) {
      tail = null;
    }
    return t.data;
  }

  public boolean empty() {
    return head == null;
  }

  private class Node {
    public String data;
    public Node next;
    public Node(String d, Node n) {
      data = d;
      next = n;
    }
  }
    private volatile Node head = null;
    private volatile Node tail = null;
}

