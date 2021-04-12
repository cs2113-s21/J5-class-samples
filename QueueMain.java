

public class QueueMain{
    
  public static class QThread extends Thread {
    Queue Q;
    public QThread(Queue Q) {
      this.Q = Q;
    }

    public void run() {
      for( int i = 0; i < 1000; i++ )
        Q.enqueue("b" + i);
    }
  }

  public static void main(String[] args) {
    Queue  Q = new Queue();
    Thread t = new QThread(Q);

    t.start();

    while (Q.empty()) {}

    for( int i = 0; i < 1000; i++ ) {
      Q.enqueue("a" + i);
    }

    while( t.isAlive() ) {}
    int a = 0, b = 0;

    while( !Q.empty() ) {
      if( Q.dequeue().charAt(0) == 'a' )
        a++;
      else
        b++;
    }
    System.out.println("a=" + a + " b=" + b);
  }
}

