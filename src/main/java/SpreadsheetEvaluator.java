import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;




public class SpreadsheetEvaluator {
	static Map<String, Long> values = new HashMap<String, Long>();
	
	private static long evaluate(String expression) {
		String[] operands = expression.split(" ");
		Long total = null;
		for ( int i = 0; i < operands.length; i++ ) {
			if ( total == null ) {
				total = Long.parseLong(operands[i]);
			} else {
				if ( "*".equals(operands[i]) ) {
					total *= Long.parseLong(operands[i + 1]);
				} else if ( "-".equals(operands[i]) ) {
					total -= Long.parseLong(operands[i + 1]);
				} else {
					total += Long.parseLong(operands[i + 1]);
				}
				i++;
			}
		}
		
		return total.longValue();
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] expressions = input.nextLine().split(",");
		
		int numberOfDeadEnds = 0;
		for ( int row = 0; row < 3; row++ ) {
			for ( int col = 0; col < 3; col++ ) {
				String cell = ((char)(row + 97)) + "" + ((char)(col + 49));
				try {
					values.put(cell, Long.parseLong(expressions[3 * row + col]));
					numberOfDeadEnds++;
				} catch ( NumberFormatException e ) {
					// no worries
				}
			}
		}
		
		int was = numberOfDeadEnds;
		
		while ( true ) {
			Map<String, Long> copy = new HashMap<String, Long>(values);
			for ( Map.Entry<String, Long> entry : values.entrySet() ) {
				String cell = entry.getKey();
				
				for ( int row = 0; row < 3; row++ ) {
					for ( int col = 0; col < 3; col++ ) {
						String toUpdate = ((char)(row + 97)) + "" + ((char)(col + 49));
						String toUpdateValue = expressions[3 * row + col];
						expressions[3 * row + col] = expressions[3 * row + col].replaceAll(cell, String.valueOf(entry.getValue()));
						toUpdateValue =expressions[3 * row + col];
						if ( !toUpdateValue.contains("a") && !toUpdateValue.contains("b") && !toUpdateValue.contains("c") ) {
							try {
								Long.parseLong(toUpdateValue);
							} catch ( NumberFormatException e ) {
								copy.put(toUpdate, evaluate(toUpdateValue));
								expressions[3 * row + col] = String.valueOf(copy.get(toUpdate));
								numberOfDeadEnds++;
							}
						}
					}
				}
			}
			
			if ( was == numberOfDeadEnds && numberOfDeadEnds < 9 ) {
				System.out.println("cycle");
				return;
			} else if ( was == numberOfDeadEnds ) {
				for ( int row = 0; row < 3; row++ ) {
					for ( int col = 0; col < 3; col++ ) {
						String cell = ((char)(row + 97)) + "" + ((char)(col + 49));
						System.out.print(values.get(cell));
						if ( row < 2 || col < 2 ) {
							System.out.print(",");
						} else {
							System.out.println();
						}
					}
				}
				return;
			}
	
			was = numberOfDeadEnds;
			
			values = new HashMap<>(copy);
		}
	}
}
