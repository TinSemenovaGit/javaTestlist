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
    public static void changingValuesWithThird(int param_a, int param_b){
        int tmp;
        System.out.println("param_a=" + param_a);
        System.out.println("param_b=" + param_b);
        tmp = param_a;
        param_a = param_b;
        param_b = tmp;
        System.out.println("param_a=" + param_a);
        System.out.println("param_b=" + param_b);
    }
    
    public static String ReversingSequensOfSymbols (String line_l, int param_c){
        System.out.println(line_l);
        System.out.println("param_c=" + param_c);
        char[] extractfromline = line_l.toCharArray();
        String reversingline = "";
        for (int i = 0; i < extractfromline.length; i = i + param_c){
            for (int j = param_c; j > 0; j--){
                //i = j - 1;
                reversingline += extractfromline[j+i-1];
            }           
        }
        return reversingline;
    }
    
    public static String OverturningOfLine (String line_l){
        System.out.println(line_l); 
        char[] extractfromline = line_l.toCharArray();
        String overturnline = "";
        for (int i = extractfromline.length; i > 0; i--){
            overturnline += extractfromline[i-1];
        }
        return overturnline;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s = "";
        String usrchoice = "";
        
        while (!"0".equals(s)){
            System.out.println();
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
                    String strO = OverturningOfLine("No comments");
                    System.out.println(strO);                    
                    usrchoice = "Ending 1 - Overturning of line";
                    break;
                case 2:
                    //Reversing sequens of symbols
                    String strR = ReversingSequensOfSymbols("Cattom in flat.", 3);
                    System.out.println(strR);
                    usrchoice = "Ending 2 - Reversing sequens of symbols";
                    break;
                case 3:
                    //Changing values with third
                    changingValuesWithThird(3, 7);
                    usrchoice = "Ending 3 - Changing values with third";
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