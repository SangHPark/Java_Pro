package boggle_game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class dfs_test {
	static TrieNode root = new TrieNode();
	static int W, b;
	static String boggle[][][];
	static boolean visited[][];
	
//	static int[] Dx =  {0,1,1, 1, 0,-1,-1,-1};
//	static int[] Dy =  {1,1,0,-1,-1,-1, 0, 1};
	
    static int[] Dx = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] Dy = {-1, 1, 0, 0, 1, -1, 1, -1};
    
	static class TrieNode {
		TrieNode[] children;
		boolean isWord;
		
		TrieNode() {
			this.children = new TrieNode[26];
			this.isWord = false;
		}
		
		void insert(String s) {
			char[] char_array = s.toCharArray();
			
			if(char_array.length == 0) {
				isWord = true;
				return;
			} else {
				char c = char_array[0];
				int idx = Character.getNumericValue(c) - Character.getNumericValue('A');
				if (children[idx] == null ) {
					children[idx] = new TrieNode(); 
				}
				
				s = s.substring(1);
				children[idx].insert(s);
			}
		}
		
		boolean search(String s) {
			char[] char_array = s.toCharArray();
			
			if(char_array.length == 0) {
				return isWord;
			} else {
				char c = char_array[0];
				int idx = Character.getNumericValue(c) - Character.getNumericValue('A');
				if (children[idx] == null) {
					return false;
				}
				s = s.substring(1);
				return children[idx].search(s);
			}
		}
	}

	static void dfs(int x, int y, String search_s) {
		if (search_s.length() > 8) return;
		
//		System.out.println("Search = " + search_s + ", " + root.search(search_s));
		
		System.out.println("Search = " + search_s);
		
		if (search_s.equals("ICPR")) System.out.println(search_s);
		
//		if (root.search(search_s)) {
//			System.out.println(search_s);
//		}
		
		visited[x][y] = true;
		
		
		for (int i = 0; i < 8; i ++ ) {
			int newX = x + Dx[i];
			int newY = y + Dy[i];
//			System.out.println("newX = " + newX + " newY = " + newY);	
			if (newX < 3 && newY < 3 && newX > 0 && newY > 0)  {
				if (!visited[newX][newY]) {
					search_s += boggle[1][newX][newY];
					if (search_s.equals("ABCFIHGDE")) {
						System.out.println("LMK");
					}
					dfs(newX, newY, search_s);
					
					visited[newX][newY] = false;	
					
				}
			}
		}

//		visited[x][y] = false;
//		search_s = boggle[1][1][1];
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		root.insert("ABC");
		
		
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\boggle_game\\dfs_test.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			W = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < W; i++) {
				String Input = br.readLine();
				root.insert(Input);
//				System.out.println("Search = " + Input + ", Result = " + root.search(Input));
			}
			
			String space1 = br.readLine();
			
			b = Integer.parseInt(br.readLine());
			boggle = new String[b+1][3][3];
			
			for (int i = 1; i < b+1; i ++) {
				for (int j = 1; j < 3; j++) {
					String Input = br.readLine();
					for (int k =1; k < 3 ; k++) {
						boggle[i][j][k] = Input.substring(k-1,k);
					}
				}
				space1 = br.readLine();
			}
			
//			for (int i = 1; i < b+1; i ++) {
//				for (int j = 1; j < 5; j++) {
//					for (int k = 1; k < 5; k++) {
//						System.out.print(boggle[i][j][k] + " ");
//					}
//					System.out.println("");
//				}
//				System.out.println("");
//			}

			
			visited = new boolean[3][3];
			
			for (int i = 1; i < 3; i ++) {
				for (int j = 1; j < 3; j++) {
					dfs(i,j, boggle[1][i][j]);
					visited[i][j] = false;
				}
			}
			
//			dfs(1,1, boggle[1][1][1]);

			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
