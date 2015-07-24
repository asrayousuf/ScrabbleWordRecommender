package ScrabbleTeam3;

import java.util.List;

public class ConstraintHandlerService {
	private final String BLANK_TILE = " ";
	private final String EMPTY_STRING = "";

	public List<Word> applyConstraint(String constraintPattern, String tiles) {
		String lettersInConstraint = extractLetters(constraintPattern);
		String letters = tiles + lettersInConstraint;
		List<Word> possibleWords;
		if (hasBlankTiles(tiles)) {
			possibleWords = findAllPossibleWordsWithBlanks(letters);// team 2
																	// function
		} else {
			possibleWords = findAllPossibleWords(letters);// team 1 function

		}
		possibleWords = applyPatternMatching(possibleWords, constraintPattern);
		return possibleWords;
	}


	private static List<Word> applyPatternMatching(List<Word> possibleWords, String constraintPattern) {

		char[] constraintPatternArray = constraintPattern.toCharArray();
		List<Word> patternMatchedWords = new ArrayList<Word> ();
		String pattern= regexPattern(constraintPattern);
		
		for(Word wordToMatch: possibleWords){
			if(isMatching(wordToMatch.getWord(), pattern) {
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
