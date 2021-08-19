/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatestlist;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
        System.out.println("Checking on prime number - Enter 7");
        System.out.println("Checking on palindrome - Enter 8");//isPalindrome
        System.out.println("Fibonacci numbers - Enter 9");
        System.out.println("For Exit - Enter 0");        
    }

    public static void printDataIn(){
        System.out.println("Data-in: ");
    }

    public static void printDataIn(String line){
        System.out.println("Data-in: " + line);
    }
    
   public static void printDataIn(int num){
        System.out.println("Data-in: " + num);
    }

    public static void printData(String line, int num){
        System.out.println(line + num);
    }

    public static void printData(int first, int second){
        System.out.println("First value = " + first);
        System.out.println("Second value = " + second);
    }
    
    public static void printDataOut(){
        System.out.println("Data-out: ");
    }

    public static void printDataOut(String line){
        System.out.println("Data-out: " + line);
    }    
    public static String OverturningOfLine (String line){
        printDataIn(line);
        String overturnline = "";
        char[] extractfromline = line.toCharArray();        
        for (int i = extractfromline.length; i > 0; i--){
            overturnline += extractfromline[i-1];
        }
        return overturnline;
    }

    public static String ReversingSequensOfSymbols (String line, int num){
        printDataIn(line);
        printData("Quantity of symbols: ", num);
        String reversingline = "";
        char[] extractfromline = line.toCharArray();
        if (num > extractfromline.length) {
            printData("Quantity reduced to : ", extractfromline.length);
        }
        for (int i = 0; i < extractfromline.length; i = i + num){
            for (int j = num; j > 0; j--){
                try {
                reversingline += extractfromline[j+i-1];
                }catch (ArrayIndexOutOfBoundsException e){
                    num--;
                }
            }           
        }
        return reversingline;
    }
    
    public static void changingValuesWithThird(int numFirst, int numSecond){
        int tmp;
        printDataIn();
        printData(numFirst, numSecond);
        tmp = numFirst;
        numFirst = numSecond;
        numSecond = tmp;
        printDataOut();
        printData(numFirst, numSecond);
    }

    public static void changingValuesWithoutThird(int numFirst, int numSecond){
        printDataIn();
        printData(numFirst, numSecond);
        numFirst = numFirst + numSecond;
        numSecond = numFirst - numSecond;
        numFirst = numFirst - numSecond;
        printDataOut();
        printData(numFirst, numSecond);
    }
    
    public static int CountingWordsWithHashMap (String line){
        printDataIn(line);
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

    public static HashMap<String, Integer> generateIntegerValues(int quantityvalues, int maxnumber){
        HashMap<String, Integer> randomvalues = new HashMap<>();
        //if (quantityvalues > 9) quantityvalues == 9;//limit
        int number;
        Random random = new Random();
            for (int i = 0; i < quantityvalues; i++){
                number = random.nextInt(maxnumber);
                System.out.println(i + ": next number " + number);
                String strkey = "Number " + i;
                randomvalues.put(strkey, number);
            }
        return randomvalues;
    }
    
    public static void IterationObjectHashMap (HashMap<String, Integer> hashmap){
        //Map<String, Integer> wordsinline = new HashMap<>();
        System.out.println("Pairs: using FOR");
        for (Map.Entry entry : hashmap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("Pairs: using WHILE");
        Iterator it = hashmap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }
    
    public static boolean CheckingOnPrimeNumber(int number){
        int n = 1;
        int i = 2;
        boolean result = true;
        while (n !=0 & (number > i)){
            n = number % i;
            i++;
        }
        if (n == 0){
            result = false;
        }
        return result;
    }

    public static boolean CheckingOnPalindrome(String line){
        char[] extractfromline = line.toCharArray();
        ArrayList symbolsfromline = new ArrayList();
        int size = extractfromline.length;
        for (int m = 0; m < size; m++){
            if(' ' != extractfromline[m]){
                symbolsfromline.add(extractfromline[m]);
            }
        }
        //for (int j = 0; j < symbolsfromline.size(); j++){
        //    System.out.println(symbolsfromline.get(j)); 
        //}
        int k = 0;
        int i = 0;
        boolean result = false;
        size = symbolsfromline.size();
            while(i <= size/2 & symbolsfromline.get(i) == (symbolsfromline.get(size-1-i))){
                result = true;
                k++;
                i++;
            }
        if (result == true & (k == size/2 || k == size/2+1)){
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public static void FibonacciNumbers(int num){
        int last = 0;
        int current = 1;
        System.out.println("Fibonacci numbers: " + num + " numbers of sequens.");
        System.out.print(last + ", " + current + ", "); 
        for (int i = 0; i < num-2; i++){
            current = current + last;
            last = current - last;
            System.out.print(current + ", "); 
        }
        System.out.println("..");
    }

    public static String customInLine (){
        System.out.println("Let type test line!");
        Scanner scan = new Scanner(System.in);
        String str = "";
        str = scan.nextLine();
        return str;
    }

    public static int customInNumber (){
        System.out.println("Let type test number!");
        Scanner scan = new Scanner(System.in);
        int num = 1;
        
        try {
            num = Integer.parseInt(scan.next());
        } catch (NumberFormatException e) {
            System.out.println("Error of Enter: Please, Type Number");//error quantity
        }
        return num;
    }

    public static boolean useDefaultValues(){
        Scanner scan = new Scanner(System.in);
        boolean answer = true;
        String str = "";
        char c = 'y';
        //while (!"0".equals(str)){
        System.out.println("Use default values? y/n ");//(0 - for exit)
            str = scan.next();
            try {
                c = str.charAt(0);
            } catch (NumberFormatException e) {
                System.out.println("Error of Enter");
            }
        //}
        if ('n' == c){
            answer = false;
        }
        System.out.println("Default values: ");
        return answer;
    }

//choice yes/no
    public static boolean choice(String str){
        Scanner scan = new Scanner(System.in);
        boolean answer = true;
        String s = "";
        char c = 'y';
        //while (!"0".equals(str)){
        System.out.println(str);//(0 - for exit)
            s = scan.next();
            try {
                c = s.charAt(0);
            } catch (NumberFormatException e) {
                System.out.println("Error of Enter");
            }
        //}
        if ('n' == c){
            answer = false;
        }
        return answer;
    }    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        //initialization default values
        String defaultline = "Tom my catty my love.";//CatTom in flat.
        String defaultpalindrome = "some men interpret nine memos";
        boolean defaultvalues = true;
        boolean defaultchoise = true;
        int defaultnum = 3;
        int dafaultFibonacci = 10;
        String strCustom = "";
        int numCustom = 1;
        int [] arrayNum = {3, 7, 21, 9};//array of input numbers//try to use HashMap
        
        int x = 0;

        String s = "";
        String scase = "";
        String usrchoice = "";
        
        while (!"0".equals(s)){
            //consoleMenu();
            defaultchoise = choice("Show maim menu? y/n");
            if (defaultchoise == true){
            consoleMenu();
            }else{
                System.out.println("Program is over. 0 - for Exit");
            }
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
                    defaultvalues = useDefaultValues();
                    if (defaultvalues == true) {
                    String strTurn = OverturningOfLine(defaultline);
                    printDataOut(strTurn);
                    } 
                    strCustom = customInLine();
                    strCustom = OverturningOfLine(strCustom);
                    printDataOut(strCustom);
                    usrchoice = "Ending 1 - Overturning of line";
                    break;
                case 2:
                    //Reversing sequens of symbols
                    defaultvalues = useDefaultValues();
                    if (defaultvalues == true) {
                    String strReverse = ReversingSequensOfSymbols(defaultline, defaultnum);
                    printDataOut(strReverse);
                    }
                    strCustom = customInLine();
                    numCustom = customInNumber();
                    strCustom = ReversingSequensOfSymbols(strCustom, numCustom);
                    printDataOut(strCustom);
                    usrchoice = "Ending 2 - Reversing sequens of symbols";
                    break;
                case 3:
                    //Changing values with third
                    //default values
                    defaultvalues = useDefaultValues();
                    if (defaultvalues == true) {
                    changingValuesWithThird(defaultnum, defaultnum+1);
                    }
                    //user values
                    arrayNum[0] = customInNumber();
                    arrayNum[1] = customInNumber();
                    changingValuesWithThird(arrayNum[0], arrayNum[1]);    
                    usrchoice = "Ending 3 - Changing values with third";
                    break;
                case 4:
                    //Changing values without third
                    defaultvalues = useDefaultValues();
                    if (defaultvalues == true) {
                    changingValuesWithoutThird(defaultnum, defaultnum+1);
                    }
                    arrayNum[0] = customInNumber();
                    arrayNum[1] = customInNumber();
                    changingValuesWithoutThird(arrayNum[0], arrayNum[1]);
                    usrchoice = "Ending 4 - Changing values without third";
                    break;
                case 5:
                    //Counting words with HashMap
                    int allwords;
                    defaultvalues = useDefaultValues();
                    if (defaultvalues == true) {
                    allwords = CountingWordsWithHashMap(defaultline);
                    System.out.println("Quantity all words : " + allwords);
                    }
                    strCustom = customInLine();
                    allwords = CountingWordsWithHashMap(strCustom);
                    System.out.println("Quantity all words : " + allwords);
                    usrchoice = "Ending 5 - Counting words with HashMap";
                    break;
                case 6:
                    //Iteration of object HashMap
                    defaultvalues = useDefaultValues();
                    if (defaultvalues == true) {
                    HashMap<String, Integer> randomvalues = generateIntegerValues (arrayNum[1], arrayNum[2]);
                    IterationObjectHashMap ((HashMap<String, Integer>) randomvalues);
                    }
                    arrayNum[1] = customInNumber();
                    arrayNum[2] = customInNumber();
                    HashMap<String, Integer> randomvalues = generateIntegerValues (arrayNum[1], arrayNum[2]);
                    IterationObjectHashMap ((HashMap<String, Integer>) randomvalues);                    
                    usrchoice = "Ending 6 - Iteration of object HashMap";
                    break;
                case 7:
                    //Checking on prime number
                    boolean prime;
                    defaultvalues = useDefaultValues();
                    if (defaultvalues == true) {
                    prime = CheckingOnPrimeNumber(defaultnum);
                    printDataIn(defaultnum);
                    System.out.println(defaultnum + " - is prime? - " + prime);
                    }
                    numCustom = customInNumber();
                    prime = CheckingOnPrimeNumber(numCustom);
                    printDataIn(numCustom);
                    System.out.println(numCustom + " - is prime? - " + prime);
                    usrchoice = "Ending 7 - Checking on prime number";
                    break;
                case 8:
                    //Checking on palindrome
                    boolean palindrome;
                    defaultvalues = useDefaultValues();
                    if (defaultvalues == true) {
                    palindrome = CheckingOnPalindrome(defaultpalindrome);
                    printDataIn(defaultpalindrome);
                    System.out.println(defaultpalindrome + " - is palindrome? - " + palindrome);
                    }
                    strCustom = customInLine();
                    palindrome = CheckingOnPalindrome(strCustom);
                    printDataIn(strCustom);
                    System.out.println(strCustom + " - is palindrome? - " + palindrome);
                    usrchoice = "Ending 8 - Checking on palindrome";
                    break;
                case 9:
                    //Fibonacci numbers
                    defaultvalues = useDefaultValues();
                    if (defaultvalues == true) {
                    FibonacciNumbers(dafaultFibonacci);
                    }
                    numCustom = customInNumber();
                    FibonacciNumbers(numCustom);
                    usrchoice = "Ending 9 - Fibonacci numbers";
                    break;
                default:
                    //Unknown value
                    usrchoice = "Unknown value";
                    break;
            }
            strCustom = "";//сброс значений
            System.out.println(usrchoice);

        }
        System.out.println("Bye!");
     
    }
    
}