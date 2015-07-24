package ScrabbleTeam3;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.Writer;
	import java.util.*;


	public class ScrabbleWordSuggester
{
	static final int SCORE_OF_LETTERS[] = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
	static final int NUMBER_OF_SUGGESTIONS_NEEDED=5;
	static final String FILE_PATH = "C:\\Users\\test\\workspace\\BootCamp\\src\\ScrabbleTeam3\\sowpods.txt";
	ArrayList<Word> dictionary;
	String rack;

	ScrabbleWordSuggestor(String rack)
	{
		buildDictionary();
		sortDictionaryDescendingly();
		this.rack = rack;
	}

	public static void main(String args[])
	{
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

class Word implements Comparable<Word>
{
	String value;
	int key;
	int length;

	public Word(String value, int key)
	{
		this.value = value;
		this.key = key;
		this.length = value.length();
	}
	@Override
	public int compareTo(Word o)
	{
		if(this.key == o.key)
		{
			return (this.value.compareTo(o.value));
		}
		return o.key-this.key;
	}
}
