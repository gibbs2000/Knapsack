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
	public static void main(String[] args) {
		String fName = "";
		if (args.length < 1) {
			System.out.println("You did not input a file name");
			Scanner in = new Scanner(System.in);
			fName = in.next();
			in.close();
		} else {
			fName = args[0];
		}

		Scanner input = KnapSack.fileToScanner(fName);
		PrintWriter output = KnapSack.outputFile("knapsack.txt");

		ArrayList<String> files = KnapSack.createFiles(input);
		KnapSack.processFiles(files, output);

		System.out.println(KnapSack.knapsackSumA(KnapConstants.items, 4, KnapConstants.limit));
		System.out.println(KnapSack.knapsackSumB(KnapConstants.items, 4, KnapConstants.limit, KnapConstants.bag));
		System.out.println(KnapConstants.bag);
	}
}
