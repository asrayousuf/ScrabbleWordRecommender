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


	private static List<Word> applyPatternMatching(List<Word> possibleWords, String constraintPattern) {
		List<Word> patternMatchedWords = new ArrayList<Word> ();
		String pattern= ConstraintToRegexConvert.convertToRegex(constraintPattern);
		
		for(Word wordToMatch: possibleWords){
			if(ConstraintToRegexConverter.isMatching(wordToMatch.getWord(), pattern) {
				patternMatchedWords.add(new Word(wordToMatch.getWord(), wordToMatch.getScore()));
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
