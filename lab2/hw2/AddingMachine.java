import java.util.*;

public class AddingMachine {

	public static void main (String [ ] args) {
		Scanner scanner = new Scanner (System.in);
		boolean justStarting = true;
		int total = 0;
		int subtotal = 0;
		int input;
		while (true) {
			// At this point, subtotal contains 0 and total contains the sum
			// of all the values input thus far.
			// You fill in the loop body, making sure to include an inner loop
			// that reads the values in a subtotalable group.
			input = scanner.nextInt();
			if(input == 0) {
				if(!justStarting) {
					System.out.println("total " + total);
					return;
				}	
				else {
					System.out.println("subtotal " + subtotal);
					total +=subtotal;
					subtotal = 0;
					justStarting = false;
				}	
			}
			else {
				subtotal += input;
				justStarting = true;
			}
		}

		// int input;
		// while (true) {
		// 	// At this point, subtotal contains 0 and total contains the sum
		// 	// of all the values input thus far.
		// 	// You fill in the loop body, making sure to include an inner loop
		// 	// that reads the values in a subtotalable group.
		// 	input = scanner.nextInt();
		// 	if(input == 0){
		// 		if(!justStarting) {
		// 			System.out.println("total " + total);
		// 			return;
		// 		}
		// 		else {
		// 			System.out.println("subtotal " + subtotal);
		// 			justStarting = false;
		// 		}
		// 	}
		// 	else {
		// 		while(input != 0){
		// 			subtotal += input;
		// 			input = scanner.nextInt();
		// 		}
		// 		System.out.println("subtotal " + subtotal);
		// 		total += subtotal;
		// 		subtotal = 0;
		// 		justStarting = false;			
		// 	}
		// }
	}
}
