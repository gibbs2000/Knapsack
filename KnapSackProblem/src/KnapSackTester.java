
public class KnapSackTester {
	public static void main(String[] args) {

		System.out.println(KnapSack.knapsackSumA(KnapConstants.items, 3, KnapConstants.limit));
		System.out.println(KnapSack.knapsackSumB(KnapConstants.items, 3, KnapConstants.limit, KnapConstants.bag));
		System.out.println(KnapConstants.bag);
	}
}
