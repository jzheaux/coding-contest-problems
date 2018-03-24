import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class FewestAddends {
	
/*	public static int fewest(int total, int[] addends) {
		int[] totals = new int[total + 1];

		for ( int i = 0; i < addends.length; i++ ) {
			totals[addends[i]] = 1;
		}
		
		for ( int addend : addends ) {
			int[] copy = Arrays.copyOf(totals, totals.length);
			
			for ( int i = 0; i < totals.length; i++ ) {
				if ( totals[i] != 0 ) {
					int newTotal = addend + i;
					if ( newTotal <= total ) {
						if ( totals[newTotal] == 0 || totals[i] + 1 < totals[newTotal] ) {
							copy[newTotal] = totals[i] + 1;
						}
					}
				}
			}
			
			totals = copy;
		}
		
		return totals[total];
	}*/
	
	private static int fewest(Integer total, Integer[] addends) {
		Map<Integer, Integer> totals = new HashMap<Integer, Integer>();

		
		for ( Integer addend : addends ) {
			Set<Integer> keys = new HashSet<Integer>(totals.keySet());
			Map<Integer, Integer> copy = new HashMap<Integer, Integer>(totals);
			for ( Integer key : keys ) {
				Integer newKey = addend + key;
				if ( newKey <= total ) {
					if ( !totals.containsKey(newKey) || totals.get(key) + 1 < totals.get(newKey) ) {
						copy.put(newKey, totals.get(key) + 1);
					}
				}
			}
			
			
			copy.put(addend, 1);
			
			totals = new HashMap<Integer, Integer>(copy);
		}
		
		if ( totals.containsKey(total) ) {
			return totals.get(total);
		} else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(fewest(10, new Integer[] { 7, 2, 2, 2, 2, 2, 4 }));
		System.out.println(fewest(10, new Integer[] { 7, 2, 2, 2, 2, 2, 3 }));
		System.out.println(fewest(10, new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		System.out.println(fewest(15, new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		System.out.println(fewest(60, new Integer[] { 3, 5, 7, 11, 13, 17, 23, 29 }));
		System.out.println(fewest(60, new Integer[] { 59, 29, 17, 14, 7, 6, 3 }));
		System.out.println(fewest(60, new Integer[] { 59, 29, 14, 6, 3 }));
		
	}
}
