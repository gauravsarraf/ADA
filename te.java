import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.locks.*;

public class te
{
    public static void main(String[] args)
            throws InterruptedException
    {

        final PC pc = new PC();
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    pc.pr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    pc.co();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

            t1.start();
            t2.start();
            t1.join();
            t2.join();
    }

    public static class PC
    {
        Lock lock = new ReentrantLock();
        int[] p = new int[5];
        Random random = new Random();
        boolean locked =  false;

        // Function called by producer thread
        public void pr() throws InterruptedException {
            while (true) {
                synchronized (this)
                {
                    System.out.print("Generating Stock Prices at " +java.time.LocalDateTime.now());
                    lock.lock();
                    locked = true;
                    for (int i = 0; i < 5; i++)
                        p[i] = random.nextInt(100);
                    System.out.println("   <<<<Reliance:"+p[0]+" ICICI:"+p[1]+" TCS:"+p[2]+" BankOfBarodra:"+p[3]+" Cipla:"+p[4]);
                    locked = false;
                    lock.unlock();

                    notify();
                    Thread.sleep(100);
                }
            }
        }

        // Function called by consumer thread
        public void co() throws InterruptedException
        {
            while(true) {
                synchronized (this) {
                    int T = random.nextInt(40) + 80;
                    wait(T);
                    System.out.println("waited for " + T);
                    if(locked)
                        System.out.println("locked...");
                    else
                    {
                        System.out.print("Consuming Stock Prices at " + LocalDateTime.now());
                        System.out.println("    >>>>Reliance:" + p[0] + " ICICI:" + p[1] + " TCS:" + p[2] + " BankOfBarodra:" + p[3] + " Cipla:" + p[4]);
                    }
                    notify();
                }
            }
        }
    }
}
