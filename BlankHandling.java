import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.List;
import java.util.ArrayList;

class BlankHandling {
	
	private static final String BLANK_TILE = "*";
	private String rackWithoutBlanks;
	
	public BlankHandling() {
		rackWithoutBlanks = "";
	}

	private Set<String> addBlankHelper(String word, int spaceCount){
	
		Set<String> formedWordsList = new TreeSet<String>();
		return addBlank(formedWordsList, word, spaceCount);
	
	}
	
	private Set<String> addBlank(Set<String> formedWordsList, String word, int spaceCount){
		
		if(spaceCount == 0){
			formedWordsList.add(word);
		}
		else
		{
			int index = 0;
			for(char i= 'a'; i <= 'z'; i++){
				if(index < word.length()){
					if(word.charAt(index) <= i){
						index++;
					}
				}
				String newWord = word.substring(0, index) + i + word.substring(index, word.length());
				formedWordsList.add(newWord);
				formedWordsList = addBlank(formedWordsList, newWord, spaceCount-1);
			}
		}
		
		return formedWordsList;
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
		return rackWithoutBlanks;
	}
}
