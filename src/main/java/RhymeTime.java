import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class RhymeTime {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] words = input.nextLine().split(" ");
		String toMatch = words[0];
		Map<Character, Integer> frequencies = new HashMap<Character, Integer>();
		for ( int i = 0; i < toMatch.length(); i++ ) {
			char ch = toMatch.charAt(i);
			if ( frequencies.containsKey(ch) ) {
				frequencies.put(ch, frequencies.get(ch) + 1);
			} else {
				frequencies.put(ch, 1);
			}
		}
		
		String[] scores = new String[words.length - 1];
		for ( int i = 1; i < words.length; i++ ) {
			int score = 0;
			String test = words[i];
			for ( int j = 0; j < test.length(); j++ ) {
				char ch = test.charAt(j);
				if ( frequencies.containsKey(ch) ) {
					score += frequencies.get(ch);
				}
			}
			
			int index = 0;
			while ( index < test.length() ) {
				if ( test.startsWith(toMatch, index) ) {
					score += 2;
				}
				index ++;
			}
			
			scores[i-1] = String.valueOf(score);
		}
		
		System.out.println(String.join(" ", scores));
	}
}
