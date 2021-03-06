
public class GaussSeidel {

	static double a[][] = { { 15, 1, 7 }, { 17, 33, -1 }, { -2, 16, 74 } };
	static double b[] = { 6, 7, 8 };
	static double norm = 0;
	static int n = b.length;
	static final long nrMax = 1000000;
	static double x[], y[];
	static double eps = 0.0001;
	static long nrIteratii = 0;

	public static double calcNorm() {
		double max = Math.abs(x[0] - y[0]);
		for (int i = 1; i < n; i++) {
			double dif = Math.abs(x[i] - y[i]);
			if (dif > max)
				max = dif;

		}
		return max;
	}

	public static double calcSum1(int linie) {
		double sum = 0;
		for (int i = 0; i < linie; i++) {
			if (linie != i)
				sum += a[linie][i] * y[i];
		}
		return sum;
	}

	public static double calcSum2(int linie) {
		double sum = 0;
		for (int i = linie; i < n; i++) {
			if (linie != i)
				sum += a[linie][i] * x[i];
		}
		return sum;
	}

	public static void solve() {
		x = new double[100];
		y = new double[100];
		do {
			for (int i = 0; i < n; i++) {
				y[i] = (1.00 / a[i][i]) * (b[i] - calcSum1(i) - calcSum2(i));
			}
			norm = calcNorm();
			nrIteratii++;
			for (int i = 0; i < n; i++)
				x[i] = y[i];
		} while (norm > eps && nrIteratii < nrMax);
	}

	public static void afisare() {
		if (norm < eps)
			System.out.println("OK");
		else
			System.out.println("!OK");

		for (int i = 0; i < n; i++)
			System.out.println("x[" + i + "]: " + y[i]);
	}

	public static void main(String args[]) {
		System.out.println("Matricea:");
		System.out.print("A: ");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++)
				System.out.print(a[i][j] + " ");
			if (i < a.length - 1)
				System.out.print("\n   ");
		}
		System.out.print("\nB: ");
		for (int i = 0; i < b.length; i++)
			System.out.print(b[i] + " ");
		System.out.println("\n\nSolutii:");
		solve();
		afisare();
	}
}
