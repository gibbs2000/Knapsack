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
		if (n < 0 || w[n] > limit) {
			return 0;
		}

		else {
			int excLast = knapsackSumA(w, n - 1, limit);
			int incLast = w[n] + knapsackSumA(w, n - 1, limit - w[n]);
			if (Math.max(excLast, incLast) == incLast) {
				return incLast;
			} else
				return excLast;
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
		if (n < 0 || w[n] > limit) {
			return 0;
		}

		else {
			List<Integer> list1 = new ArrayList<Integer>();
			List<Integer> list2 = new ArrayList<Integer>();
			list2.add(w[n]);
			int excLast = knapsackSumB(w, n - 1, limit, list1);
			int incLast = w[n] + knapsackSumB(w, n - 1, limit - w[n], list2);
			if (Math.max(excLast, incLast) == incLast) {
				list.addAll(list2);
				return incLast;
			} else {
				list.addAll(list1);
				return excLast;
			}
		}

	}

	public static ArrayList<String> createFiles(Scanner in) {
		ArrayList<String> files = new ArrayList<String>();
		while (in.hasNextLine()) {
			files.add(in.nextLine());
		}
		return files;

	}

	public static void processFiles(ArrayList<String> files, PrintWriter output) {
		for (String f : files) {
			Scanner in = fileToScanner(f);
			String out = f + "\t" + in.nextInt() + "\t";

			output.println(out);
			output.println();
		}

	}

	/**
	 * Converts the given file to Scanner
	 * 
	 * @param fName
	 *            The String name of a file
	 * @param fileNum
	 *            The file number, used in case of exceptions or errors to tell user
	 *            which file failed
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
