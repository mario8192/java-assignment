class EncapsulationDemo{
    private int ssn;
    private String empName;
    private int empAge;

    public int getEmpSSN(){
        return ssn;
    }

    public String getEmpName(){
        return empName;
    }

    public int getEmpAge(){
        return empAge;
    }

    public void setEmpAge(int newValue){
        empAge = newValue;
    }

    public void setEmpName(String newValue){
        empName = newValue;
    }

    public void setEmpSSN(int newValue){
        ssn = newValue;
    }
}
public class EncapsTest{
    public static void main(String args[]){
         EncapsulationDemo obj = new EncapsulationDemo();
         obj.setEmpName("Mario");
         obj.setEmpAge(32);
         obj.setEmpSSN(112233);
         System.out.println("Employee Name: " + obj.getEmpName());
         System.out.println("Employee SSN: " + obj.getEmpSSN());
         System.out.println("Employee Age: " + obj.getEmpAge());
    } 
}

//Q3
class fetchData extends Thread{  
    public void run(){ 
    try{
        Thread.sleep(500);
    }
    catch(InterruptedException e){
        System.out.println(e);
        
    }  
        System.out.println("fetchData is running"); 
    }  
    public static void main(String args[]){  
    fetchData t1=new fetchData();  
    t1.start();  
     }  
    }
    
     class processData implements Runnable{  
    public void run(){ 
    try{
        Thread.sleep(500);
    }
    catch(InterruptedException e){
        System.out.println(e);
        
    }  
        System.out.println("processData is running"); 
    }  
    public static void main(String args[]){  
    processData p1=new processData();  
    Thread t1 =new Thread(p1);  
    t1.start();  
     }  
    }
    
    public class result {
        public static void main(String args[]){  
        fetchData f1 = new fetchData();
        processData p1 = new processData();
        Thread t2 =new Thread(p1); 
        t2.setPriority(Thread.MIN_PRIORITY);  
        f1.setPriority(Thread.MAX_PRIORITY);  
        f1.start();
        t2.start();
       
     }  
    }