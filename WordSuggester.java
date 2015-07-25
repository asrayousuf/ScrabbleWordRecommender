package ScrabbleTeam3;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordSuggester {
	static final String WORDS_SEPERATOR = ", ";
	private PossibleWordsGenerator possibleWordsGenerator;
	public WordSuggester(PossibleWordsGenerator gen) {
		this.possibleWordsGenerator = gen;
	}

	public void requestUserInteraction() {
		Scanner scanner = new Scanner(System.in);
		boolean nextSequence = false;
		do {
			System.out.println("Enter Tiles: ");
			String rack = scanner.nextLine().trim();
			System.out
					.println("Do you wish to consider any constraints? (y/n) ");
			String constraint = "";
			if (scanner.nextLine().equalsIgnoreCase("Y")) {
				System.out.println("Enter your constraint: ");
				constraint = scanner.nextLine();
			}
			System.out
					.println("Enter number of suggested words to be returned: ");
			int required_suggestions = scanner.nextInt();
			
			HashMap<String, String> possibleWords = possibleWordsGenerator
					.findPossibleWordsWithConstraints(rack, constraint);
			
			printSuggestedWords(sortDescending(possibleWords), required_suggestions);

			System.out
					.println("Do you wish to search for another word? (y/n) ");
			if (scanner.nextLine().equalsIgnoreCase("Y")) {
				nextSequence = true;
			}
		} while (nextSequence);
	}

	public void printSuggestedWords(TreeMap<String, String> words, int numberOfSuggestions) {

		for (Map.Entry<String, String> entry : words.entrySet()) {
			if(numberOfSuggestions-- == 0)
				break;
			String score = entry.getValue().substring(0,
					entry.getValue().indexOf(" "));
			String word = entry.getValue()
					.substring(entry.getValue().indexOf(" "))
					.replaceAll(" ", WORDS_SEPERATOR);
			System.out
					.println(score + " - " + word.substring(2, word.length()));
		}
	}

	private TreeMap<String, String> sortDescending(
			HashMap<String, String> wordList) {
		SortByScore sortObj = new SortByScore(wordList);
		TreeMap<String, String> sorted_map = new TreeMap<String, String>();
		sorted_map.putAll(wordList);
		return sorted_map;
	}

	public static void main(String args[]) throws IOException {
		PossibleWordsGenerator wordsGenerator = new PossibleWordsGenerator();
		WordSuggester wordSuggester = new WordSuggester(wordsGenerator);
		wordSuggester.requestUserInteraction();
	}
}
