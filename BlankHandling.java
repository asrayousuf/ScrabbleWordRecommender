import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class BlankHandling {
	
	private static final String BLANK_TILE = "*";
	private String rackWithoutBlanks;
	static final int SCORE_OF_LETTERS[] = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
	
	public BlankHandling() {
		rackWithoutBlanks = "";
	}
	
	public HashMap<Integer , String> rankWordScores(){
		
		HashMap<Integer, String> scoreMap = new HashMap<Integer, String>();
		Iterator <Map.Entry<String, String>> possibleWordsIterator = possibleWordsMap.entrySet();
		String currentEntryValue = "";
		char[] currentKey;
		char[] rack = rackWithoutBlanks.toCharArray();
		int score = 0;
		boolean loop = true;

		while( possibleWordsIterator.hasNext() ){
			Map.Entry<String, String> possibleWordEntry = possibleWordsIterator.next();
			currentEntryValue = possibleWordEntry.getValue();
			score = Integer.parseInt( (holderString.split(" ")[0] );
			currentEntryKey = possibleWordEntry.getKey();
			currentKey = (possibleWordEntry.getKey()).toCharArray();
			
			for( char letter :  rack){
				for ( int i = 0; (loop && i < currentKey.length) ; i++ ){
					if (loop && letter == currentKey[i]){
						currentKey[i] = '*';
						loop = false;
					}
				}
				loop = true;
			}
			
			for( char letter : currentKey ){
				if(letter != '*')
					score -= SCORE_OF_LETTERS[ letter - A_ASCII ];
			}
			
			scoreMap.put(score, currentEntryValue);
		}
		
		return scoreMap;
	}
	
	private String sortRack(String rack) {
        	char[] character_in_rack = rack.toCharArray();
        	Arrays.sort(characters_in_rack);
        	return new String(characters_in_rack);
	}
    
	private int countBlankTiles(String rack_with_blanks) {
		int blankCount = rack_with_blanks.length() - rack_with_blanks.replace(BLANK_TILE, "").length();
		return blankCount;		
	}
	
	private boolean hasBlankTiles(String players_rack) {
		return players_rack.contains(BLANK_TILE);
	}
	
	private String getRackWithoutBlankTiles(String rack_with_blanks) {
		rackWithoutBlanks = rack_with_blanks.replace(BLANK_TILE, "");
		rackwithoutBlanks = sortRack(rackWithoutBlanks);
		return rackWithoutBlanks;
	}
}
