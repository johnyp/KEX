/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dödvolym;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author johny_000
 */
public class Dödvolym {
    public static boolean Volym;
    public static boolean Temp;
    public static boolean Matchar;
    public static boolean b = true;
    public static double temp1 = 99999;
    public static double temp2 = 99999;
    public static double temp3 = 99999;
    public static double temp4 = 99999;
    public static void main(String[] args) {

        String fileNameNivaer = "nivaer.csv";
        String fileNameKvitton = "kvitton.csv";
        File fileNivaer = new File(fileNameNivaer);
        File fileKvitton = new File(fileNameKvitton);
        try {
            Scanner inputStreamNivaer;
            try (Scanner inputStreamKvitton = new Scanner(fileKvitton)) {
                
                inputStreamNivaer = new Scanner(fileNivaer);
                while (inputStreamKvitton.hasNext() && inputStreamNivaer.hasNext()) {
                    
                    
                    String dataKvitton = inputStreamKvitton.nextLine();
                    String dataNivaer = inputStreamNivaer.nextLine();
                    
                    dataKvitton = dataKvitton.replaceAll(",", ".");
                    dataNivaer = dataNivaer.replaceAll(",", ".");
                    
                    String[] Kvittonvalues = dataKvitton.split(";");
                    String[] Nivaervalues = dataNivaer.split(";");
                    
                   String datumNivaer = (Nivaervalues[0]);
                   int cisternGruppNivaer = Integer.parseInt(Nivaervalues[1]);
                   String volymNivaer = (Nivaervalues[2]);
                   
                   //Gör nivå till double
                   double volymNivaerDouble = Double.parseDouble(volymNivaer);

                if(cisternGruppNivaer == 4 && volymNivaerDouble < temp4){ //&& volymnivå - x
                   
                   temp4 = volymNivaerDouble;
                   //System.out.println(datumNivaer +" Cisterngrupp: "+cisternGruppNivaer+" Lägsta volym: "+temp4 );
                }
                
                if(cisternGruppNivaer == 3 && volymNivaerDouble < temp3){
                 temp3 = volymNivaerDouble;
                 //System.out.println(datumNivaer +" Cisterngrupp: "+cisternGruppNivaer+" Lägsta volym: "+temp3 );
                }
                if(cisternGruppNivaer == 2){
                 temp2 = volymNivaerDouble;
                 //System.out.println(datumNivaer +" Cisterngrupp: "+cisternGruppNivaer+" Lägsta volym: "+temp2 );
                } 
                if(cisternGruppNivaer == 1 && volymNivaerDouble < temp1){
                 temp1 = volymNivaerDouble;
                 //System.out.println(datumNivaer +" Cisterngrupp: "+cisternGruppNivaer+" Lägsta volym: "+temp1 );
                }
                
                }
                System.out.println("Lägsta volym för cisterngrupp 4 ||" + temp4+"||");
                System.out.println("Lägsta volym för cisterngrupp 3 ||" + temp3+"||");
                System.out.println("Lägsta volym för cisterngrupp 2 ||" + temp2+"||");
                System.out.println("Lägsta volym för cisterngrupp 1 ||" + temp1+"||");
            } //ignore
            inputStreamNivaer.close();
            System.exit(0);
        } catch (FileNotFoundException e) {
        }
    }
}
