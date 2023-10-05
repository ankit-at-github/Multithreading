
public class ThreadTester {
    public static void main(String[] args){
        System.out.println("main is starting");

        //Instantiating thread object with object of thread1 class
//        Thread thread1 = new Thread1("thread1");
//        //thread1.setDaemon(true);
//
//        //start doesn't start immediately, it is an asynchronous method and it returns immediately
//        //When JVM is free it will call run method
//        thread1.start();

        //Thread thread = new Thread(new Thread2());
        Thread thread2 = new Thread(new Thread2(), "thread2");
        thread2.start();
        //if you start thread2 start again, it will give exception

        System.out.println("main is exiting");
    }
}
