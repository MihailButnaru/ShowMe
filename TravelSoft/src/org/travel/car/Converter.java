package org.travel.car;

import java.util.Scanner;

/**
 *
 * @author MIHAIL BUTNARU
 */
public class Converter {
//    public static void main(String [] args){
//        System.out.println("Test");
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        Converter test1 = new Converter();
//        System.out.println(test1.convertMPGToLitres(n));
//        
//    }
    
    public double convertMPGToLitres(int m){
        double[] list  = {9.0, 9.0, 9.0, 9.0, 70.62, 56.50, 47.08, 40.35, 35.31, 31.39, 28.25, 25.68, 23.54, 21.73, 20.18, 18.83, 17.66, 16.62, 15.69, 14.87, 14.12, 13.45, 12.84, 12.28, 11.77, 11.30, 10.86, 10.46, 10.09, 9.74, 9.42, 9.11, 8.83, 8.56, 8.31, 8.07, 7.85, 7.63, 7.43, 7.24, 7.06, 6.89, 6.73, 6.57, 6.42, 6.28, 6.14, 6.01, 5.89, 5.76, 5.65, 5.54, 5.43, 5.33, 5.23, 5.14, 5.04, 4.96, 4.87, 4.79, 4.71, 4.63, 4.56, 4.48, 4.41, 4.35, 4.28, 4.22, 4.15, 4.09, 4.04};
        for(int i = 4; i <= list.length; i++){
            if(i == m){
                return list[i];
            }
        }
        return list[0]; 
    }
}
