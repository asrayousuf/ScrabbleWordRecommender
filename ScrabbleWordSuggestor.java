package day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class ScrabbleWordSuggestor {

	public static void main(String args[]) throws NumberFormatException, IOException{
		
		InputStreamReader read=new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(read);
		System.out.println("Enter String");
		String rack=in.readLine();
	
		System.out.println("Rack: " + rack);
		Anagrams af = new Anagrams();
		
		if(args.length==0) {
			System.out.println("Specify input file path for sowpods dictionary");
		}
			HashMap<String, String> anagrams = af.getAnagramList(args[0]);
		WordScorer ws = new WordScorer();
		Combinations c = new Combinations(rack);
		
		for (String combination : c.combinations) {
			if(anagrams.containsKey(af.sortWord(combination))) {
				String[] validWords = anagrams.get(af.sortWord(combination)).split(" ");
				int score = ws.getWordScore(combination);
				for(String word: validWords) {
					ws.insertWithScore(word, score);
				}
			}
		}		
		
		TreeMap<String,Integer> sorted_map = ws.getSortedList();
		java.util.Iterator<Entry<String, Integer>> it = sorted_map.entrySet().iterator();
		if(sorted_map.isEmpty()){
			System.out.println("No words possible");
		}
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(String.valueOf(pair.getKey() + " " +pair.getValue()));
			
	    }	
	}

}
