package MST;

public class UnionFind {
	    public static int[] parent = new int[10];
		
	    public static int find(int x) {
	        if(x == parent[x])
	            return x;
	        else 
	            return parent[x] = find(parent[x]);
		}
		
	    public static void union(int x, int y) {
	        x = find(x);
	        y = find(y);
	        // ���� �θ� ������ ���� ���� ��
	        if(x != y) {
	            // y�� x ���� ũ�ٴ� ���� �����Ѵٸ� �Ʒ��� ���� ǥ��
	            parent[y] = x;
	            // �� ���� ������ �־� �� �� ������ ���̵� ǥ�� ����
	            
	            /* 
	            if(x < y) parent[y] = x;
	            else parent[x] = y;
	            */
	        }
	    }
	    //���� �θ� ��带 �������� Ȯ��
	    public static boolean isSameParent(int x, int y) {
	        x = find(x);
	        y = find(y);
	        if(x == y)
	            return true;
	        else
	            return false;
	    }
	    public static void main(String[] args) {
	        for(int i = 1; i <= 8; i++) {
	            parent[i] = i;
	        }
	        union(3, 8);
	        union(8, 6);
	        union(6, 1);
	        
	        System.out.println("1�� 3�� ����Ǿ� �ֳ���? " + isSameParent(1,3));
	    }	
	}

