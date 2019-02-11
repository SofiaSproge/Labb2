package part1;
import java.util.*;
import java.io.*;
public class Dictionary {
	
	private ArrayList<Word> theDictionary;
	private BufferedWriter outputWriter;

	
	
	public Dictionary() {
		theDictionary = new ArrayList<Word>();
	}
	
	public Dictionary (String inString) {
		theDictionary = new ArrayList<Word>();
		addWords(inString);
		//int counter = numberOfWords();
	
	}
	public void addWords(String inString) {
		//breaks up the value of arg in individual words
		//string seperator
		
		try {
			String[] theWords = inString.split(" +");
			for(int i=0; i < theWords.length; i++ ) {
				if(!(theWords[i].equals(""))) {
						try
						{
							Integer.parseInt(theWords[i]);
						}catch(NumberFormatException ierr) {theDictionary.add(new Word(theWords[i].trim()));}
					
				}
				
			}
		}
		catch(NullPointerException e) {}
		
		
	}
	
	public int numberOfWords() {
		return theDictionary.size();
	}
	
	public void removeDuplicates() {
		
		if(theDictionary.size()< 2)
		{
			System.out.println("No duplicates found because there is only one word");
		}
		else {
			for(int i = 0; i < (theDictionary.size()-1); i++) {
				for(int j = i+1; j < theDictionary.size(); j++) {
					if(theDictionary.get(i).getWord().equals(theDictionary.get(j).getWord())) {
						theDictionary.remove(j);
						theDictionary.get(i).increaseCounts();//changes the value of counts
						System.out.println("has been removed!");
					
					}
				}
			}
		}
		
	}
	
	public String countOccurences() {
		String result="";
		for(int N = 1; N < theDictionary.size(); N++) {
			int M = 0;
			for(int j = 0; j < theDictionary.size(); j++) {
				if(theDictionary.get(j).getCounts() == N) {
					M++;
				}
			}
			if(M!=0)
			{
			result = result + "\nThere are " + M + " words that occured " + N + "times.";	
			}
			
			
			
		}
		return result;
		
	}
	
	public void sortDictionaryByCounts() {
		int n = theDictionary.size();
		Word temp;
	
		for(int i=0; i<n; i++) {
			for(int j=i+1; j < (n-1); j++) {
				if((theDictionary.get(i).getCounts())<(theDictionary.get(j).getCounts())) {
					temp = theDictionary.get(i);
					theDictionary.set(i,theDictionary.get(j));
					theDictionary.set(j,temp);
				}
			}
		}
	}
	
	public void setFileName(String inString) {
		
		
		File myFile = new File(inString+".txt");
		
		try
		{
		outputWriter=new BufferedWriter(new FileWriter(myFile));
		//catch IOexception
		}catch(IOException ierr) {System.out.println("Catched all them IOExceptions! setFileName");}

	}
	
	public void saveFile()  {
		
		String stringToFile = toString();
		
		try {
			outputWriter.write(stringToFile);
			outputWriter.close();
		}catch(IOException ierr) {System.out.println("Catched all them IOExceptions!");}
		
	}
	
	public String toString() {
		
		//total number of words number1
		//total number of occurences number2
		
		//count counts
		String result="";
		
		int number2 = 0;
		
		System.out.println(numberOfWords());
		for(int j = 0; j < theDictionary.size(); j++) {
			number2 = number2 + theDictionary.get(j).getCounts();
		}
		
		
		result = "\nTotal words : " + numberOfWords() +" and total occurences " + number2 +"\n";
		
		//skriv ut alla ord med counts
		
		for(int i = 0; i < theDictionary.size(); i++) {
			result = result + theDictionary.get(i).toString() +"\n";
		}
	
		
		
		return result;
	}
	
}
