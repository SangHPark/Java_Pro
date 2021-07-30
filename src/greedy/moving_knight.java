package greedy;

public class moving_knight {
	static int N = 8;
	static String pos = "a1";
	static int[][] map;
	
	static int[][] p_move = {
			{ 1,  2},
			{-1,  2},
			{ 1, -2},
			{-1, -2},			
			{-2,  1},
			{-2, -1},			
			{ 2,  1},
			{ 2, -1}			
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int x = pos.charAt(1) - '0'; 
		int y = pos.charAt(0) -'a' + 1;
		
		int cnt = 0;
		
		map = new int[N+1][N+1];
//		
//		for (int i = 1; i < N+1 ; i ++) {
//			for (int j = 1; j < N+1 ; j ++) {
				
				for (int k = 0; k < 8; k ++) {
					int nx = 1 + p_move[k][0];
					int ny = 1 + p_move[k][1];
					
					if (nx > 0 && nx < N+1 && ny > 0 && ny < N+1) {
						cnt ++;
					}
				}
//			}
//		}
		
		System.out.println(cnt);
	}

}
