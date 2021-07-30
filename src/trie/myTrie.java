package trie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class myTrie {

	static final int NUMS = 10;
	static Trie root;
	static int T, N;

	static class Trie {
		boolean isLastChar;
		Trie children[];
		
		public Trie() {
			isLastChar = false;
			children = new Trie[NUMS];
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\trie\\myTrie.txt"));
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Read data in input file or external input.		
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			root = new Trie();	
			String str[] = new String[N];
			for (int i = 0; i < N; i ++) {
				str[i] = br.readLine();
				insert(str[i]);
			}
		}
		
		
		;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	static void insert(String key) {
		Trie curTrie = root;
		int length = key.length();
		int index;
		
		for (int level = 0; level < length; level ++) {
			index = key.charAt(level) - '0';
			System.out.println(index);
			if (curTrie.children[index] == null) {
				curTrie.children[index] = new Trie();
			}
			
			curTrie = curTrie.children[index];
		}
	}
	
	

	
}
