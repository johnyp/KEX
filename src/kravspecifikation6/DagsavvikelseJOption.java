/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kravspecifikation6;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author johny_000
 */
public class DagsavvikelseJOption implements Runnable {
    
    JFrame frame = new JFrame("Beräkna dagsavvikelse");
  
    public static void main (String [] args){
    
     
        new Thread(new DagsavvikelseJOption()).start();
        
      
    }

    @Override
    public void run() {
        
    String start = JOptionPane.showInputDialog(frame,"startvärde");
    int startint = Integer.parseInt(start);
    
    String slut = JOptionPane.showInputDialog("slutvärde");
    int slutint = Integer.parseInt(slut);

    String leverans = JOptionPane.showInputDialog("leverans");
    int leveransint = Integer.parseInt(leverans);
    
    String försäljning = JOptionPane.showInputDialog("försäljning");
    int försäljningint = Integer.parseInt(försäljning);
    

    double avvikelse = (((startint - slutint) + leveransint) - försäljningint);
    JOptionPane.showMessageDialog(null, avvikelse);
    System.exit(0);
    }
}
