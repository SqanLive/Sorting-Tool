import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
    	String tryb = "word";
    	//sprawdz(args, tryb);
    	for (int i = 0; i < args.length ; i++) {
            if("-dataType".equals(args[i])) {
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
    	}
        
    }
    
    public static void sprawdz(String[] args, String tryb) {
    	for (int i = 0; i < args.length ; i++) {
            if("-dataType".equals(args[i])) {
            	tryb = args[i + 1];
            }         
            
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