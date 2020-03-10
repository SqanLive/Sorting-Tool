import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class czworka {

	public static void main(final String[] args) {
    	String tryb = "long";
    	String sort = "natural";
    	for (int i = 0; i < args.length ; i++) {
    		if("-sortingType".equals(args[i])) {
                try {
                    sort = args[i + 1];
                } catch( Exception e){
                    System.out.println("No sorting type defined!");
                }

            }
            else if("-dataType".equals(args[i])) {
                try {
                    tryb = args[i + 1];
                } catch( Exception e){
                    System.out.println("No data type defined!");
                }
            }
            else if(!args[i].matches("-sortingType|-dataType|long|line|word|natural|byCount") ){
                System.out.println(args[i] + " isn't a valid parameter. It's skipped.");
            }
            
    	}
    	
    	
    	
    out:switch(tryb){
    		case "long":
    			switch(sort) {
	    			case "natural":
	    			long_natural();
	    			break out;
	    			case "byCount":
	    			long_byCount();
	    			break out;
	    			}
    		case "line":
    			switch(sort) {
    			case "natural":
    			line_natural();
    			break out;
    			case "byCount":
    			line_byCount();
    			break out;
    			}
    		case "word":
    			switch(sort) {
    			case "natural":
    			word_natural();
    			break out;
    			case "byCount":
    			word_byCount();
    			break out;
    			}
    	}
    	
    	
        
    }
/*-------------------------------------------------------LONG--------------------------------------------------------------------------*/
	public static void long_natural() {
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
	 
    
    public static void long_byCount() {
    	ArrayList<Integer> input = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            input.add(number);
        }
		ArrayList<Integer> count = new ArrayList<>();
        int ilosc =1;
        int wielkosc = input.size();
        Collections.sort(input);
        iteracja(ilosc, input, count);
        wypisz(wielkosc, ilosc, input, count);
    }
    
    public static void iteracja(int ilosc, ArrayList<Integer> input, ArrayList<Integer> count ) {
		
    	outer:	for(int i = count.size(); i <= input.size()- 1 ; i++) {
    	        if(i < input.size()-1) {
    	        	//System.out.println(input.get(i) - input.get(i+1));
    				if( input.get(i) - input.get(i+1) == 0) {
    					ilosc++;
    					input.remove(i);
    					iteracja(ilosc, input, count);
    					break;
    				}
    				else {
    					count.add(ilosc);
    					ilosc = 1;
    				}
    	        }
    	        else {
    	        	count.add(ilosc);
    	        	break outer;
    	        }
    	        
    		}
    	
    	}
    	
    public static void wypisz(int wielkosc, int ilosc, ArrayList<Integer> input, ArrayList<Integer> count ) {
    	Map<Integer, Integer> mapa = new TreeMap<>();
    	for(int i = 0; i < input.size(); i++) {
    		int A = count.get(i);
    		int B = input.get(i);
    		mapa.put(B, A);
    	}
    	
    	Map<Integer, Integer> sortedMap = mapa.entrySet().stream().sorted(Entry.comparingByValue()).collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    	System.out.println("Total numbers: " + wielkosc + ".");
    	
    	for(Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
    		System.out.println(entry.getKey() + ": " + entry.getValue()+ " time(s), " + (entry.getValue()*100/wielkosc) + "%");
    	}
    		
    }
    /*-----------------------------------------------------------WORD---------------------------------------------------------------------*/  
   
    public static void word_natural() {
    	Scanner scanner = new Scanner(System.in);
    	int ilosc =0;
    	ArrayList<String> input = new ArrayList<String>();
    	while (scanner.hasNext()) {
            input.add(scanner.next());
            ilosc++;
        }
    	input.sort(Comparator.naturalOrder());
    	
    	System.out.println("Total words: " + ilosc);
    	System.out.println("Sorted data: ");
    	for(int i =0; i < input.size(); i++) {
    		System.out.print(input.get(i) + " ");
    	}
    	
        
    }
    
    public static void word_byCount() {
    	ArrayList<String> input = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNext()) {
            String number = scanner.next();
            input.add(number);
        }
		ArrayList<Integer> count = new ArrayList<>();
        int ilosc =1;
        int wielkosc = input.size();
        Collections.sort(input);
        iteracja_word(ilosc, input, count);
        wypisz_word(wielkosc, ilosc, input, count);
	}
    
    public static void iteracja_word(int ilosc, ArrayList<String> input, ArrayList<Integer> count ) {
		
		
    	outer:	for(int i = count.size(); i <= input.size()- 1 ; i++) {
    	        if(i < input.size()-1) {
    				if( input.get(i).compareTo(input.get(i+1)) == 0) {
    					ilosc++;
    					input.remove(i);
    					iteracja_word(ilosc, input, count);
    					break;
    				}
    				else {
    					count.add(ilosc);
    					ilosc = 1;
    				}
    	        }
    	        else {
    	        	count.add(ilosc);
    	        	break outer;
    	        }
    	        
    		}
    	
    	}
    
    public static void wypisz_word(int wielkosc, int ilosc, ArrayList<String> input, ArrayList<Integer> count ) {
    	Map<String, Integer> mapa = new TreeMap<>();
    	for(int i = 0; i < input.size(); i++) {
    		int A = count.get(i);
    		String B = input.get(i);
    		mapa.put(B, A);
    	}
    	
    	Map<String, Integer> sortedMap = mapa.entrySet().stream().sorted(Entry.comparingByValue()).collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    	System.out.println("Total numbers: " + wielkosc + ".");
    	
    	for(Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
    		System.out.println(entry.getKey() + ": " + entry.getValue()+ " time(s), " + (entry.getValue()*100/wielkosc) + "%");
    	}
    		
    }
 
    /*------------------------------------------------------------LINE--------------------------------------------------------------------*/
    
    public static void line_natural() {
    	Scanner scanner = new Scanner(System.in);
    	int ilosc =0;
    	ArrayList<String> input = new ArrayList<String>();
    	while (scanner.hasNextLine()) {
    		input.add(scanner.nextLine());
            ilosc++;
        }
    	input.sort(Comparator.naturalOrder());
    	
    	System.out.println("Total lines: " + ilosc);
    	System.out.println("Sorted data: ");
    	for(int i =0; i < input.size(); i++) {
    		System.out.println(input.get(i) + " ");
    	}
    }
    
    public static void line_byCount() {
    	ArrayList<String> input = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()) {
            String number = scanner.nextLine();
            input.add(number);
        }
		ArrayList<Integer> count = new ArrayList<>();
        int ilosc =1;
        int wielkosc = input.size();
        Collections.sort(input);
        iteracja_line(ilosc, input, count);
        wypisz_line(wielkosc, ilosc, input, count);
    }
    
