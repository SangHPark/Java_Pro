package greedy;

public class till_one {

	static int N;
	static int K;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = 25;
		K = 3;
		
		int result = N;
		int cnt = 0;
		
		do {
			if (result % K == 0) {
				result = result / K;
			} else {
				result = result - 1;
			}
			cnt ++;
		} while (result != 1);
		
		System.out.println(cnt);
	}

}
