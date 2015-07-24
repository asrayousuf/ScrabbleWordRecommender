package ScrabbleTeam3;

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
	      int firstChar = i++;
	      int lastChar = 0;
	      while (i != constraint.length())
	      {
	    	    if(constraint.charAt(i)!='*')
	    		{
	    	    	lastChar = i;
	    		}
	    		i++;
	      }
	      for (int j = 0; j < firstChar; j++)
	      {
	    		regex.append("(?)");
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
	      for (int j = lastChar+1; j < constraint.length(); j++)
	      {
	    		regex.append("(?)");
	      }  
	      return regex.toString();
	   }
	 
	 static boolean isMatching(String word, String regex)
	 {
		  Pattern pattern = Pattern.compile(regex);
	      Matcher matcher = pattern.matcher(word);
	      
	      return (matcher.find( ));
	 }
	 
	 public static void main(String args[])
	 {
		ConstraintToRegexConverter cobj = new ConstraintToRegexConverter();
		String regex = (cobj.convertToRegex("***c**p*a*"));
		System.out.println(regex);
		System.out.println(isMatching("acaapia", regex));
	 }
}
