class ticketBooking{
    boolean booked = false;
    public synchronized void book(String name){
        if(booked==false){
            System.out.println(name+" Select the Seat");
	try{
	  Thread.sleep(1000);
	}catch(Exception e){}
            System.out.println(name+" Do Payment");
	try{
	  Thread.sleep(1000);
	}catch(Exception e){}
            System.out.println(name+" Get the Ticket");
            booked=true;
        }else{
            System.out.println(name+" sorry!");
        }
    }
}
class MyThread extends Thread{
    ticketBooking tkbs;
    String names;
    MyThread(ticketBooking obj,String name){
        tkbs=obj;
        names=name;
    }
    public void run(){
        tkbs.book(names);
    }
    
}
class MultiThread{
    public static void main(String[] args){
        ticketBooking a=new ticketBooking();
        MyThread name=new MyThread(a,"Rama");
        Thread res=new Thread(name);
        res.start();
        MyThread name1=new MyThread(a,"jyothi");
        Thread res1=new Thread(name1);
        res1.start();
        
        
    }
}