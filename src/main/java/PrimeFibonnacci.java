import java.util.Scanner;


public class PrimeFibonnacci {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Integer nth = input.nextInt();
		
		int numberofprimes = 0;
		long prev = 0;
		long current = 1;
		long next;
		while ( numberofprimes < nth ) {
			if ( isPrime(current) ) {
				numberofprimes++;
			}
			
			next = prev + current;
			prev = current;
			current = next;
		}
		
		System.out.println(prev);
	}
	
	private static boolean isPrime(long n) {
		if ( n < 2 ) return false;
		if ( n == 2 ) return true;
		
		for ( long i = 2; i < Math.sqrt(n); i++ ) {
			if ( n % i == 0 ) {
				return false;
			}
		}
		
		return true;
	}
}

// palindrome
// bunny rabbits
// lucas numbers
// pi calculation
// linked list cycle
// --> [ 1, 3, 3, 4, - ]
// find first not repeating character
// largest sum of contiguous indices, consecutive integers
// largest sum of "related" integers
// compression unraveler

// banana banana ban{1,3} {0,6}
// See Spot run. {0,9}jump. Run{3,8}!

