package guerer.example;

public class RangeSumQueryMutable307 {
	private int[] bit;

	public RangeSumQueryMutable307(int[] nums) {
		bit = new int[nums.length + 1];
		
		for(int i = 0; i < nums.length; i ++) {
			add(i + 1, nums[i]);
		}
	}
	
	private void add(int i, int val) {
		while(i < bit.length) {
			bit[i] += val;
			i += (i & -i);
		}
	}

	public void update(int i, int val) {
		int del = val - (sum(i + 1) - sum(i));
		add(i + 1, del);
	}

	private int sum(int i) {
		int si = 0;
		while (i > 0) {
			si += bit[i];
			i = i - (i & -i);
		}
		return si;
	}
	
	public int sumRange(int m, int n) {
		return sum(n + 1) - sum(m);
	}
}
