package kravspecifikation6;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DagsavvikelseJFrame {

    JTextField start = new JTextField(10);
    JTextField stop = new JTextField(10);
    JTextField lev = new JTextField(10);
    JTextField sold = new JTextField(10);
    JButton button = new JButton();
    JLabel res = new JLabel();

    public DagsavvikelseJFrame() {
        JFrame frame = new JFrame("JFrame Example");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel startl = new JLabel("Start");
        JLabel stopl = new JLabel("Stop");
        JLabel levl = new JLabel("Leverans");
        JLabel soldl = new JLabel("sold");

        button.setText("Press me");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                calculate();
            }
        });

        panel.add(startl);
        panel.add(start);
        panel.add(stopl);
        panel.add(stop);
        panel.add(levl);
        panel.add(lev);
        panel.add(soldl);
        panel.add(sold);

        panel.add(button);
        panel.add(res);
        frame.add(panel);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    private void calculate(){
        double start = Double.parseDouble(this.start.getText());
        double stop = Double.parseDouble(this.stop.getText());
        double lev = Double.parseDouble(this.lev.getText());
        double sold = Double.parseDouble(this.sold.getText());
        
        double avvikelse = ((start - stop) + lev) - sold;
        res.setText(Double.toString(avvikelse));
        
        
    }

    public static void main(String s[]) {
        Dagsavvikelse dagsavvikelse = new Dagsavvikelse();

    }

}
