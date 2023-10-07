
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
//        Thread thread2 = new Thread(new Thread2(), "thread2");
//        thread2.start();
        //if you start thread2 start again, it will give exception

        //Using Lambda Expression, no need to implement interface and override method, compiler wll
        //take care of boilerplate code
//        Thread thread2 = new Thread(() ->
//        {
//            for(int i=5; i<10; i++)
//                System.out.println(Thread.currentThread() + " " + i);
//        }, "thread2");


        //Stack Example
//        Stack stack = new Stack(5);
//
//        //Created two thread, 1) Trying to push 10 times, 2) Trying to pop 10 times in the same stack
//
//        new Thread(() -> {
//            int counter = 0;
//            while(counter++ < 10)
//                System.out.println("Pushed: "+stack.push(100));
//        }, "Pusher").start();
//
//        new Thread(() -> {
//            int counter = 0;
//            while(counter++ < 10)
//                System.out.println("Popped: "+stack.pop());
//        }, "Popper").start();
//


//------------------------------------------------------------------------------------------------------------------
//    Thread thread3 = new Thread(() -> {
//        try {
//            Thread.sleep(1);
//            for(int i=10000; i>0; i--);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }, "States");
//
//    thread3.start();
//
//    while(true)
//    {
//        Thread.State state = thread3.getState();
//        System.out.println(state);
//        if(state == Thread.State.TERMINATED) break;
//    }
//
//-----------------------Thread joining concept-------------------------------------------------------------------------------------------

//        Thread thread = new Thread(() -> {
//            System.out.println(Thread.currentThread());
//        }, "Our Thread");
//        thread.start();
//
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//
//        //Checkint thread priority
//        System.out.println(thread.getPriority());

//-----------------------Deadlock-------------------------------------------------------------------------------------------
        String lock1 = "ankit";
        String lock2 = "kumar";

        Thread thread1 = new Thread(() -> {
            synchronized (lock1){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //This is possible that you need more than 1 lock to access critical section
                synchronized (lock2){
                    System.out.println("lock acquired");
                }
            }
        }, "thread1");
        Thread thread2 = new Thread(() -> {
            //Reverse lock order, creating deadlock situation
            synchronized (lock2){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //This is possible that you need more than 1 lock to access critical section
                synchronized (lock1){
                    System.out.println("lock acquired");
                }
            }
        }, "thread2");

        thread1.start();
        thread2.start();

//        System.out.println("main is exiting");
    }
}
