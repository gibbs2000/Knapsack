import java.util.List;

public class KnapSack {

	public static int knapsackSumA(int[] w, int n, int limit) {
		if (n < 0 || w[n] > limit) {
			return 0;
		}

		else {
			int excLast = knapsackSumA(w, n - 1, limit);
			int incLast = knapsackSumA(w, n - 1, limit - w[n]);
			if (Math.max(excLast, incLast) == incLast) {
				return w[n] + incLast;
			} else
				return excLast;
		}

	}

	public static int knapsackSumB(int[] w, int n, int limit, List<Integer> list) {
		return 0;
	}

}
