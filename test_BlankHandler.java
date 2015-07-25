import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class test_BlankHandler {

	String rack = "AB*";	
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
		assertEquals("AB", BlankHandler.getRackWithoutBlankTiles());
	}
	
	@Test
	public void testRankWordScores() {
		HashMap<String, String> input_map = new HashMap<String, String>();
		input_map.put("AAB", "20 AAB ABA BAA");
		input_map.put("ABC", "23 ABC ACB BAC BCA CAB CBA");
		input_map.put("AB", "12 AB BA");
		
		HashMap<String, String> expected_output = new HashMap<String, String>();
		expected_output.put("AAB", "19 AAB ABA BAA");
		expected_output.put("ABC", "20 ABC ACB BAC BCA CAB CBA");
		expected_output.put("AB", "12 AB BA");
		
		HashMap<String, String> actual_output = BlankHandler.deductBlankTileScore(input_map);
		assertEquals(expected_output, actual_output);
	}

}
