import java.util.ArrayList;
import java.util.List;

public class KnapSack {

	public static int knapsackSumA(int[] w, int n, int limit) {
		if (n < 0 || w[n] > limit) {
			return 0;
		}

		else {
			int excLast = knapsackSumA(w, n - 1, limit);
			int incLast = knapsackSumA(w, n - 1, limit - w[n]);
			if (Math.max(excLast, incLast) == excLast) {
				return w[n] + incLast;
			} else
				return excLast;
		}

	}

	public static int knapsackSumB(int[] w, int n, int limit, List<Integer> list) {
		if (n < 0 || w[n] > limit) {
			return 0;
		}

		else {
			int excLast = knapsackSumB(w, n - 1, limit, new ArrayList<Integer>());
			int incLast = knapsackSumB(w, n - 1, limit - w[n], new ArrayList<Integer>());
			if (Math.max(excLast, incLast) == excLast) {
				list.add(w[n]);
				return w[n] + incLast;
			} else
				return excLast;
		}
	}

}
