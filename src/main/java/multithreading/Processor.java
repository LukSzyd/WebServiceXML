/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

import java.util.Scanner;

/**
 *
 * @author Lukasz
 */
public class Processor {
    public void produce() throws InterruptedException{
        synchronized(this){
            System.out.println("Wątek producenta w toku ....");
            wait();
            System.out.println("Producent przywrócony.");
        }
    }
    public void consume() throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
         synchronized(this){
            System.out.println("Czeka na wciścinie klawisza ....");
            scanner.nextLine();
            System.out.println("Klawisz naciśnięty.");
            notify();
        }
    }
}
