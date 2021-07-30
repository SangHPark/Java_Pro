package LIS;

public class example_DP {

	static int N = 7;
	static int[] array = {50, 10,20,10,30,20,50};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] dp = new int[N];
		int max = 0;
		dp[0] = 1;
		
		for (int i = 1; i < N; i ++) {
			dp[i] = 1;
			
			for (int j = 0; j < i; j ++) {
				if (array[i] > array[j] && dp[j] + 1 > dp [i]) {
					dp[i] = dp[j] + 1;
				}
			}
			
			if (max < dp[i]) {
				max = dp[i];
			}
		}
		
		System.out.println(max);

	}

}
