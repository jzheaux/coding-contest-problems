import java.util.HashSet;
import java.util.Set;


public class Conlang {
	public boolean isValid(String word, String[] components) {
		Set<String> possibilities = new HashSet<String>();
		
		int numSeeds = 0;
		int was = numSeeds;
		
		while ( true ) {
			for ( String component : components ) {
				Set<String> copy = new HashSet<String>(possibilities);
				for ( String generated : possibilities ) {
					if ( word.startsWith(generated + component) && copy.add(generated + component) ) {
						numSeeds++;
					}
				}
				
				if ( word.startsWith(component) && copy.add(component) ) {
					numSeeds++;
				}
				
				possibilities = copy;
			}
			
			if ( was == numSeeds ) {
				return false;
			}
			
			if ( possibilities.contains(word) ) {
				return true;
			}
			
			was = numSeeds;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Conlang().isValid("ababa", new String[] { "ab", "ba", "a", "abba"}));
		System.out.println(new Conlang().isValid("banana", new String[] { "b", "ana"}));
		System.out.println(new Conlang().isValid("banana", new String[] { "b", "a", "n"}));
	}
}
