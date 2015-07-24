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
