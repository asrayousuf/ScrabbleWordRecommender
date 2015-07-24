package ScrabbleTeam3;

import java.util.ArrayList;
import java.util.List;

public class ConstraintHandlerService {
	private final String BLANK_TILE = "*";
	private final String EMPTY_STRING = "";

	public String appendConstraintLetters(String constraintPattern, String tiles) {
		String lettersInConstraint = extractLetters(constraintPattern);
		return tiles + lettersInConstraint;
	}

	public List<String> applyPatternMatching(List<String> possibleWords, String constraintPattern) {

		char[] constraintPatternArray = constraintPattern.toCharArray();
		List<String> patternMatchedWords = new ArrayList<String> ();
		String pattern= regexPattern(constraintPattern);
		
		for(String word: possibleWords){
			if(isMatching(word, pattern) {
				patternMatchedWords.add(word);
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

	private boolean hasBlankTiles(String tiles) {
		return tiles.contains(BLANK_TILE);
	}
}
