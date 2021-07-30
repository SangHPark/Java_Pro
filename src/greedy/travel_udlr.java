package greedy;

public class travel_udlr {
	static int N=5;
	static char[] move = {'R','R','R','U','D','D'};
	static int map[][] = new int[101][101]; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nx = 0;
		int ny = 0;
		
		int curr_x = 1;
		int curr_y = 1;
		
		for (int i = 0; i < move.length; i ++) {
			if (move[i] == 'R') {
				nx = curr_x;
				ny = curr_y + 1;
				if (nx < 1 || nx > 100 || ny < 1 || ny > 100) continue;
			}
			
			if (move[i] == 'L') {
				nx = curr_x;
				ny = curr_y - 1;
				if (nx < 1 || nx > 100 || ny < 1 || ny > 100) continue;
			}			
			
			if (move[i] == 'D') {
				nx = curr_x + 1;
				ny = curr_y;
				if (nx < 1 || nx > 100 || ny < 1 || ny > 100) continue;
			}			
			
			if (move[i] == 'U') {
				nx = curr_x - 1;
				ny = curr_y;
				if (nx < 1 || nx > 100 || ny < 1 || ny > 100) continue;
			}			
			
			curr_x = nx;
			curr_y = ny;
		}
		
		
		System.out.println(curr_x + " " + curr_y);

	}
	
	

}
