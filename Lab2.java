package part1;
import java.io.*;
public class Lab2 {
	
		static String questionToUser = "You have the following options :\n"
		+ "End : type 'end'\nLoad from file : type 'load' followed by filename\n"
		+ "Save to file : type 'save' followed by filename\nAdd another word : type the word\n"
		+ "List reduced content : type '1'\nList full content : type '2'\n"
		+ "Remove multiple occurences : type '3'\nSort : type '4'\nList occurences : type '5'\nYour choice : ";
					
		private static String inData="";
		private static String theFileName="";
		private static String aWord="";
		
	public static void main(String[] args) throws IOException {
	Dictionary myDictionary = new Dictionary();	
	
	do {
		System.out.println(questionToUser);
		
		inData = consoleInput();
		
		
		System.out.println(inData+ " Word has been added to inData");
		
		if(inData.equals("")) {
			System.out.println("Something went wrong");
		}
		
		else {
			System.out.println("Your word is: " + inData + " and has entered else, proceeding to switch");
			
			
			switch(inData){
			
				case "end":
					System.out.println("Ending Program");
					break;
				//glöm ej att lägga till IOExceptions!
				case "load": 
					System.out.println("Write the file name");
					theFileName = consoleInput();
			
					System.out.println(theFileName + " is the name you typed");
					
					File myFile = new File(theFileName+".txt");
					
				
					
					if(!(myFile.exists())) {
						
						System.out.println("No such file exists");
					}
					
					else{
						System.out.println("This file exists");
						
						FileReader myFileReader = new FileReader(myFile);
						BufferedReader myBufferedReader = new BufferedReader(myFileReader);
						
						String myString="";
						String result="";
						
						while((myString= myBufferedReader.readLine())!=null) {
							System.out.println(myString);
							result = result + myString + " ";
						}
						
						myDictionary = new Dictionary(result);
						
						myBufferedReader.close(); myFileReader.close();
						System.out.println("\n");
					}
					
					break;
					
				case "save":
					String myWord = consoleInput();
					if(!(myWord +".txt").equals("Text.txt"))
					{
						//File saveFile = new File(theFileName+".txt");
						myDictionary.setFileName(myWord);
						myDictionary.saveFile();
						System.out.println("Saved the file");

					}
					
					break;
				
				case "the word" :
					System.out.println("Type in a word");
					
					aWord = consoleInput();
					myDictionary.addWords(aWord);
					
					break;
					
				case "1":
					Word.changeOutputFormat(0);
					System.out.println(myDictionary);
					
					break;
					
				case "2":
					Word.changeOutputFormat(1);
					System.out.println(myDictionary);
					
					break;
					
				case "3":
					myDictionary.removeDuplicates();
					break;
					
				case "4":
					myDictionary.sortDictionaryByCounts();
					break;
					
					
				case "5":
					System.out.println(myDictionary.countOccurences());
					break;
					
				default:
					System.out.println("Your word entered was not accepted. catched by while and reentering do");
					
			}
			
		}
		
	}while(!(inData.equals("end")));
	
	System.out.println("ended do while loop your word is still " + inData );
	
	}
	//class method
	public static String consoleInput() throws IOException{
		
		InputStreamReader myInputStreamReader=new InputStreamReader(System.in);
		
		BufferedReader consoleReader = new BufferedReader(myInputStreamReader);
		
		String myString="";
	//	myString = consoleReader.readLine();
		
	//	System.out.println("You typed the word: " + myString);
		
		try { myString = consoleReader.readLine();}
			catch(IOException ierr) {}
		
		return myString;
	}
	
	

}
