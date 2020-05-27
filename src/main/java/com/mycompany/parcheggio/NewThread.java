package com.mycompany.parcheggio;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stei2
 */
public class NewThread extends Thread{
    static Semaphore parcheggio = new Semaphore(10);
    
    @Override
    public void run(){
        System.out.println(this.getName() + " in cerca di parcheggio");
        try {
            sleep((int)(Math.random() * 20000));
        } catch (InterruptedException ex) {
            Logger.getLogger(NewThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            parcheggio.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(NewThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(this.getName() + " ha parcheggiato, posti liberi rimasti: "+parcheggio.availablePermits());
        try {
            sleep((int)(Math.random() * 40000));
        } catch (InterruptedException ex) {
            Logger.getLogger(NewThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        parcheggio.release();
        System.out.println("\n"+this.getName() + " uscito, nuovi posti liberi: "+parcheggio.availablePermits()+"\n");
    }
    
    public NewThread(String nome){
        super(nome);
    }
}
