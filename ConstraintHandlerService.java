package ScrabbleTeam3;

import java.util.HashMap;

public interface ConstraintHandlerService {
	
	public String appendConstraintLettersToRack();

	public HashMap<String, String> applyPatternMatching(
			HashMap<String, String> possibleWords);

}
