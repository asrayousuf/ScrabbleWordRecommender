package ScrabbleTeam3;

import java.util.ArrayList;
import java.util.List;

public class ConstraintHandlerService {
	private final String BLANK_TILE = "*";
	private final String EMPTY_STRING = "";
	
	private String tiles;
	
	public ConstraintHandlerService(String tiles) {
		this.tiles=tiles;
	}
	
	public String appendConstraintLetters(String constraintPattern) {
		String lettersInConstraint = extractLetters(constraintPattern);
		return tiles + lettersInConstraint;
	}


	private List<String> applyPatternMatching(List<String> possibleWords, String constraintPattern) {
		List<String> patternMatchedWords = new ArrayList<String> ();
		String pattern= ConstraintToRegexConvert.convertToRegex(constraintPattern);
		
		for(String wordToMatch: possibleWords){
			if(ConstraintToRegexConverter.isMatching(wordToMatch, pattern)) {
				patternMatchedWords.add(wordToMatch);
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
