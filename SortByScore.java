package ScrabbleTeam3;

import java.util.Comparator;
import java.util.Map;

public class SortByScore implements Comparator<String> {

    Map<String, String> base;
    public SortByScore(Map<String, String> base) {
        this.base = base;
    }
    public int compare(String a, String b) {
    	String valueA[]=base.get(a).split(" ");
    	String valueB[]=base.get(b).split(" ");
        if (Integer.parseInt(valueA[0]) >= Integer.parseInt(valueB[0])) {
            return -1;
        } 
        else {
            return 1;
        } 
    }
}
