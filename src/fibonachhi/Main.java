package fibonachhi;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		System.out.println("#" + fibo(45));
		long endTime = System.currentTimeMillis();
		System.out.println(" elapseTime="+(endTime-startTime)/1000.0);
		
		
	}

	private static int fibo(int n) {
		// TODO Auto-generated method stub
		if (n <= 2) {
			return 1;
		} else {
			return fibo(n-2) + fibo(n-1);
		}
		
	}

}
