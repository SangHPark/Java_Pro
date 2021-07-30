package picking_Jewels;
import java.util.*;

public class Main2 {

	static int N, M;
    static char[][] Map = new char[200][200];
    static int[][] Picked = new int[200][200];
    
    static int[] SDr = {0,  1};  //Right, Down
    static int[] SDc = {1,  0};  //Right, Down

    static int[] EDr = {0, -1};  //Left, Up
    static int[] EDc = {-1, 0};  //Left, Up

// 2 5
// S5211
// 34#2E
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		for (int i = 0; i <N ; ++i) {
			String onerow = sc.next();
		    for (int j = 0; j < M; ++j) {
		        Map[i][j] = onerow.charAt(j);
		    }
		}
		
		for (int i = 0; i <N ; ++i) {
		    for (int j = 0; j < M; ++j) {
		        System.out.print(Map[i][j]);
		    }
		    System.out.println("");
		}

		
		System.out.println("#" + GoToEnd(0, 0, 'S'));
		
	}

	private static int GoToEnd(int i, int j, char c) {
		int sum_jewwelery = 0;
		POSI curr = new POSI();
		curr.x = i;
		curr.y = j;


		
		for (int dir = 0; dir < 2; ++ dir) {
			POSI next = new POSI();
			next.x = curr.x + SDc[dir];
			next.y = curr.y + SDr[dir];
			
			if (next.x < 0 || next.x >= N || next.y < 0 || next.y >= M) return -1;
			if (Map[next.x][next.y] == '#') return -1;
			
			if (Map[next.x][next.y] == 'E') return sum_jewwelery;
			
			sum_jewwelery += Integer.parseInt(String.valueOf(Map[next.x][next.y]));
			GoToEnd(curr.x + SDc[dir], curr.y + SDr[dir], c);
		}
		
		return -1;
	}
	private static int Pick_Jewelery(int i, int j, char c) {
		int sum_jewwelery = 0;
		
		Queue<POSI> q = new LinkedList<>();
		
		POSI start = new POSI();
		start.x = i;
		start.y = j;
		
		q.add(start);
		
		while(!q.isEmpty()){
			POSI curr = q.poll();
			
			for (int dir = 0; dir < 2; ++ dir) {
				POSI next = new POSI();
				next.x = curr.x + SDc[dir];
				next.y = curr.y + SDr[dir];
				
				if (next.x < 0 || next.x >= N || next.y < 0 || next.y >= M) continue;
				
				if (Map[next.x][next.y] == '.') continue;
				
				if (Map[next.x][next.y] == '#') {sum_jewwelery = 0; continue;}
				
				if (Map[next.x][next.y] == 'E') return sum_jewwelery; 
					
				if (Picked[next.x][next.y] == 0) {
					Picked[next.x][next.y] = 1;
					
					sum_jewwelery += Integer.parseInt(String.valueOf(Map[next.x][next.y]));
					q.add(next);
				}
			}
		}
		
		return -1;
	
	}
	
	static class POSI {
		int x;
		int y;
	}
}
