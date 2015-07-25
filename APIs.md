# WordSuggester.java

	WordSuggester(PossibleWordsGenerator possibleWordsGenerator);
	void requestUserInteraction();
	void printSuggestedWords(TreeMap<String, String> words);

# PossibleWordsGenerator.java
	
	PossibleWordsGenerator();
	HashMap<String, String> findPossibleWordsWithConstraints(String rack,String constraint);
	HashMap<String, String> findAllPossibleWords(String rack, int blankTiles);


# ScrabbleWordListBuilder.java

	ScrabbleWordListBuilder();
	HashMap<String, String> getWordList();


# BlankHandler.java

	BlankHandler(String rack);
	HashMap<String, String> deductBlankTilesScore(Map<String, String> possibleWords);
	int countBlankTiles();
	boolean hasBlankTiles();
	String getRackWithoutBlankTiles();


# ConstraintHandlerService.java

	ConstraintHandlerService(String rack);
	String appendConstraintLettersToRack(String constraintPattern);
	List<String> applyPatternMatching(HashMap<String, String> possibleWords, String constraintPattern);


# ConstraintToRegexConverter.java

	String convertToRegex(String constraint);
	boolean isMatching(String word, String regex);
