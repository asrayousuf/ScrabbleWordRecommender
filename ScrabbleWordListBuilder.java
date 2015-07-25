package ScrabbleTeam3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class ScrabbleWordListBuilder {
	static final int SCORE_OF_LETTERS[] = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
	static final char CHARACTER_A = 'a';
	static final String FILE_PATH = "C:\\Users\\test\\workspace\\BootCamp\\src\\ScrabbleTeam3\\sowpods.txt";
	private HashMap<String, String> wordList = new HashMap<String, String>();
	
	public ScrabbleWordListBuilder() {
		buildWordList();
	}
	
	private void buildWordList() {
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(FILE_PATH));
			String nextWord = "";
			String sortedWord = "";
			
			while ( (nextWord = fileReader.readLine()) != null ) {
				sortedWord = getWordSortedByCharacter(nextWord);
				addToWordList(sortedWord, nextWord);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
				e.printStackTrace();
		}
	}
	private void addToWordList(String sortedWord, String currentWord) {
		if ( wordList.containsKey(sortedWord) ) {
			wordList.put(sortedWord, wordList.get(sortedWord) + " " + currentWord);
		}
		else {
			int score = calculateWordScore(sortedWord);
			wordList.put(sortedWord, score + " " + currentWord);
		}
	}
	private String getWordSortedByCharacter(String in) {
		char[] chars = in.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	private int calculateWordScore(String word) {
		int value = 0;
		for ( char c : word.toCharArray() ) {
			value += SCORE_OF_LETTERS[c - CHARACTER_A];
		}
		return value;
	}
	
	public HashMap<String, String> getWordList() {
		return wordList;
	}
	

}
