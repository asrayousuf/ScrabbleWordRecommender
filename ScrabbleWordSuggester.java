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
	static final String FILE_PATH = "C:\\Users\\test\\workspace\\BootCamp\\src\\ScrabbleTeam3\\sowpods.txt";
	static ArrayList<Word> dictionary;
	String rack;
	ScrabbleWordSuggester(String rack)
	{
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

	private void buildDictionary()
	{
		dictionary = new ArrayList<Word>();
		try {
			Scanner sc = new Scanner(new File(FILE_PATH));
			while ( sc.hasNext() ) {
				String word = sc.next();
				Word wordWithScore = new Word(word, calculateScore(word));
				dictionary.add(wordWithScore);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int calculateScore(String word) {
		int value = 0;
		for (int i = 0; i < word.length(); i++ )
		{
			char c = word.charAt(i);
			value += SCORE_OF_LETTERS[c-'A'];
		}
		return value;
	}

	void sortDictionaryDescendingly() {
		Collections.sort(dictionary);
	}

}
