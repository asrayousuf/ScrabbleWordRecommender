package ScrabbleTeam3;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class ScrabbleWordSuggestorTest {

	@Test
	public void calculateScoreTest() throws IOException {
		assertEquals("7",ScrabbleWordSuggester.calculateScore("HOUR"));
	}

}
