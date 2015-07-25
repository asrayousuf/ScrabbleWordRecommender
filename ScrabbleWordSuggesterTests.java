package ScrabbleTeam3;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.TreeMap;

import org.junit.Test;

public class ScrabbleWordSuggesterTests {

	@Test
	public void testsortDescending() {
		ScrabbleWordSuggester scrabbleWordSuggester = new ScrabbleWordSuggester(null);
		HashMap<String,String> wordList=new HashMap<String,String>();
		wordList.put("xyz", "5 xzy yzx");
		wordList.put("abcd", "15 bcda cdba dbac");
		wordList.put("ghs", "12 shg hgs");
		TreeMap<String, String> sorted_list = scrabbleWordSuggester.sortDescending(wordList);
		assertTrue("First element should be abcd", "abcd".equals(sorted_list.firstKey()));
	}

}
