package dp;

public class scissors {

	static int N  = 7;
	static int K  = 2;
	static int[] ribbon = {3,1,2,3,1,4,2};
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int k = 1;
		do {
			
			for (int i = 1; i < N; i ++) {
				int[] c_ribbon = new int[N - i];
				
				System.arraycopy(ribbon, i, c_ribbon, 0, ribbon.length - i);
				System.out.println(find_each_cost(c_ribbon));
			}
			
			
			
			
			k ++;
		} while (k <= K);

	}
	
	static int find_cost(int k, int i) {
		int a = ribbon[0] - ribbon[i];
		return -1;
	}
	
	static int find_each_cost (int[] c_ribbon) {
		int min = INF;
		int max = 0;
		
		for (int i = 0; i < c_ribbon.length; i ++) {
			if (min >  c_ribbon[i]) {
				min = c_ribbon[i];
			}
			
			if (max <  c_ribbon[i]) {
				max = c_ribbon[i];
			}			
		}
		
		return max-min;
	}

	
}
