package boggle_game;

public class Geeks_Solution {
	static final String [] dictionary = {"GEEKS","FOR","QUIZ","GO"};
	static final int M = 3, N = 3;
	static final int n = dictionary.length;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][] boggle = {{'G','I','Z'},
							{'U','E','K'},
							{'Q','S','E'}};
		
		System.out.println("Following words of dictionary are present"); 
		findWords(boggle);

	}

	private static void findWords(char[][] boggle) {
		// TODO Auto-generated method stub
		boolean [][] visited = new boolean[M][N];
		
		String str = "";
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				findWordsUtil(boggle, visited, i, j, str);
			}
		}
	}

	private static void findWordsUtil(char[][] boggle, boolean[][] visited, int i, int j, String str) {
		// TODO Auto-generated method stub
		visited[i][j] = true;
		str = str + boggle[i][j];
		
//		System.out.println(str);
		if (isWord(str)) {
			System.out.println("Answer:" + str);
		}
		
		for (int row = i - 1; row <= i + 1 && row < M; row ++) {
			for (int col = j -1; col <= j + 1 && col <N; col ++) {
				if (row >= 0 && col >= 0 && !visited[row][col]) {
					findWordsUtil(boggle, visited, row, col, str);
				}
			}
		}
		
		str = "" + str.charAt(str.length() - 1);
		visited[i][j] = false;
		
	}

	private static boolean isWord(String str) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			if (str.equals(dictionary[i])) {
				return true;
			}
		}
		return false;
	}

}
