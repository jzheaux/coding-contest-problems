import java.util.Scanner;


public class CycleFinder {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		String[] numbers = line.split(",");
		int current = 0;
		int last = 0;
		
		boolean[] visited = new boolean[numbers.length];
		while ( Integer.parseInt(numbers[current]) != -1 ) {
			if ( visited[current] ) {
				System.out.println(last);
				return;
			}
			visited[last] = true;
			last = current;
			current = Integer.parseInt(numbers[current]);
		}
		
		System.out.println(-1);
	}
}
