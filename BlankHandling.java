import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.List;
import java.util.ArrayList;

class BlankHandling {

	public Set<String> addBlankHelper(String word, int spaceCount){
	
		Set<String> formedWordsList = new HashSet<String>();
		return addBlank(formedWordsList, word, spaceCount);
	
	}
	
	public static Set<String> addBlank(Set<String> formedWordsList, String word, int spaceCount){
		
		if(spaceCount == 0){
			formedWordsList.add(word);
		}
		else
		{
			int index = 0;
			for(char i= 'a'; i <= 'z'; i++){
				if(index < word.length()){
					if(word.charAt(index) <= i){
						index++;
					}
				}
				String newWord = word.substring(0, index) + i + word.substring(index, word.length());
				formedWordsList.add(newWord);
				formedWordsList = addBlank(formedWordsList, newWord, spaceCount-1);
			}
		}
		
		return formedWordsList;
	}
	
	public static void main(String[] args) {
	
		String word = "cnt";
		int spaceCount = 2;
		
		BlankHandling blankHandling = new BlankHandling();
		System.out.println(blankHandling.addBlankHelper(word, spaceCount));
		
	}

}
