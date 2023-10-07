import java.util.LinkedList;
import java.util.Queue;

//Producer-Consumer Problem
//Multiple threads are trying to push items into the queue, and multiple threads are trying to poll items from the queue.
public class BlockingQueue {
    private Queue<Integer> q;
    private int capacity;
    public BlockingQueue(int cap)
    {
        q = new LinkedList<>();
        capacity = cap;
    }

    //Lock used in synchronized is same as only 1 thread should access the piece of code at a time
    public boolean add(int item){
        //multiple threads are trying to access this queue to add items
        synchronized (q) {
            //instead of if, use while as once a thread gets access to add, for the next thread who is waiting to add
            //an item, condition will be checked again
            while (q.size() == capacity)
            {
                //do something, what should thread do if size of queue is full
                //wait to get item to be removed
                try {
                    q.wait();
                    //once notified, execution begins from here
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            q.add(item);
            //whenever this adds an item into queue, will notify all threads who are waiting to remove elements from
            //queue
            q.notifyAll();
            return true;
        }
    }
    public int remove(){
        //multiple threads are trying to remove items from queue
        synchronized (q){
            //instead of if, use while as once a thread gets access to remove, for the next thread who is waiting to
            // remove an item, condition will be checked again
            while(q.size() == 0)
            {
                //The remover thread wants to remove item from queue but there are no items in the queue, remover
                //thread can't execute this code & other threads who can add items to this queue are also blocked.
                //so this remover thread will wait for a condition -  for a thread who adds item into the queue, so that
                //this thread can remove an item.
                try {
                    q.wait();
                    //once notified, execution begins from here
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            int element = q.poll();
            q.notifyAll();
            return element;
        }
    }


}
