import java.util.Map;

public class ConstraintHandlerService {
	private final String BLANK_TILE = " ";
	private final String EMPTY_STRING = "";

	public Map<String, Integer> applyConstraint(String constraint, String tiles) {
		String lettersInConstraint = extractLetters(constraint);
		String letters = tiles + lettersInConstraint;
		Map<String, Integer> possibleWords;
		if (hasBlankTiles(tiles)) {
			possibleWords = findAllPossibleWordsWithBlanks(letters);//team 2 function
		} else {
			possibleWords = findAllPossibleWords(letters);//team 1 function

		}
		possibleWords = applyPatternMatching(possibleWords, constraint);
		return possibleWords;
	}

	private Map<String, Integer> applyPatternMatching(
			Map<String, Integer> possibleWords, String contraint) {
		// return list of pattern matched words
		return null;
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
