package ScrabbleTeam3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PossibleWordsGenerator {
	ScrabbleWordListBuilder wordListBuilder;
	private HashMap<String, String> wordList = new HashMap<String, String>();

	public PossibleWordsGenerator() {
		wordListBuilder = new ScrabbleWordListBuilder();
		wordList = wordListBuilder.getWordList();
	}
	
	public HashMap<String, String> findValidWords(String rack,String constraint){
		int blankTiles = 0;
		if (constraint.length() > 0) {
			ConstraintHandlerServiceImpl constraintHandler = new ConstraintHandlerServiceImpl(
					rack, constraint);
			rack = constraintHandler.appendConstraintLettersToRack();
		}
		
		BlankHandler blankHandler = new BlankHandler(rack);
		if (blankHandler.hasBlankTiles()) {
			blankTiles = blankHandler.countBlankTiles();
			rack = blankHandler.getRackWithoutBlankTiles();
		}
		HashMap<String, String> possibleWords = findAllPossibleWords(rack,blankTiles);
		
		if (constraint.length() > 0) {
			ConstraintHandlerServiceImpl constraintHandler = new ConstraintHandlerServiceImpl(
					rack);
			possibleWords = constraintHandler.applyPatternMatching(
					possibleWords);
		}

		if (blankHandler.hasBlankTiles()) {
			possibleWords = blankHandler.deductBlankTileScore(possibleWords);
		}
		return possibleWords;
	}

	public HashMap<String, String> findAllPossibleWords(String rack, int blankTiles) {
		HashMap<String, String> possibleWords = new HashMap<String, String>();
		for (Map.Entry<String, String> entry : wordList.entrySet()) {
			if (wordMatches(entry.getKey(), rack, blankTiles)) {
				possibleWords.put(entry.getKey(), entry.getValue());
			}
		}
	
		return possibleWords;
	}
	
	private boolean wordMatches(String word, String rack, int blankCount) {
		List<Character> characterListofWord = new LinkedList<Character>();
		for (char c : word.toCharArray()) {
			characterListofWord.add(c);
		}
		for (char c : rack.toCharArray()) {
			characterListofWord.remove(new Character(c));
		}
		return (characterListofWord.size() == blankCount);
	}
	

}
