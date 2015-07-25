# ScrabbleWordSuggester.java

	ScrabbleWordSuggester(PossibleWordsGenerator possibleWordsGenerator);
	void requestUserInteraction();
	void printSuggestedWords(TreeMap<String, String> words);

# PossibleWordsGenerator.java
	
	PossibleWordsGenerator();
	HashMap<String, String> findPossibleWordsWithConstraints(String rack,String constraint);
	HashMap<String, String> findAllPossibleWords(String rack, int blankTiles);


# ScrabbleWordListBuilder.java

	ScrabbleWordListBuilder();
	HashMap<String, String> getWordList();


# BlanksHandler.java

	BlanksHandler(String rack);
	HashMap<String, String> deductBlankTilesScore(Map<String, String> possibleWords);
	int countBlankTiles();
	boolean hasBlankTiles();
	String getRackWithoutBlankTiles();


# ConstraintHandlerService.java

	ConstraintHandlerService(String rack, String constraintPattern);
	String appendConstraintLettersToRack();
	List<String> applyPatternMatching(HashMap<String, String> possibleWords);