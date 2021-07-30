package topology_sort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_2252_2 {
	static long _start = 0;
	static void printElapse() {
		System.out.println(">> " + (System.currentTimeMillis() - _start) + "ms");
	}
	
	static int N, M;
	static int[] inDegree;
	static boolean[][] align;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_start = System.currentTimeMillis(); // set application start time for test which do not mandatory for exam.
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\topology_sort\\baekjoon_2252.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			
		
			align = new boolean[N+1][N+1];
			
			inDegree = new int[N+1];
			
			int[] result = new int[N+1];
			Queue<Integer> q = new LinkedList<Integer>();
			
			for (int i = 0; i < M; i ++ ) {
				String[] input2 = br.readLine().split(" ");
				int a = Integer.parseInt(input2[0]);
				int b = Integer.parseInt(input2[1]);
				
				align[a][b] = true;
				inDegree[b] ++;
			}
			
			//���������� 0�� ��带 ť�� �����մϴ�.
			for (int i = 1; i < N+1; i++) {
				if (inDegree[i] == 0) q.add(i);
			}
			
			//���������� ������ �����Ƿ��� ��Ȯ�� N���� ��带 �湮�ؾ� �մϴ�
			for (int i = 1; i < N+1; i++) {
				//N���� �湮�ϱ� ���� ť�� ��ٸ� ����Ŭ�� �߻��Ѱ�
				if (q.isEmpty()) {
					System.out.println("There is cycle");
					return;
				}
				
				int x = q.poll();
				result[i] = x;
				
//				for (int j = 0; j < alist.size(); j ++ ) {
//					if (alist.get(j).from == x) {
//						inDegree[alist.get(j).to] --;
//						//���Ӱ� ���������� 0�̵� ������ ť�� �����մϴ�.
//						if (inDegree[alist.get(j).to] == 0) {
//							q.add(alist.get(j).to);
//						}
//					}
//				}
				
				
				for (int j = 1; j < N+1; j ++ ) {
					if (align[x][j]) {
						inDegree[j] --;
						//���Ӱ� ���������� 0�̵� ������ ť�� �����մϴ�.
						if (inDegree[j] == 0) {
							q.add(j);
						}
					}
				}
				
			}

			for (int i = 1; i < N+1; i++) {
				System.out.print(result[i] + " ");
			}
			
			printElapse(); // Display program running time. This line of code has to be removed from submitted code.
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
