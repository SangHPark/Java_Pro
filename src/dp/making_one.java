package dp;


//Logical Error... 자기것을 써야 되네.. d-1 이 아니라
public class making_one {

	static int cnt = 0;
	static int d[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 48;
		
		d = new int[N+1];
		
//		dp(26);
		
//		System.out.println(cnt);
		
		d[1] = 0;
		
		for (int i = 2; i <= N; i ++) {
			
			if (i == N) {
				System.out.println("LMK");
			}

			if ( i % 5 == 0) {
				d[i] = Math.min(d[i - 1], d[i / 5]) + 1; 
			} 
			
			if ( i % 3 == 0) {
				d[i] = Math.min(d[i - 1], d[i / 3]) + 1; 
			}

			if ( i % 2 == 0) {
				d[i] = Math.min(d[i - 1], d[i / 2]) + 1; 
			}

			if (( i % 5 != 0) &&  (i % 3 != 0) &&  (i % 2 != 0)) {
				d[i] = d[i - 1] + 1;
			}
			
		}
		
		
		System.out.println(d[N]);
		
//		for (int i = 1; i < N+1; i ++) {
//			System.out.println(d[i]);
//		}
	}


}
