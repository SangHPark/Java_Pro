package binanytreesearch;

import java.util.Arrays;

public class cutting_ddeok {

	static int N = 4;
	static int M = 6;;
	
	static int[] ddeoks = {20, 15, 10, 17};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Arrays.sort(ddeoks);
		int min_len = ddeoks[0];
		int max_len = ddeoks[N-1];
		
		
		int mid = (max_len + min_len ) / 2;
		
		
		while (min_len < max_len) {
			int sum = 0;
			for (int i = 0; i < N; i ++) {
				if (ddeoks[i] - mid > 0) sum += ddeoks[i] - mid;
			}
			
			if (sum == M) {
				break;
			} 
			else if (sum >= M) {
				min_len = mid + 1;
				
			} 
			else {
				max_len = mid - 1;
			}
			
			mid = (min_len + max_len) / 2;
		}
		
		
		System.out.println(mid);
	}

}
