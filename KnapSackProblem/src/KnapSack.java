import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Contains methods to test Knapsack problem
 * 
 * @author Sean Gibbons
 *
 */
public class KnapSack {

	/**
	 * A method which fits the maximum number of items inside a "knapsack" of a
	 * given capacity based on weight
	 * 
	 * @param w
	 *            contains n positive integers (n <= w.length).
	 * @param n
	 *            the current stage
	 * @param limit
	 *            the remaining capacity of the knapsack
	 * @return the sum of some of these integers such that it has the largest
	 *         possible value without exceeding limit.
	 */
	public static int knapsackSumA(int[] w, int n, int limit) {
		if (n < 0) {
			return 0;
		}

		else {

			int excLast = knapsackSumA(w, n - 1, limit);
			int incLast = w[n] + knapsackSumA(w, n - 1, limit - w[n]);
			if (excLast > incLast || w[n] > limit) {
				return excLast;

			} else {
				return incLast;
			}
		}

	}

	/**
	 * A method which fits the maximum number of items inside a "knapsack" of a
	 * given capacity based on weight and also tracks the items in a list
	 * 
	 * @param w
	 *            contains n positive integers (n <= w.length).
	 * @param n
	 *            the current stage
	 * @param limit
	 *            the remaining capacity of the knapsack
	 * @param list
	 *            the items in the knapsack
	 * @return the sum of some of these integers such that it has the largest
	 *         possible value without exceeding limit.
	 */
	public static int knapsackSumB(int[] w, int n, int limit, List<Integer> list) {
		if (n < 0) {
			return 0;
		}

		else {
			List<Integer> list1 = new ArrayList<Integer>();
			List<Integer> list2 = new ArrayList<Integer>();
			list2.add(w[n]);
			int excLast = knapsackSumB(w, n - 1, limit, list1);
			int incLast = w[n] + knapsackSumB(w, n - 1, limit - w[n], list2);
			if (excLast > incLast || w[n] > limit) {
				list.addAll(list1);
				return excLast;

			} else {

				list.addAll(list2);
				return incLast;
			}
		}

	}

	/**
	 * Creates and returns a String of file names from a given Scanner source
	 * 
	 * @param in
	 *            the Scanner source file
	 * @return a list of file names
	 */
	public static ArrayList<String> createFiles(Scanner in) {
		ArrayList<String> files = new ArrayList<String>();
		while (in.hasNextLine()) {
			files.add(in.nextLine());
		}
		return files;

	}

	/**
	 * Processes a list of filenames and uses the Knapsack method on them. After
	 * doing so, writes the output to a PrintWriter
	 * 
	 * @param files
	 *            A list of files to test Knapsack with
	 * @param output
	 *            the output file where the results are written to
	 */
	public static void processFiles(ArrayList<String> files, PrintWriter output) {
		for (int i = 0; i < files.size(); i++) {
			if (files.get(i) != "") {
				Scanner in = fileToScanner(files.get(i));
				String out = files.get(i) + "\t" + in.nextLine() + "\t";
				ArrayList<Integer> weights = new ArrayList<Integer>();
				while (in.hasNextLine()) {
					weights.add(Integer.parseInt(in.nextLine().trim()));
				}

				int[] arrWeights = new int[weights.size()];
				for (int w = 0; w < arrWeights.length; w++) {
					arrWeights[w] = weights.get(w);
				}
				output.println(out);
				output.println();
			}
		}

	}

	public static String performKnapSack(ArrayList<String> files, int limit, int[] weights) {
		String out = "";
		List<Integer> bag = new ArrayList<Integer>();
		knapsackSumB(weights, weights.length, limit, bag);
		for (int w : weights) {
			if (bag.contains(w)) {
				out = out + "1 " + w + " pound watermelon";
			} else {
				out = out + "0 " + w + "pound watermelons";
			}
		}

		return out;

	}

	/**
	 * Converts the given file to Scanner
	 * 
	 * @param fName
	 *            The String name of a file
	 * 
	 * @return A Scanner of the file with the given file name
	 */
	public static Scanner fileToScanner(String fName) {

		File fileName = new File(fName);
		Scanner words = null;

		try {
			words = new Scanner(fileName);
		} catch (FileNotFoundException ex) {
			System.out.print("Unable to Open File");
			return null;

		}
		if (!words.hasNext())
			throw new IllegalArgumentException("File is empty");
		return words;

	}

	/**
	 * Creates a file of the given name
	 * 
	 * @param fName
	 *            The name of the file to be created
	 * @return A PrintWriter of the same name as fName which can be manipulated and
	 *         then saved
	 */
	public static PrintWriter outputFile(String fName) {
		File fileName = new File(fName);

		PrintWriter output = null;

		try {
			output = new PrintWriter(fileName);
		} catch (FileNotFoundException ex) {
			System.out.print("Cannot open " + fName);
			return null;

		}

		return output;
	}

}
