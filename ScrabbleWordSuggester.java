package ScrabbleTeam3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


	public class ScrabbleWordSuggester
{
	static final int SCORE_OF_LETTERS[] = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
	static final char CHARACTER_A = 'A';
	static final String FILE_PATH = "C:\\Users\\test\\workspace\\BootCamp\\src\\ScrabbleTeam3\\sowpods.txt";
	static HashMap<String, String> dictionary;
	String rack;
	ScrabbleWordSuggester(String rack) {
		dictionary = new HashMap<String, String>();
		buildDictionary();
		sortDictionaryDescendingly();
		this.rack = rack;
	}

	public static void main(String args[]) throws IOException
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter String");
		ScrabbleWordSuggester scrabbleWordSuggester = new ScrabbleWordSuggester(scanner.nextLine());
		System.out.println("Do you wish to consider any constraints: Y/N");
		String answer= scanner.nextLine();
		String constraint;
				if(answer.equalsIgnoreCase("Y")){
					System.out.println("Enter your constraint");
					constraint=scanner.nextLine();
				}
		
		System.out.println("Enter number of suggested words to be returned");
		int NUMBER_OF_SUGGESTIONS_NEEDED=scanner.nextInt();
		
		printSuggestions(findPossibleWords(dictionary, rack));
	}

	private void buildDictionary() {
		try {
			BufferedReader fileReader = new BufferedReader(new fileReader(FILE_PATH));
			String sortedWordd = "";
			while ( (nextWord = fileReader.readLine()) != null ) {
				sortedWord = getWordSortedByCharacter(nextWord);
				addtoDictionary(sortedWord, nextWord);
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String getWordSortedByCharacter(String in) {
		char[] chars = in.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	private static void addtoDictionary(String sortedWord, String currentWord) {
		if ( dictionary.containsKey(sortedWord) ) {
			dictionary.put(sortedWord, dictionary.get(sortedWord) + " " + currentWord);
		} 
		else {
			int score = calculateScore(sortedWord);
			dictionary.put(sortedWord, score + " " + currentWord);
		}
	}

	public int calculateScore(String word) {
		int value = 0;
		for ( char c : word.toCharArray() ) {
			value += SCORE_OF_LETTERS[c - CHARACTER_A];
		}
		return value;
	}

	void sortDictionaryDescendingly() {
		Collections.sort(dictionary);
	}
}
