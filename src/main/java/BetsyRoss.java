import java.util.Scanner;


public class BetsyRoss {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String line = input.nextLine();
		Integer starCount = Integer.parseInt(line);
		
		double bestColumnCount = starCount;
		double bestRatio = starCount;
		for ( int n = starCount - 1; n >= 1; n-- ) {
			int remainder = starCount % ( n + ( n - 1 ) );
			if ( remainder == 0 || remainder == n ) {
				double rowCount = starCount / ( n + ( n - 1 ) ) * 2 + (remainder == 0 ? 0 : 1);
				double ratio = Math.max(n, rowCount) / Math.min(n, rowCount);
				if ( ratio < bestRatio ) {
					bestColumnCount = n;
					bestRatio = ratio;
				}
			}
		}
	
		System.out.println((int)bestColumnCount);
	}
}
