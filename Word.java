package part1;

public class Word {
	
	private String theWord;
	private int counts;
	private static int outputFormat;
	
	//create constructor
	public Word(String inWord)
	{
		theWord = inWord;
		counts = 1;
		outputFormat = 0;
		
	}
	
	public String getWord() {
		return theWord;
	}
	
	public int getCounts() {
		return counts;
	}
	
	public void increaseCounts() {
		counts += 1;
	}
	public static void changeOutputFormat(int inInt) {
		outputFormat = inInt;
	}
	
	public String toString() {
		String result ="";
		if(outputFormat == 0) {
			result ="The word is: " + theWord;
		}
		else if (outputFormat == 1) {
			result ="The word "+ theWord + " has occured "+ counts + " times.";
		}
		return result;
	}
	
	
}
