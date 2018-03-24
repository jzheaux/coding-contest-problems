import java.util.Scanner;


public class ContiguousSum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] numbers = input.nextLine().split(",");
		long[][] paths = new long[numbers.length][numbers.length];

		long max = Long.MIN_VALUE;
		for ( int i = 0; i < numbers.length; i++ ) {
			paths[i][i] = Integer.parseInt(numbers[i]);
			if ( paths[i][i] > max ) {
				max = paths[i][i];
			}
		}
		
		for ( int i = 0; i < numbers.length; i++ ) {
			for ( int j = i + 1; j < numbers.length; j++ ) {
				paths[i][j] = paths[i][j-1] + Integer.parseInt(numbers[j]);
				if ( paths[i][j] > max ) {
					max = paths[i][j];
				}
			}
		}
		
		System.out.println(max);
	}
}
