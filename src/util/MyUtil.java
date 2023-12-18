/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;

/**
 *
 * @author Nhatthang
 */
public class MyUtil {
    private static Scanner sc = new Scanner(System.in);
    
    public static String inputAString(String mess) {
        System.out.print(mess);
        return sc.nextLine();
    }
    
    public static boolean selectYesNo(String mess, String err, String yes, String no) {
        do {
            String selection = inputAString(mess);
            if (selection.equals(yes)) {
                return true;
            } else if (selection.equals(no)) {
                return false;
            } else {
                System.err.println(err + "\n");
                continue;
            }
        } while(true);
    }
    
    public static double inputADouble(String mess, String err, double low) {
        do {
            try {
                double x = Double.parseDouble(inputAString(mess));
                if (x < low) {
                    throw new NumberFormatException();
                }
                return x;
            } catch(NumberFormatException e) {
                System.err.println(err);
            }
        } while(true);
    }
    
    public static int inputAnInteger(String mess, String err, int low, int up) {
        do {
            try {
                int x = Integer.parseInt(inputAString(mess));
                if (x < low  || x > up) {
                    throw new NumberFormatException();
                }
                return x;
            } catch(NumberFormatException e) {
                System.err.println(err);
            }
        } while(true);
    }
    
    public static int inputAnInteger(String mess, String err, int low) {
        do {
            try {
                int x = Integer.parseInt(inputAString(mess));
                if (x < low) {
                    throw new NumberFormatException();
                }
                return x;
            } catch(NumberFormatException e) {
                System.err.println(err);
            }
        } while(true);
    }
}
