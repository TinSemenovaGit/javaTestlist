/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatestlist;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author semenovaTM
 */
public class JavaTestlist {

    /**
     * @param args the command line arguments
     */
    public static void consoleMenu(){
        System.out.println();
        System.out.println("Start javaTestlist");
        System.out.println("Overturning of line - Enter 1");
        System.out.println("Reversing sequens of symbols - Enter 2");
        System.out.println("Changing values with third - Enter 3");
        System.out.println("Changing values without third - Enter 4");
        System.out.println("Counting words with HashMap - Enter 5");
        System.out.println("Iteration of object HashMap - Enter 6");
        System.out.println("For Exit - Enter 0");        
    }

    public static String OverturningOfLine (String line){
        System.out.println(line); 
        char[] extractfromline = line.toCharArray();
        String overturnline = "";
        for (int i = extractfromline.length; i > 0; i--){
            overturnline += extractfromline[i-1];
        }
        return overturnline;
    }

    public static String ReversingSequensOfSymbols (String line, int num){
        System.out.println(line);
        System.out.println("Amount of symbols : " + num);
        char[] extractfromline = line.toCharArray();
        String reversingline = "";
        for (int i = 0; i < extractfromline.length; i = i + num){
            for (int j = num; j > 0; j--){
                reversingline += extractfromline[j+i-1];
            }           
        }
        return reversingline;
    }
    
    public static void changingValuesWithThird(int num_a, int num_b){
        int tmp;
        System.out.println("First value = " + num_a);
        System.out.println("Second value = " + num_b);
        tmp = num_a;
        num_a = num_b;
        num_b = tmp;
        System.out.println("First value = " + num_a);
        System.out.println("Second value = " + num_b);
    }

    public static void changingValuesWithoutThird(int num_a, int num_b){
        System.out.println("First value = " + num_a);
        System.out.println("Second value = " + num_b);
        num_a = num_a + num_b;
        num_b = num_a - num_b;
        num_a = num_a - num_b;
        System.out.println("First value = " + num_a);
        System.out.println("Second value = " + num_b);
    }
    
    public static int CountingWordsWithHashMap (String line){
        Map<String, Integer> wordsinline = new HashMap<>();
        int words = 0;
        String word = "";
        char[] extractfromline = line.toCharArray();
        for (int i = 0; i < extractfromline.length; i++){
            if (' ' != extractfromline[i]){
                word += extractfromline[i];
            }
            else {
                Integer frequency = wordsinline.get(word);
                wordsinline.put(word, frequency == null ? 1 : frequency + 1);
                word = "";
            }
        }
        if (!"".equals(word)){
            Integer frequency = wordsinline.get(word);
            wordsinline.put(word, frequency == null ? 1 : frequency + 1);
        }
        for (Map.Entry entry : wordsinline.entrySet()){
            System.out.println("Word : " + entry.getKey() + " - " + entry.getValue());
            words = words + (int)entry.getValue();
        }
        System.out.println("Quantity different words : " + wordsinline.size());
        return words;
    }
    
    public static void IterationObjectHashMap (HashMap<String, Integer> hashmap){
        //Map<String, Integer> wordsinline = new HashMap<>();

        for (Map.Entry entry : hashmap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int x = 0;
        int valueone = 0;
        int valuetwo = 0;
        String s = "";
        String scase = "";
        String usrchoice = "";
        
        while (!"0".equals(s)){
            consoleMenu();
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
                    String strTurn = OverturningOfLine("No comments");
                    System.out.println(strTurn);                    
                    usrchoice = "Ending 1 - Overturning of line";
                    break;
                case 2:
                    //Reversing sequens of symbols
                    String strReverse = ReversingSequensOfSymbols("CatTom in flat.", 3);
                    System.out.println(strReverse);
                    usrchoice = "Ending 2 - Reversing sequens of symbols";
                    break;
                case 3:
                    //Changing values with third
                    System.out.println();
                    System.out.println("Default values: ");
                    changingValuesWithThird(3, 7);
                    //user values
                    System.out.println("Enter number one:");
                    scase = scan.next();
            try {
                valueone = Integer.parseInt(scase);
            } catch (NumberFormatException e) {
                System.out.println("Error : Not number");
                //break;
            }
                    System.out.println("Enter number two:");
                    scase = scan.next();
            try {
                valuetwo = Integer.parseInt(scase);
            } catch (NumberFormatException e) {
                System.out.println("Error : Enter ..");
            }                    
                changingValuesWithThird(valueone, valuetwo);    
                    usrchoice = "Ending 3 - Changing values with third";
                    break;
                case 4:
                    //Changing values without third
                    changingValuesWithoutThird(22, 10);
                    usrchoice = "Ending 4 - Changing values without third";
                    break;
                case 5:
                    //Counting words with HashMap
                    int allwords = CountingWordsWithHashMap("tom my catty my love");
                    System.out.println("Quantity all words : " + allwords);
                    usrchoice = "Ending 5 - Counting words with HashMap";
                    break;
                case 6:
                    //Iteration of object HashMap
                    Map<String, Integer> randomvalues = new HashMap<>();
                    Random random = new Random();
                    for (int i = 0; i < 6; i++){
                        int number = random.nextInt(25);
                        System.out.println(i + ": next number " + number);
                        String strkey = "Number " + i;
                        randomvalues.put(strkey, number);
                    }
                    IterationObjectHashMap ((HashMap<String, Integer>) randomvalues);
                    usrchoice = "6 - Iteration of object HashMap";
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