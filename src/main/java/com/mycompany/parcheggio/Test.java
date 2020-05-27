package com.mycompany.parcheggio;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stei2
 */
public class Test {
    public static void main(String[] args){
        ArrayList<NewThread>macchine=new ArrayList<>();
        
        macchine.add(new NewThread("Paolo"));
        macchine.add(new NewThread("Marco"));
        macchine.add(new NewThread("Jhonny"));
        macchine.add(new NewThread("Roberto"));
        macchine.add(new NewThread("Pietro"));
        macchine.add(new NewThread("Renzi"));
        macchine.add(new NewThread("Bestia"));
        macchine.add(new NewThread("Colzi"));
        macchine.add(new NewThread("Sho"));
        macchine.add(new NewThread("Pippo"));
        macchine.add(new NewThread("Franco"));
        macchine.add(new NewThread("Ononoki"));
        macchine.add(new NewThread("Megumin"));
        macchine.add(new NewThread("Giuseppe"));
        macchine.add(new NewThread("Kristian"));
        
        for (int i = 0; i < 15; i++) {
            macchine.get(i).start();
        }
        for (int i = 0; i < 15; i++) {
            try {
                macchine.get(i).join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
