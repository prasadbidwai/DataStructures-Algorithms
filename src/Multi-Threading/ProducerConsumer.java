/*
This is a program to demonstrate thread synchronisation using wait & notify methods

*/

public class ProducerConsumer {
    public static void main(String[] args){
        Q q = new Q();
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);
    }
}

class Q
{
    int n;
    boolean flag =true;

    synchronized void put(int key){
        while(flag)
            try {
                wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        n = key;
        System.out.println("Value put is:"+key);
        flag = true;
        notify();
    }

    synchronized int get() {
        while(!flag)
            try {
                wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        flag = false;
        notify();
        return n;
    }
}

class Producer implements Runnable
{
    Q q;
    Thread t;
    int i = 0;

    public Producer(Q q)
    {
        this.q = q;
        t = new Thread(this, "Consumer Thread");
        t.start();
    }
    @Override
    public void run()
    {
        while(true){
            q.put(i++);
        }
    }
}

class Consumer implements Runnable
{
    Q q;
    Thread t;

    public Consumer(Q q){
        this.q = q;
        t = new Thread(this, "Consumer Thread");
        t.start();
    }

    @Override
    public void run() {
        while (true){
            int value = q.get();
            System.out.println("the value consumer consumed is:: "+value);
        }
    }
}




