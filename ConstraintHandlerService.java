package ScrabbleTeam3;

import java.util.HashMap;

public interface ConstraintHandlerService {
	
	public String appendConstraintLetters(String constraintPattern);

	public HashMap<String, String> applyPatternMatching(
			HashMap<String, String> possibleWords, String constraintPattern);

}
