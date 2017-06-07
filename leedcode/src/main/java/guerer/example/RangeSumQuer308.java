package guerer.example;

public class RangeSumQuer308 {

	int[][] sum;

	public RangeSumQuer308(int[][] matrix) {
		sum = new int[matrix.length + 1][matrix[0].length + 1];

		for (int i = 1; i < sum.length; i++) {
			for (int j = 1; j < sum[i].length; j++) {
				add(i, j, matrix[i - 1][j - 1]);
			}
		}
	}

	private void add(int r, int c, int val) {
		while (r < sum.length) {
			int m = c;
			while (m < sum[r].length) {
				sum[r][m] += val;
				m += (m & -m);
			}
			r += (r & -r);
		}
	}

	private int sum(int r, int c) {
		int s = 0;
		while (r > 0) {
			int m = c;
			while (m > 0) {
				s += sum[r][m];
				m -= (m & -m);
			}
			r -= (r & -r);
		}
		return s;
	}

	public void update(int r, int c, int val) {
		int del = val - (sum(r + 1, c + 1) + sum(r, c) - sum(r + 1, c) - sum(r, c + 1));
		add(r + 1, c + 1, del);
	}
	
	public int sumRegion(int r1, int c1, int r2, int c2) {
		return sum(r2 + 1, c2 + 1) + sum(r1, c1) - sum(r1, c2 + 1) - sum(r2 + 1, c1);
	}
}
