public class HelloMain{
    
    public static int compute(int x, int y){ return x*y;}
    
    public static void main(String args[]){
        
        HelloThread th = new HelloThread("Hello, World!");
        th.start();

        System.out.println("Goodbye, World! ("+compute(10,12)+") "
            + "and the threaded print '"+th.msg+"'");
        
    }

}
