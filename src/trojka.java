import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class trojka {
    public static void main(final String[] args) {
    	String tryb = "word";
    	//sprawdz(args, tryb);
    	for (int i = 0; i < args.length ; i++) {
            if("-sortIntegers".equals(args[i])) {
            	tryb = "int";
            	break;
            }
            else if("-dataType".equals(args[i])) {
            	tryb = args[i + 1];
            }
            
    	}
    	
    	switch(tryb){
    		case "long":
    			longer();
    			break;
    		case "line":
    			liner();
    			break;
    		case "word":
    			worder();
    			break;
    		case "int":
    			inter();
    	}
        
    }
    
    public static void sprawdz(String[] args, String tryb) {
    	for (int i = 0; i < args.length ; i++) {
            if("-dataType".equals(args[i])) {
            	tryb = args[i + 1];
            }         
            
    	}
    
    }
    
    public static void inter() {
    	ArrayList<Long> list = new ArrayList<>();
    	Scanner scanner = new Scanner(System.in);
    	int ilosc =0;
    	
    	while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            ilosc++;
            list.add(number);  
        }
    	Collections.sort(list);
    	System.out.println("Total numbers: " + ilosc + "." );
    	System.out.print("Sorted data: ");
    	for(int i =0; i < ilosc; i++) {
    		System.out.print(list.get(i) + " ");
    	}
    	

    }
    
    
    public static void longer() {
    	Scanner scanner = new Scanner(System.in);
        int ilosc =0;
        long max =0;
        int count = 1;
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            ilosc++;
            if(number > max){
                max = number;
                count = 1;
            }
            else if (number == max){
                count++;
            }
        }
        int procent = 0;
    	procent = count / ilosc;
        System.out.println("Total numbers: " + ilosc + "." );
        System.out.println("The greatest number: " + max + " (" + count + " times(s), " + procent + "%).");
    }
    
    public static void worder() {
    	Scanner scanner = new Scanner(System.in);
    	int ilosc =0;
    	int dlugosc =0;
    	int count =1;
    	String najdluzszy = new String();
    	while (scanner.hasNext()) {
            String word = scanner.next();
            ilosc++;
            if(word.length() > dlugosc) {
            	dlugosc = word.length();
            	count =1;
            	najdluzszy = word;
            }
            else if(najdluzszy == word) {
            	count++;
            }
        }
    	int procent = 0;
    	procent = count / ilosc;
    	System.out.println("Total words: " + ilosc + "." );
        System.out.println("The longest word: " + najdluzszy + " (" + count + " times(s), " + procent + "%).");
    }
    
    public static void liner() {
    	Scanner scanner = new Scanner(System.in);
    	int ilosc =0;
    	int dlugosc =0;
    	int count =1;
    	String najdluzszy = new String();
    	while (scanner.hasNextLine()) {
            String linia = scanner.nextLine();
            ilosc++;
            if(linia.length() > dlugosc) {
            	dlugosc = linia.length();
            	count =1;
            	najdluzszy = linia;
            }
            else if(najdluzszy == linia) {
            	count++;
            }
        }
    	int procent = 0;
    	procent = count / ilosc;
    	System.out.println("Total lines: " + ilosc + "." );
        System.out.println("The longest line: ");
        System.out.println(najdluzszy);
        System.out.println("(" + count + " time(s), " + procent + "%).");
    }
    
    
}