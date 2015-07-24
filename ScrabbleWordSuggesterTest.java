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
}
