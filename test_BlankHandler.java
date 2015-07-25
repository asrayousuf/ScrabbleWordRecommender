import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class test_BlankHandler {

	String rack = "ab*";	
	BlankHandler messageUtil = new BlankHandler(rack);
	
	@Test
	public void testHasBlankTiles() {
		assertEquals(true, BlankHandler.hasBlankTiles());
	}
	
	@Test
	public void testBlankTilesCount() {
		assertEquals(1, BlankHandler.countBlankTiles());
	}
	
	@Test
	public void testGetRackWithoutBlanks() {
		assertEquals("ab", BlankHandler.getRackWithoutBlankTiles());
	}
	
	@Test
	public void testRankWordScores() {
		HashMap<String, String> input_map = new HashMap<String, String>();
		input_map.put("aab", "20 aab aba baa");
		input_map.put("abc", "23 abc acb bac bca cab cba");
		input_map.put("ab", "12 ab ba");
		
		HashMap<String, String> expected_output = new HashMap<String, String>();
		expected_output.put("aab", "19 aab aba baa");
		expected_output.put("abc", "20 abc acb bac bca cab cba");
		expected_output.put("ab", "12 ab ba");
		
		HashMap<String, String> actual_output = BlankHandler.deductBlankTileScore(input_map);
		assertEquals(expected_output, actual_output);
	}

}
