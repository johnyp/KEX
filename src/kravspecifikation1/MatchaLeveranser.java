/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kravspecifikation1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author johny_000
 */
public class MatchaLeveranser {

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
                    int leveransVolymP = Integer.parseInt(Pejlvalues[6]);
                    
                    int datumH = Integer.parseInt(Hoyervalues[0]);
                    int anläggningsIDH = Integer.parseInt(Hoyervalues[1]);
                    int cisternGruppH = Integer.parseInt(Hoyervalues[2]);
                    String lagerVarukodH = (Hoyervalues[3]);
                    String startTidH = (Hoyervalues[4]);
                    String stopTidH = (Hoyervalues[5]);
                    int leveransVolymH = Integer.parseInt(Hoyervalues[6]);
                    
                    if (datumP == datumH) {
                        if (anläggningsIDP == anläggningsIDH) {
                            if (cisternGruppP == cisternGruppH) {
                                if (lagerVarukodP.equals(lagerVarukodH)) {
                                    if (startTidP.equals(startTidH)) {
                                        if (stopTidP.equals(stopTidH)) {
                                            if (leveransVolymP == leveransVolymH) {
                                                System.out.println("matchar");
                                            }
                                        }
                                    }
                                    
                                }
                            }
                        }
                    }
                    System.out.println("matchar inte");
                }
            } //ignore
            inputStreamHoyer.close();
        } catch (FileNotFoundException e) {
        }
    }
}
