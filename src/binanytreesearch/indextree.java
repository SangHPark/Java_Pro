package binanytreesearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class indextree {

	static int N;
	static int M;
	static int K;
	
	static long[] tree;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\binanytreesearch\\indextree.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int S = 1;
        while (S < N)
            S <<= 1;
        
        tree = new long[2 * S];
        //��������� ���� �迭�� �ִ´�
        for (int i = S; i <= S + N - 1; i++) {
            tree[i] = Long.parseLong(br.readLine().trim());
        }

        
		for (int i = 0; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
		}
		
		//�κ����� ���ؼ� �ִ´�
        for (int i = S; i <= S + N - 1; i++) {
            int P = i / 2;
            while (P != 0) {
                tree[P] = tree[P] + tree[i];
                P /= 2;
            }
        }
 
        System.out.println("");
		for (int i = 0; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
		}
		
		
		for (int i = 1; i <= M + K ; i ++ ) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == 1) {
				update(S + b - 1, c);
			} 
//			else
//                System.out.println(sum(S + b - 1, S + c - 1));
			
			
		}
		
		System.out.println("");
		for (int i = 0; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
		}
		
	}
	
    static long sum(int b, int c) {
        long sum = 0l;
        while (b < c) {
            // �����ϴ� �κ��� Ȧ������ �Ǵ��մϴ�.
            if ((b & 1) == 1) {
                sum += tree[b];
                b++;
            }
            // ������ �κ��� ¦������ �Ǵ��մϴ�.
            if ((c & 1) == 0) {
                sum += tree[c];
                c--;
            }
            b /= 2;
            c /= 2;
        }
        // �ؿ������� ���۰� ���� �ö�ͼ� ������ �ȴٸ� �� ������ ���� ��尡 ���� �θ��� ���̰�,
        // ���� ���� ���� ��� ������ ���� ��Ÿ���� ���Դϴ�.
        if (b == c)
            sum += tree[b];
        return sum;
    }
    
    static void update(int idx, long val) {
        long minus = tree[idx];
        int P = idx;
        while (P != 0) {
            tree[P] = tree[P] - minus + val;
            P /= 2;
        }
    }
}
