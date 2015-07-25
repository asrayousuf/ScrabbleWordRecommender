import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ConstraintToRegexConverter
{	
	 public static String convertToRegex(String constraint)
	 {
	      StringBuilder regex = new StringBuilder("");
	     for (int i = 0; i < constraint.length() ; i++)
	     {
	    	 if (constraint.charAt(i) == '.') regex.append('.');
	    	 else if (constraint.charAt(i) == '*') regex.append("([a-z])*");
	    	 else regex.append(constraint.charAt(i));
	     }
	       return regex.toString();
	   }
	 
	 static boolean isMatching(String word, String regex)
	 {
		  Pattern pattern = Pattern.compile(regex);
	      Matcher matcher = pattern.matcher(word);
	      return matcher.matches();
	 }
	 
}
