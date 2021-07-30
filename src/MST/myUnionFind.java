package MST;

public class myUnionFind {
	
		static int N = 3;	
	    public static int[] parent = new int[N+1];
		
	    public static int getParent(int x) {
	        if(x == parent[x])
	            return x;
	        else 
	            return parent[x] = getParent(parent[x]);
		}
		
	    public static void union(int x, int y) {
	         x = getParent(x);
	         y = getParent(y);
	        // 같은 부모를 가지고 있지 않을 때
	        if(x != y) {
	            if(x < y) parent[y] = x;
	            else parent[x] = y;
	            
	        }
	    }
	    //같은 부모 노드를 가지는지 확인
	    public static boolean isConnected(int x, int y) {
	        x = getParent(x);
	        y = getParent(y);
	        if(x == y)
	            return true;
	        else
	            return false;
	    }
	    public static void main(String[] args) {
	        for(int i = 1; i <= N; i++) {
	            parent[i] = i;
	        }
	        
	        union(1, 2);
	        union(1, 3);
	        
	        System.out.println("2과 3은 연결되어 있나요? " + isConnected(2,3));
	        

	    }	
	}

