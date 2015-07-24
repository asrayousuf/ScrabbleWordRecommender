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
		
		public static void main(String args[])
		{
			List<Word> listOfWords = readFile(FILE_PATH);
			listOfWords = wordSortbyScore(listOfWords);
			String rack = " c i";
			printSuggestions(findPossibleWords(listOfWords, rack));
		}
		
		static List<Word> readFile(String path)
		{
			List<Word> listOfWords = new ArrayList<Word>();
			try
			{
				Scanner sc = new Scanner(new File(path));
				while(sc.hasNext())
				{
					String word = sc.next();
					Word wordWithScore = new Word(word, calculateScore(word));
					listOfWords.add(wordWithScore);
				}	
			} 
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			return listOfWords;
		}

	}

