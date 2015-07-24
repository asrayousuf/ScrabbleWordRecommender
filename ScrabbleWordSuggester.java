package ScrabbleTeam3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import day5.SortByValue;


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

	private void buildDictionary() throws IOException {
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(FILE_PATH));
			String nextWord;
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

	public  int calculateScore(String word) {
		int value = 0;
		for ( char c : word.toCharArray() ) {
			value += SCORE_OF_LETTERS[c - CHARACTER_A];
		}
		return value;
	}

	void sortDictionaryDescendingly() {
		Collections.sort(dictionary);
	}

	ArrayList<String> findPossibleWords(String rack, int numOfBlanks) {
		HashMap<String, String> dictionary = new HashMap<String, String>();
		ArrayList<String> listOfPossibleWords = new ArrayList<String>();
		for (Map.Entry<String, String> entry : dictionary.entrySet()) {
			String sortedWord = entry.getKey();
			String listOfWordsWithScore = entry.getValue();
			if (ifWordMatches(sortedWord, rack, numOfBlanks)) {
				addWordsToList(listOfPossibleWords, listOfWordsWithScore);
			}
		}
		return listOfPossibleWords;
	}

	void addWordsToList(ArrayList<String> listOfPossibleWords, String listOfWordsWithScore) {
		String words[] = listOfWordsWithScore.split(" ");
		for (int i = 0; i < words.length; i++) {
			listOfPossibleWords.add(words[i]);
		}
	}

	boolean ifWordMatches(String word, String rack, int numOfBlanks) {
		List<Character> characterListofWord = new LinkedList<Character>();
		for (char c : word.toCharArray()) {
			characterListofWord.add(c);
		}
		for (char c : rack.toCharArray()) {
			characterListofWord.remove(new Character(c));
		}
		return (characterListofWord.size() == numOfBlanks);
	}
	public HashMap<String, String> getSortedList() {
		SortByScore sortObj= new SortByScore(dictionary);
		HashMap<String,String> sorted_map = new HashMap <String,String>();
		sorted_map.putAll(dictionary);
		return sorted_map;
	}
}
