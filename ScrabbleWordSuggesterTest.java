package ScrabbleTeam3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ScrabbleWordSuggestorTest {

	@Test
	public void calculateScoreTest() {
		assertEquals("7",ScrabbleWordSuggester.calculateScore("HOUR"));
	}

	@Test
	public void getWordSortedByCharacterTest() {
		assertEquals("ABCD",ScrabbleWordSuggester.getWordSortedByCharacter("DCBA"));
	}

	@Test
	public void ifWordMatchesTestWithOutBlanks(){
		assertTrue(ScrabbleWordSuggester.ifWordMatches("HOUR","OURSH",0));
	}

	@Test
	public void ifWordMatchesTestWithBlanks(){
		assertTrue(ScrabbleWordSuggester.ifWordMatches("HOUR","OUR ",0));
	}
	
	@Test
	public void testGetSortedList() throws IOException {
		ScrabbleWordSuggester scrabbleWordSuggester = new ScrabbleWordSuggester("cat");
		HashMap<String,String> dictionary=new HashMap<String,String>();
		dictionary.put("abcd", "10 bcda cdba dbac");
		dictionary.put("xyz", "5 xzy yzx");
		HashMap<String, String> sorted_list = scrabbleWordSuggester.getSortedList(dictionary);
		Map.Entry<String,String> entry=sorted_list.entrySet().iterator().next();
		 String firstKey= entry.getKey();
		 String firstValue=entry.getValue();
		assertTrue("First element should be abcd", "abcd".equals(firstKey));
	}
}
