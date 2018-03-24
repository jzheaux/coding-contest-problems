import java.util.ArrayList;
import java.util.List;


public class Happy {
	public static boolean isHappy(int i) {
		int current = i;
		List<Integer> pastValues = new ArrayList<Integer>();
		while ( current != 1 ) {
			pastValues.add(current);
			char[] digits = String.valueOf(current).toCharArray();
			current = 0;
			for ( int j = 0; j < digits.length; j++ ) {
				current += Math.pow(Integer.parseInt(String.valueOf(digits[j])), 2);
			}
			if ( pastValues.contains(current) ) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) 
	{
		int happyCount = 0;
		for ( int i = 1000000; i <= 1000030; i++ ) {
			System.out.printf("%d is happy: %s\n", i, isHappy(i));
		}
		System.out.println(happyCount);
	}
}
