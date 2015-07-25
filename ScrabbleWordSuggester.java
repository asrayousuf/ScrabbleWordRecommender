package ScrabbleTeam3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

	public class ScrabbleWordSuggester
{
	static final int SCORE_OF_LETTERS[] = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
	static final char CHARACTER_A = 'A';
	static final char WORDS_SEPERATOR = ', ';
	static final String FILE_PATH = "C:\\Users\\test\\workspace\\BootCamp\\src\\ScrabbleTeam3\\sowpods.txt";
	
	private HashMap<String, String> dictionary;
	private BlankHandler blankHandler;
	private ConstraintHandlerService constraintHandler;
	
	ScrabbleWordSuggester() {
		dictionary = new HashMap<String, String>();
		buildDictionary();
	}

	public static void main(String args[]) throws IOException {
		ScrabbleWordSuggester scrabbleWordSuggester = new ScrabbleWordSuggester();
		scrabbleWordSuggester.requestUserInteraction();		
	}

	public void requestUserInteraction() {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter Tiles: ");
			String rack = scanner.nextLine().trim();
			int blankTiles = 0;

			System.out.println("Do you wish to consider any constraints? (y/n) ");
			String constraint = "";
			if ( scanner.nextLine().equalsIgnoreCase("Y") ) {
				System.out.println("Enter your constraint: ");
				constraint = scanner.nextLine();
			}
			System.out.println("Enter number of suggested words to be returned: ");
			int required_suggestions = scanner.nextInt();
			if ( constraint.length() > 0 ) {
				constraintHandler = new ConstraintHandlerService(rack);
				rack = constraintHandler.appendConstraintLetters(constraint);
			}
			blankHandler = new BlankHandler(rack);
			if ( blankHandler.hasBlankTiles() ) {
				blankTiles = blankHandler.countBlankTiles();
				rack = blankHandler.getRackWithoutBlankTiles();
			}

			HashMap<String, String> possibleWords = findPossibleWords(rack, blankTiles);

			if ( constraint.length > 0 ) {
				possibleWords = constraintHandler.applyPatternMatching(possibleWords)
			}

			if ( blankHandler.hasBlankTiles() ) {
				possibleWords = blankHandler.rankWordScores();
			}

			printSuggestedWords(possibleWords);

			System.out.println("Do you wish to search for another word? (y/n) ");
			boolean nextSequence = false;
			if( scanner.nextLine().equalsIgnoreCase("Y") ) {
				nextSequence = true;
			} 
		} while ( nextSequence );
	}

	private void buildDictionary() throws IOException {
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(FILE_PATH));
			String nextWord = "";
			String sortedWord = "";
			while ( (nextWord = fileReader.readLine()) != null ) {
				sortedWord = getWordSortedByCharacter(nextWord);
				addtoDictionary(sortedWord, nextWord);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private String getWordSortedByCharacter(String in) {
		char[] chars = in.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	private void addtoDictionary(String sortedWord, String currentWord) {
		if ( dictionary.containsKey(sortedWord) ) {
			dictionary.put(sortedWord, dictionary.get(sortedWord) + " " + currentWord);
		}
		else {
			int score = calculateScore(sortedWord);
			dictionary.put(sortedWord, score + " " + currentWord);
		}
	}

	private int calculateScore(String word) {
		int value = 0;
		for ( char c : word.toCharArray() ) {
			value += SCORE_OF_LETTERS[c - CHARACTER_A];
		}
		return value;
	}

	public HashMap<String, String> findPossibleWords(String rack, int blankCount) {
		HashMap<String, String> possibleWords = new HashMap<String, String>();
		for (Map.Entry<String, String> entry : dictionary.entrySet()) {
			if ( wordMatches(entry.getKey(), rack, blankCount) ) {
				possibleWords.put(entry.getKey(), entry.getValue());	
			}
		}
		return possibleWords;
	}

	private boolean wordMatches(String word, String rack, int blankCount) {
		for (char c : rack.toCharArray()) {
			word.remove(c);
		}
		return (word.size() == blankCount);
	}

	private HashMap<String, String> getSortedList() {
		SortByScore sortObj= new SortByScore(dictionary);
		HashMap<String,String> sorted_map = new HashMap <String,String>();
		sorted_map.putAll(dictionary);
		return sorted_map;
	}

	public void printSuggestedWords(HashMap<String, String> words) {
		for ( Map.Entry<String, String> entry : words.entrySet() ) {
			String score = entry.getValue().substring(0, entry.getValue().indexOf(" "));
			String words = entry.getValue().substring(entry.getValue().indexOf(" ")).replace(" ", WORDS_SEPERATOR);
			System.out.println(score + " - " + words);	
		}
	}
}
