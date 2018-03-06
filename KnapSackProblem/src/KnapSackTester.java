import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Tests the Knapsack problem
 * 
 * @author Sean Gibbons
 *
 */
public class KnapSackTester {
	/**
	 * Tests the Knapsack problem and prints the output to "knapsack.txt"
	 */
	public static void main(String[] args) {
		String fName = "";
		if (args.length >= 1) {

			fName = args[0];
		} else {
			System.out.println(
					"You did not input a file name." + " \nPlease enter a valid file name ending with \".txt\": ");
			Scanner in = new Scanner(System.in);
			fName = in.next();
			int counter = 0;
			while (fName.length() < 5 || !".txt".equals(fName.substring(fName.length() - 4))) {
				if (counter < 5) {
					System.out.println("Invalid file name. \nPlease enter a valid file name ending with \".txt\": ");
				} else {
					System.out.println(
							"You are really trying my patience here.\nPlease enter a valid file name ending with \".txt\":  ");
				}
				fName = in.next();
				counter++;

			}
			in.close();
		}

		Scanner input = KnapSack.fileToScanner(fName);
		PrintWriter output = KnapSack.outputFile(KnapConstants.outputLoc);

		ArrayList<String> files = KnapSack.createFiles(input);
		KnapSack.processFiles(files, output);

		input.close();
		output.close();

		// System.out.println(KnapSack.knapsackSumA(KnapConstants.items, 4,
		// KnapConstants.limit));
		// System.out.println(KnapSack.knapsackSumB(KnapConstants.items, 4,
		// KnapConstants.limit, KnapConstants.bag));
		// System.out.println(KnapConstants.bag);
	}
}
