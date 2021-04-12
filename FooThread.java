public class FooThread extends Thread {
    private volatile String msg; //I'm going to use this variable as a
                                 //way to do messaging
    private String tab;

    //public volatile boolean finished=false;
    
    public FooThread( String t) {
        this.tab = t;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }
    
    public void run() {

        //java does an optimization for this loop
        //
        //String tmp = this.msg;
        //while(tmp == null); //leads to an infinite loop! 

        
        while(this.msg == null); //spinning
        
        PrintSlowly.printSlow(this.msg, this.tab);
        //finished=true;
    }
}
