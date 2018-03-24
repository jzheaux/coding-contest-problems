
public class Experiments {
	public static String createString(int N, int K) {
		for ( int i = 1; i < N; i++ ) { // how many A's do we need?
			if ( K % i == 0 && K / i + i <= N ) {
				// K / i number of B's follow i A's
				String s = "";
				for ( int j = 0; j < K / i; j++ ) {
					s = "B" + s;
				}
				for ( int j = 0; j < i; j++ ) {
					s = "A" + s;
				}
				for ( int j = s.length(); j < N; j++ ) {
					s = "B" + s;
				}
				return s;
			}
		}
		return "";
	}
	
	public static void main(String[] args) {
		System.out.println(Experiments.createString(2, 0));
	}
}
