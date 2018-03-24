import java.util.Scanner;


public class Uncompressor {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String in = input.nextLine();
		String out = "";
		for ( int i = 0; i < in.length(); i++ ) {
			char ch = in.charAt(i);
			if ( ch == '{' ) {
				String sequence = in.substring(i + 1, in.indexOf('}', i));
				String[] seq = sequence.split(",");
				int start = Integer.parseInt(seq[0]);
				int howmany = Integer.parseInt(seq[1]);
				for ( int j = start; j < start + howmany; j++ ) {
					out += out.charAt(j);
				}
				i += sequence.length() + 1;
			} else {
				out += ch;
			}
		}
	
		System.out.println(out);
	}
}
