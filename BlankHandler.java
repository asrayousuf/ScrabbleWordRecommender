import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class BlankHandler {
	
	private static final String BLANK_TILE = "*";
	private String rackWithoutBlanks;
	private int blankCount;
	static final int SCORE_OF_LETTERS[] = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
	static final int A_ASCII = 97;
	
	public BlankHandler(String rack) {
		this.blankCount = rack.length() - rack.replace(BLANK_TILE, "").length();
		this.rackWithoutBlanks = rack_with_blanks.replace(BLANK_TILE, "");
		this.rackWithoutBlanks = sortRack(this.rackWithoutBlanks);
	}
	
	public SortedMap<Integer , String> rankWordScores(Map<String, String> possibleWordsMap){
		
		SortedMap<Integer, String> scoreMap = new TreeMap<Integer, String>(Collections.reverseOrder());
		Iterator <Map.Entry<String, String>> possibleWordsIterator = possibleWordsMap.entrySet().iterator();
		String currentEntryValue = "";
		char[] currentKey;
		String[] currentValue;
		char[] rack = rackWithoutBlanks.toCharArray();
		int score = 0;
		boolean loop = true;

		while( possibleWordsIterator.hasNext() ){
			Map.Entry<String, String> possibleWordEntry = possibleWordsIterator.next();
			currentEntryValue = possibleWordEntry.getValue();
			currentValue = currentEntryValue.split(" ");
			score = Integer.parseInt(currentValue[0]) ;
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
				if(letter != BLANK_TILE)
					score -= SCORE_OF_LETTERS[ letter - A_ASCII ];
			}
			
			currentValue[0] = "";
			
			currentEntryValue = "";
			
			for(String words : currentValue){
				if( !words.equals("") )
					currentEntryValue += (words + " ");
			}
			
			scoreMap.put(score, currentEntryValue);
		}
		
		return scoreMap;
	}
	
	private String sortRack(String rack) {
        	char[] characters_in_rack = rack.toCharArray();
        	Arrays.sort(characters_in_rack);
        	return new String(characters_in_rack);
	}
    
	private int countBlankTiles() {
		return blankCount;		
	}
	
	private boolean hasBlankTiles() {
		return blankCount > 0;
	}
	
	private String getRackWithoutBlankTiles() {
		return rackWithoutBlanks;
	}
}
