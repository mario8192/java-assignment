
abstract class Bike{  
    abstract void run();  
  }  
  class Honda4 extends Bike{  
  void run(){System.out.println("running safely");}  
  public static void main(String args[]){  
   Bike obj = new Honda4();  
   obj.run();  
  }  
  }  
  //Implement own interface 
  interface Drawable{  
    void draw();  
    }   
    class Rectangle implements Drawable{  
    public void draw(){System.out.println("drawing rectangle");}  
    }  
    class Circle implements Drawable{  
    public void draw(){System.out.println("drawing circle");}  
    }    
    class TestInterface1{  
    public static void main(String args[]){  
    Drawable d=new Circle(); 
    d.draw();  
    }}  