class fetchData extends Thread{  
    public void run(){ 
        try{
            // long startTime = System.currentTimeMillis() ;
            Thread.sleep(500);
            long endTime = System.currentTimeMillis();
            System.out.println("fd "+(endTime - Main.startTime)+"ms");
        }
        catch(InterruptedException e){
            System.out.println(e);
        }  
    System.out.println("fetchData executed\n"); 
    }  
}
    
class processData implements Runnable{  
    public void run(){ 
        try{
            // long startTime = System.currentTimeMillis();
            Thread.sleep(500);
            long endTime = System.currentTimeMillis();
            System.out.println("pd "+(endTime - Main.startTime)+"ms");
        }
        catch(InterruptedException e){
            System.out.println(e);     
        }  
    System.out.println("processData executed\n"); 
    }  
}
    
public class Main {
    static long startTime = System.currentTimeMillis();
    
    public static void main(String args[]){  
        fetchData f1 = new fetchData();
        processData p1 = new processData();
        
        Thread t2 =new Thread(p1); 
        t2.setPriority(Thread.MIN_PRIORITY);  
        f1.setPriority(Thread.MAX_PRIORITY);  
        
        try {
            f1.start();
            f1.join();
            t2.start();
        } catch(InterruptedException e) {
             System.out.println(e);    
        }
    }  
}