package dp;

public class making_one {

	static int cnt = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 26;
		
		
		dp(26);
		
		System.out.println(cnt);
	}

	static int dp (int nN) {
		
		if (nN == 1) return cnt;
		
		cnt ++;
		
		if (nN % 2 == 0) {
			
			return Math.min(cnt, dp(nN/2));
		}	
		
		if (nN % 3 == 0) {
			return Math.min(cnt, dp(nN/3));
		}		
		
		if (nN % 5 == 0) {
			return Math.min(cnt, dp(nN/5));
		}		
		
		
		return Math.min(cnt, dp(nN-1));
		
//		return -1;
	}

}
