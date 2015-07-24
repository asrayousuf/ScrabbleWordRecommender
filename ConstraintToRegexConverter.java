import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ConstraintToRegexConverter
{	
	 public static String convertToRegex(String constraint)
	 {
	      StringBuilder regex = new StringBuilder("");    
	      int i=0;
	      while (constraint.charAt(i) == '*' && i < constraint.length())
	      {
	    		i++;
	      }
	      int firstChar = i;
	      int lastChar = 0;
	      while (i != constraint.length())
	      {
	    	    if(constraint.charAt(i)!='*')
	    		{
	    	    	lastChar = i;
	    		}
	    		i++;
	      }
	      if (firstChar != 0)
	      {
	    	  regex.append("(.*)");
	      }
	      for (int j = firstChar; j <= lastChar; j++)
	      {
	    		if(constraint.charAt(j) != '*')
	    		{	
	    		    regex.append(constraint.charAt(j));
	    		}
	    		else
	    		{	
	    			regex.append("(.)");
	    		}
	      }
	      if (lastChar != constraint.length() - 1)
	      {
	    		regex.append("(.*)");
	      }  
	      return regex.toString();
	   }
	 
	 static boolean isMatching(String word, String regex)
	 {
		  Pattern pattern = Pattern.compile(regex);
	      Matcher matcher = pattern.matcher(word);
	      
	      return (matcher.find( ));
	 }
	 
}
