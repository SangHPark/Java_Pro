package Moving_Population;


import java.util.*;

public class Main {

	static int n, l, r;
    static int [][] map = new int [5][5];
    
// Added by Steve Park    
	static int [] count = new int[26];
	static int [] sum = new int[26];
	
//	2 10 20
//	50 30
//	20 40
	
    public static void create_area(int sy, int sx, int status[][], int index) {
        int [][] visited = new int [5][5];
        
        final int [] dy = new int[] { 0 ,  0, -1, +1};
        final int [] dx = new int[] {-1 , +1,  0,  0};
        
        Queue<POSI> q = new LinkedList<>();
        POSI head = new POSI();
        head.y = sy;
        head.x = sx;
        
        visited[sy][sx] = 1;
        q.add(head);
        
        while(!q.isEmpty()) {
            POSI cur = q.poll();
            
            status[cur.y][cur.x] = index;
            
            ++ count[index];
            sum[index] += map[cur.y][cur.x];
            
            for (int dir = 0; dir < 4; ++dir) {
                POSI next = new POSI();
                next.y = cur.y + dy[dir];
                next.x = cur.x + dx[dir];
                
                if (next.y < 0 || next.y >= n || next.x < 0 || next.x >= n) {
                    continue;
                }
                
                int delta = Math.abs(map[cur.y][cur.x] - map[next.y][next.x]);
                if (visited[next.y][next.x] == 0 && l <= delta && delta <=r) {
                    visited[next.y][next.x] = 1;
                    q.add(next);
                }
            }
            
        }
        
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		
		for (int y = 0; y < n; ++y) {
		    for (int x = 0; x < n; ++x) {
		        map[y][x] = sc.nextInt();
		    }
		}
		
		int ret = 0;
		boolean is_updated = true;
		int [][] status = new int [5][5];
		int area_index = 0;


		//Added Steve Park		    
//	    Arrays.fill(count, 0);
//	    Arrays.fill(sum, 0);
	    
		while (is_updated) {
		    is_updated = false;

		    
		    for (int y = 0; y < n; ++y) {
		        for (int x = 0; x < n; ++x) {
		            if (status[y][x] == 0) {
		                ++ area_index;
		                System.out.println("y x area index" + y + " " + x + " " + area_index );
		                create_area(y, x, status, area_index);
		            }
		        }
		    }
		    
			for (int y = 0; y < n; ++y) {
			    for (int x = 0; x < n; ++x) {
			        int index = status[y][x];
			        if (count[index] == 0) {
			        	System.out.println("y:" + y);
			        	System.out.println("x:" + x);
			        	System.out.println("index:" + index);
			        }
			        int avg = sum[index] / count[index];
			        if (map[y][x] != avg) {
			        	map[y][x] = avg;
			        	is_updated = true;
			        }
			    }
			}
			
			if (is_updated) {
			 ++ ret;
				for (int y = 0; y < n; ++y) {
				    for (int x = 0; x < n; ++x) {
				    	status[y][x] = 0;
				    }
				 }
			 
			}
		    
		}
		System.out.println(ret);
	}
	


	public static class POSI {
	    int y;
	    int x;
	}

}


