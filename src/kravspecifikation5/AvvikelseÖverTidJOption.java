/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kravspecifikation5;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class AvvikelseÖverTidJOption implements Runnable {
    
    JFrame frame = new JFrame("Beräkna dagsavvikelse");
  
    public static void main (String [] args){
    
     
        new Thread(new AvvikelseÖverTidJOption()).start();
        
      
    }

    @Override
    public void run() {
    
    JOptionPane optionPane = new JOptionPane();
    JSlider slider = getSlider(optionPane);
    optionPane.setMessage(new Object[] { "Bestäm period (veckor) ", slider });
    optionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
    optionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
    JDialog dialog = optionPane.createDialog(frame, "Tidsperiod");
    dialog.setVisible(true);
    System.out.println("Tidsperiod " + optionPane.getInputValue());   
        
        
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
    
    
      static JSlider getSlider(final JOptionPane optionPane) {
    JSlider slider = new JSlider();
    slider.setMajorTickSpacing(10);
    slider.setPaintTicks(true);
    slider.setPaintLabels(true);
    ChangeListener changeListener = new ChangeListener() {
      public void stateChanged(ChangeEvent changeEvent) {
        JSlider theSlider = (JSlider) changeEvent.getSource();
        if (!theSlider.getValueIsAdjusting()) {
          optionPane.setInputValue(new Integer(theSlider.getValue()));
        }
      }
    };
    slider.addChangeListener(changeListener);
    return slider;
  }
}


