package ScrabbleTeam3;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class ScrabbleWordListBuilderTest {

	@Test
	public void testcalculateWordScore() {
		ScrabbleWordListBuilder scrabbleWordListBuilder = new ScrabbleWordListBuilder();
		assertEquals("Score of b should be 7", 7, scrabbleWordListBuilder.calculateWordScore("cab"));
	}
	@Test
	public void getWordSortedByCharacterTest() throws IOException {
		ScrabbleWordListBuilder scrabbleWordListBuilder = new ScrabbleWordListBuilder();
		assertEquals("Should return abcd", "abcd", scrabbleWordListBuilder.getWordSortedByCharacter("bcad"));
	}
	

}