public static void iteracja_line(int ilosc, ArrayList<String> input, ArrayList<Integer> count ) {
		
		
    	outer:	for(int i = count.size(); i <= input.size()- 1 ; i++) {
    	        if(i < input.size()-1) {
    				if( input.get(i).compareTo(input.get(i+1)) == 0) {
    					ilosc++;
    					input.remove(i);
    					iteracja_line(ilosc, input, count);
    					break;
    				}
    				else {
    					count.add(ilosc);
    					ilosc = 1;
    				}
    	        }
    	        else {
    	        	count.add(ilosc);
    	        	break outer;
    	        }
    	        
    		}
    	
    	}
    
    public static void wypisz_line(int wielkosc, int ilosc, ArrayList<String> input, ArrayList<Integer> count ) {
    	Map<String, Integer> mapa = new TreeMap<>();
    	for(int i = 0; i < input.size(); i++) {
    		int A = count.get(i);
    		String B = input.get(i);
    		mapa.put(B, A);
    	}
    	
    	Map<String, Integer> sortedMap = mapa.entrySet().stream().sorted(Entry.comparingByValue()).collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    	System.out.println("Total numbers: " + wielkosc + ".");
    	
    	for(Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
    		System.out.println(entry.getKey() + ": " + entry.getValue()+ " time(s), " + (entry.getValue()*100/wielkosc) + "%");
    	}
    		
    }

}
