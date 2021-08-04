/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatestlist;

import java.util.Scanner;

/**
 *
 * @author semenovaTM
 */
public class JavaTestlist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s = "";
        String usrchoice = "";
        
        while (!"0".equals(s)){

            System.out.println("Start javaTestlist");
            System.out.println("Overturning of line - Enter 1");
            System.out.println("Reversing sequens of symbols - Enter 2");
            System.out.println("Changing values with third - Enter 3");
            System.out.println("For Exit - Enter 0");
            s = scan.next();
            
            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Error of Enter");
                x = -1;
            }
            
            switch (x){
                case -1:
                    //Error
                    usrchoice = "Use digits from 0 to 9";
                    break;
                case 0:
                    //Exit
                    usrchoice = "Exit";
                    break;
                case 1:
                    //Overturning of line
                    usrchoice = "1 - Overturning of line";
                    break;
                case 2:
                    //Reversing sequens of symbols
                    usrchoice = "2 - Reversing sequens of symbols";
                    break;
                case 3:
                    //Changing values with third
                    usrchoice = "3 - Changing values with third";
                    break;
                default:
                    //Unknown value
                    usrchoice = "Unknown value";
                    break;
            }
            
            System.out.println(usrchoice);

        }
        System.out.println("Bye!");
     
    }
    
}