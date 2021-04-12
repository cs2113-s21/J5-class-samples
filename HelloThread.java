import java.util.*;

public class HelloThread extends Thread{

    public String msg;
    public HelloThread(String msg){
        super();
        this.msg = msg;
    }
    
    public void run(){
        System.out.println(this.msg+" ("+HelloMain.compute(5,4)+")");
    }

}
