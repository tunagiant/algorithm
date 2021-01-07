package other;

public class primenumber {

	static int max = 10000;
	static boolean[] notP;

	public static void main(String[] args) {
		notP = new boolean[max + 1];
		prime();
		for (int i = 0; i <= max; i++) {
			if (!notP[i]) {
				System.out.println(i);
			}
		}

	}

	private static void prime() {

		notP[0] = true;
		notP[1] = true;
		for (int i = 2; i <= max; i++) {
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					notP[i] = true;
				}

			}

		}

	}

}
