/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Lukasz
 */
public class App {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue(5);
    final static Processor processor = new Processor();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException ex) {
                    
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException ex) {
                    
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
    
    
    private static void producer() throws InterruptedException{
        Random random = new Random();
        while(true){
            queue.put(random.nextInt(100));
        }           
    }
    
    private static void consumer() throws InterruptedException{
        Random random = new Random();
        while(true){
            Thread.sleep(100);
            int a = random.nextInt(10);
            if(a == 0){
                Integer value = queue.take();
                System.out.println(a);
                System.out.println("Zabrana wartość: " + value + "; Queue size is: " + queue.size());
            }
        }
    }
}
