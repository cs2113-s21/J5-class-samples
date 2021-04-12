import java.util.*;

public class PrintSlowly {
  public static Random rand = new Random();

  public static void printSlow(String s, String t) {
    for (int i = 0; i < s.length(); i++) {
      try {
        Thread.sleep(rand.nextInt(1000));
      } catch (Exception e) {}
      System.out.println(t + s.charAt(i));
    }
  }

  public static void main(String[] args) {
    
    FooThread t = new FooThread("\t");
    t.start();

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter a word:");
    String s = sc.next();

    t.setMsg(s);

    //I actually want it to be the case that the foo thread runs first

    //while(!t.finished); //spin

    // try{

    //     t.join();// This BLOCKS execution until the threat t finishes 
        
    // }catch(Exception e){}
    
    printSlow(s, "");

    //how do I learn which thread finnished first?

    if(t.isAlive()){
        try{t.join();}catch(Exception e){};
        System.out.println("Main thread finished first");
    }else{
        System.out.println("Foo thread finished first");
    }
  }
}

