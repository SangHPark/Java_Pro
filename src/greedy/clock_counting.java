package greedy;

public class clock_counting {

	static int N = 5;
	
	public static void main(String[] args) {
		int count = 0;
		
		for (int h = 0 ; h < N+1; h ++) {
			for (int m = 0; m < 60; m ++ ) {
				for (int s = 0; s < 60; s ++ ) {
					String clock = Integer.toString(h) + ":" + Integer.toString(m) + ":" + Integer.toString(s);
					
					if (clock.contains("3")) {
						count ++;
//						System.out.println(clock);
					}
				}
			}
		}
		
		System.out.println(count);
	} 

}
