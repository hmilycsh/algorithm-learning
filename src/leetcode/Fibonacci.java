package leetcode;

public class Fibonacci {

	public int fib(int N) {
		if (N == 0)
			return 0;
		else if (N == 1)
			return 1;
		else {
			int[] a = new int[N + 1];
			a[0] = 0;
			a[1] = 1;
			for (int i = 2; i <= N; i++) {
				a[i] = a[i - 1] + a[i - 2];
			}
			return a[N];
		}
	}

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.println(f.fib(2));
	}

}
