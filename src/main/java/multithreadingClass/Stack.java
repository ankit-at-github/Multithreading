public class Stack {
    private int[] array;
    private int stackTop;

    Object lock;

    public Stack(int capacity){
        array = new int[capacity];
        stackTop = -1;
        lock = new Object();
    }
    public boolean isEmpty(){
        return stackTop < 0;
    }
    public boolean isFull(){
        return stackTop >= array.length-1;
    }

    public synchronized boolean push(int element){
//        synchronized (this)
//        {
//            whatever you write inside the method, this block is implemented by compiler
//        }
            if(isFull()) return false;
            stackTop++;

            try{Thread.sleep(1000);} catch (Exception e) {}

            array[stackTop] = element;
            return true;
    }

    //If you want to make a peace of code inside method as synchronized block, you need to pass lock
//    public synchronized boolean push(int element){
//        synchronized (lock)
//        {
//            if(isFull()) return false;
//            stackTop++;
//
//            try{Thread.sleep(1000);} catch (Exception e) {}
//
//            array[stackTop] = element;
//            return true;
//        }
//
//    }

    public synchronized int pop(){
            if(isEmpty()) return Integer.MIN_VALUE;
            int obj = array[stackTop];
            array[stackTop] = Integer.MIN_VALUE;

            try{Thread.sleep(1000);} catch (Exception e) {}

            stackTop--;
            return obj;
    }

}
