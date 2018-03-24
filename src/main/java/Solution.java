import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long totalStars = scan.nextLong();
		scan.nextLine();
		long oddRow = 0;
		long evenRow = 0;
		long rowColumnDifference = Long.MAX_VALUE;

		for (long rowGuess = 1; rowGuess < totalStars; rowGuess++) {
			long testEvenRow = totalStars / rowGuess;
			long testOddRow = testEvenRow + 1;
			if (rowGuess % 2 == 0) {
				if ((testEvenRow * rowGuess / 2 + testOddRow * rowGuess / 2) == totalStars) {
					long columns = totalStars / rowGuess;
					if (Math.abs(rowGuess - columns) < rowColumnDifference) {
						rowColumnDifference = Math.abs(rowGuess - columns);
						evenRow = testEvenRow;
						oddRow = testOddRow;
					}
				}
			} else {
				if ((testEvenRow * rowGuess / 2 + testOddRow * rowGuess / 2 + 1) == totalStars) {
					long columns = totalStars / rowGuess;
					if (Math.abs(rowGuess - columns) < rowColumnDifference) {
						rowColumnDifference = Math.abs(rowGuess - columns);
						evenRow = testEvenRow;
						oddRow = testOddRow;
					}
				}
			}
		}

		System.out.println(oddRow);

		scan.close();
	}
}