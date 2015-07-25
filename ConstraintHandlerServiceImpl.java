package ScrabbleTeam3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ConstraintHandlerServiceImpl implements ConstraintHandlerService {
	private final String BLANK_TILE = "*";
	private final String EMPTY_STRING = "";
	
	private String tiles;
	
	public ConstraintHandlerServiceImpl(String tiles) {
		this.tiles=tiles;
	}
	
	public String appendConstraintLetters(String constraintPattern) {
		String lettersInConstraint = extractLetters(constraintPattern);
		return tiles + lettersInConstraint;
	}


	public HashMap<String, String> applyPatternMatching(HashMap<String, String> possibleWords, String constraintPattern) {
		HashMap<String, String> patternMatchedWords = new HashMap<String, String> ();
		String pattern= ConstraintToRegexConvert.convertToRegex(constraintPattern);
		
		Set<String> wordKeys = possibleWords.keySet();
		for (String key: wordKeys) {
			
			String[] wordList = (possibleWords.get(key)).split(" ");
			String inputValue = wordList[0];
			for(String wordToMatch: wordList)
			{
				if(ConstraintToRegexConverter.isMatching(wordToMatch, pattern)) {
					inputValue += " " + wordToMatch;
			}
				patternMatchedWords.put(key, inputValue);
			
			}
		}
		return patternMatchedWords;
}

	private String extractLetters(String constraint) {
		String lettersInConstraint = EMPTY_STRING;

		for (int index = 0; index < constraint.length(); index++) {
			if (Character.isAlphabetic(constraint.charAt(index))) {
				lettersInConstraint += constraint.charAt(index);
			}
		}

		return lettersInConstraint;
	}
}
