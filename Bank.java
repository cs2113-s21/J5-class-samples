import java.util.*;

public class Bank{

    private double balance=1000.0;

    public synchronized void transaction(double val){

        //this line of code is not ATOMIC
        
        balance += val; //val can be negative

        //balance = balance + val
        //
        // load $r1 val      # $r1 has the value val
        // ----------------
        // load $r2 balance  # $r2 has the value of balance
        // add  $r3 $r2 r1   # add $r2 and $r1 and store result in $r3
        // store $r3 balance # store value in $r3 in balance
        // ----------------
    }

    public double getBalance(){
        return balance;
    }
    
    public static class DThread extends Thread{

        Bank b;
        public DThread(Bank b){
            this.b =b;
        }

        public void run(){
            for(int i=1;i<=10000;i++){
                b.transaction(-1*i);
            }
        }
    }

    public static class CThread extends Thread{

        Bank b;
        public CThread(Bank b){
            this.b =b;
        }

        public void run(){
            for(int i=1;i<=10000;i++){
                b.transaction(i);
            }
        }
    }

    public static void main(String args[]){
        Bank b = new Bank();
        CThread c = new CThread(b);
        DThread d = new DThread(b);

        c.start();
        d.start();

        try{
            c.join();
            d.join();
        }catch(Exception e){}

        System.out.println("Bank balance: "+b.getBalance());

    }

    
}
