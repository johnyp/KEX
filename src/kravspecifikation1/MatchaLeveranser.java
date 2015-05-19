/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author johny_000
 */
public class MatchaLeveranser {
    public static boolean Volym;
    public static boolean Temp;
    public static boolean Matchar;
    public static void main(String[] args) {

        String fileNamePejl = "pejl.csv";
        String fileNameHoyer = "hoyer.csv";
        File filePejl = new File(fileNamePejl);
        File fileHoyer = new File(fileNameHoyer);
        try {
            Scanner inputStreamHoyer;
            try (Scanner inputStreamPejl = new Scanner(filePejl)) {
               // inputStreamPejl.next();//ignore
                inputStreamHoyer = new Scanner(fileHoyer);
                //inputStreamHoyer.next();//ignore
                // int total = 0;
                //  int numberOfAvvikelser = 0;
                while (inputStreamPejl.hasNext() || inputStreamHoyer.hasNext()) {
                    
                    String dataPejl = inputStreamPejl.next();
                    String dataHoyer = inputStreamHoyer.next();
                    
                    String[] Pejlvalues = dataPejl.split(";");
                    String[] Hoyervalues = dataHoyer.split(";");
                    
                    int datumP = Integer.parseInt(Pejlvalues[0]);
                    int anläggningsIDP = Integer.parseInt(Pejlvalues[1]);
                    int cisternGruppP = Integer.parseInt(Pejlvalues[2]);
                    String lagerVarukodP = (Pejlvalues[3]);
                    String startTidP = (Pejlvalues[4]);
                    String stopTidP = (Pejlvalues[5]);
                    int StartVolymP = Integer.parseInt(Pejlvalues[6]);
                    int SlutVolymP = Integer.parseInt(Pejlvalues[7]);
                    double temperaturPstart = Double.parseDouble(Pejlvalues[8]);
                    String temperaturPslut = (Pejlvalues[9]);
                    
                    int datumH = Integer.parseInt(Hoyervalues[0]);
                    int anläggningsIDH = Integer.parseInt(Hoyervalues[1]);
                    int cisternGruppH = Integer.parseInt(Hoyervalues[2]);
                    String lagerVarukodH = (Hoyervalues[3]);
                    String startTidH = (Hoyervalues[4]);
                    String stopTidH = (Hoyervalues[5]);
                    int leveransVolymH = Integer.parseInt(Hoyervalues[6]);
                    double temperaturH = Double.parseDouble(Hoyervalues[7]);
                    
            /*        DecimalFormat formater = new DecimalFormat("#.###"); 
System.out.println(formater.format(0.1));  */
                    
                    Double a = (((StartVolymP * temperaturPstart)+(leveransVolymH*temperaturH)) / (StartVolymP+leveransVolymH));
                    System.out.println(a);
                    DecimalFormat formater = new DecimalFormat("0.0");      
                    System.out.println(formater.format(a));                 
                    //Beräkna om volymen stämmer
                    
                    if(SlutVolymP - StartVolymP == leveransVolymH ){
                    Volym = true;
                            }
                    
                    if(formater.format(a).equals(temperaturPslut)){
                    Temp = true;
                    }
                    //tempPstart + tempH = tempSlut
                    //startvolym * starttemp + leveransvolym * leveranstemp / totalvolym (startvolym+leveransvolym). 
                    
                    
                    
                    if (datumP == datumH) {
                        if (anläggningsIDP == anläggningsIDH) {
                            if (cisternGruppP == cisternGruppH) {
                                if (lagerVarukodP.equals(lagerVarukodH)) {
                                    if (startTidP.equals(startTidH)) {
                                        if (stopTidP.equals(stopTidH)) {
                                            if (Volym) {
                                                System.out.println("matchar i voylm");
                                                Matchar = true;
                                                System.exit(0);
                                            }
                                        }
                                    }
                                    
                                }
                            }
                        }
                    }
                    
                   if(Temp){
                   System.out.println("matchar i temp");
                   Matchar = true;
                   System.exit(0);
                   }
                    
                    System.out.println("matchar inte");
                }
            } //ignore
            inputStreamHoyer.close();
            System.exit(0);
        } catch (FileNotFoundException e) {
        }
    }
}
