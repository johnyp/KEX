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
        public static void main(String[] args){
    
        String fileName = "anlinfo.csv";
        File file =  new File(fileName);
        try{
            try (Scanner inputStream = new Scanner(file)) {
                inputStream.next();//ignore
                int total = 0;
                int numberOfAvvikelser = 0;
                
                while(inputStream.hasNext()){
                    String data = inputStream.next();
                    String [] values = data.split(";");
                    
                    int start = Integer.parseInt(values[2]);
                    int stop = Integer.parseInt(values[3]);
                    int leverans = Integer.parseInt(values[4]);
                    int försäljning = Integer.parseInt(values[5]);
                    
                    int avvikelse = (((start-stop)+leverans) - försäljning);
                    total += avvikelse;
                    numberOfAvvikelser++;
                    System.out.println("Anläggnings ID: "+values[1]+" har avvikelsen: "+avvikelse);
                }   
                inputStream.close();
                System.out.println("Medelvärde = "+ (total / numberOfAvvikelser));
            }
        }catch(FileNotFoundException e){
        }
    }
}
