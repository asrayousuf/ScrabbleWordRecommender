import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexPatternCalculator
{	
	 public static String convertToRegex( String c )
	 {
	      String constraint = c;
	      StringBuilder regex = new StringBuilder("");
	      
	      int i=0;
	      while(constraint.charAt(i) == '*' && i<constraint.length())
	      {
	    		if(i!=constraint.length()-1)i++;
	    	  }
	    	  int firstChar = i++;
	    	  int lastChar = 0;
	    	  while(i!=constraint.length())
	    	  {
	    		  if(constraint.charAt(i)!='*')
	    		  {
	    			  lastChar = i;
	    		  }
	    		  i++;
	    	  }
	    	  for(int j=0; j<firstChar; j++)
	    		  regex.append("(?)");
	    	  for(int j=firstChar; j<=lastChar; j++)
	    	  {
	    		  if(constraint.charAt(j) != '*')
	    		  regex.append(constraint.charAt(j));
	    		  else regex.append("(.)");
	    	  }
	    	  for(int j=lastChar+1; j<constraint.length(); j++)
	    		  regex.append("(?)");
	    	  
	    	  /*while(constraint.charAt(i) == '*')
	    	  {
	    		 count++;
	    		 //if(i != constraint.length()) i++;
	    		 regex.append('.');
	    	  }
	    	  if(count > 1)
	    	  {
	    		  regex.append(".{"+1,);
	    	  }
	    	  else if(constraint.charAt(i-1) == '*')
	    	  {
	    		  regex.append('.');
	    		  if(i != constraint.length())i++;
	    	  }	    	  
	    	  count = 0;*/
	      

	      
	      String pattern = regex.toString();
	      System.out.println(regex);
          return regex.toString();
	      
	   }
	 
	 static boolean isMatching(String word, String regex)
	 {
		 Pattern pattern = Pattern.compile(regex);
	      Matcher matcher = pattern.matcher(word);
	      
	      return (matcher.find( ));
	      /*{
	         System.out.println(m.group());
	      } else {
	         System.out.println("NO MATCH");
	      }*/
	 }
	 public static void main(String args[])
	 {
		 RegexPatternCalculator cobj = new RegexPatternCalculator();
		String regex = (cobj.convertToRegex("***c**p*a*"));
		System.out.println(regex);
		System.out.println(isMatching("acaapia", regex));
	 }
}
