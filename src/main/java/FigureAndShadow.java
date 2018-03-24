import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FigureAndShadow {
	private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
	
	private static String missing(String input) {
		String missing = "";
		for ( int i = 0; i < ALPHA.length(); i++ ) {
			if ( !input.contains(String.valueOf(ALPHA.charAt(i))) ) {
				missing += ALPHA.charAt(i);
			}
		}
		return missing;
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] words = input.nextLine().split(" ");
		String alpha = words[0];
		List<String> left = new ArrayList<String>();
		for ( int i = 1; i < words.length; i++ ) {
			if ( missing(words[i]).equals(alpha) ) {
				left.add(words[i]);
			}
		}
		System.out.println(String.join(" ", left.toArray(new String[0])));
	}
}
