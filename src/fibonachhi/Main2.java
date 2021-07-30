package fibonachhi;

public class Main2 {

	static int[] cache = new int[100];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		System.out.println("#" + fibo(45));
		long endTime = System.currentTimeMillis();
		System.out.println(" elapseTime="+(endTime-startTime)/1000.0);
	}

	private static int fibo(int n) {
		cache[1] = 1;
		cache[2] = 1;
		
		for (int i = 3; i <=n; i++) {
			cache[i] = cache[i - 1] + cache[i - 2];
		}
		
		return cache[n];
		
	}

}
