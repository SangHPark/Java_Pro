package trie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class lyrics_search {

	static Trie[] TrieRoot = new Trie[10000];
	static Trie[] ReTrieRoot = new Trie[10000];
	
	static int[] answer;
	
	static int nT;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\trie\\lyrics_search.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			nT = Integer.parseInt(br.readLine());
			
			String[] queries = br.readLine().split(" ");
			
			String[] words = br.readLine().split(" ");
			
			for (String str: queries) {
				System.out.print(" " + str); 
			}
			
			for (String str: words) {
				System.out.print(" " + str); 
			}
			
			 			
			for (String str : words) {
				int idx = str.length() - 1;
				if (TrieRoot[idx] == null) {
					TrieRoot[idx] = new Trie();
					ReTrieRoot[idx] = new Trie();
				}
				
				TrieRoot[idx].insert(str);
				str = new StringBuilder(str).reverse().toString();
				ReTrieRoot[idx].insert(str);
			}
			
			
			System.out.println("");
			
			for (String str : words) {	
				int idx = str.length() - 1;
				System.out.println("idx : " + idx + " " + TrieRoot[idx].count);
			}
			
			
			answer = new int[queries.length];
			int ansIdx = 0;
			
			
			for (String str : queries) {
				int idx = str.length() - 1;
				if (TrieRoot[idx] == null) {
					answer[ansIdx ++] = 0;
					continue;
				}

				if (str.charAt(0) != '?') {
					answer[ansIdx ++] = TrieRoot[idx].search(str); 
				} else {
					str = new StringBuilder(str).reverse().toString();
					answer[ansIdx ++] = ReTrieRoot[idx].search(str);
				}
				
			}
			
			for (int i =0; i < queries.length ; i ++) {
				System.out.println("Answer = " + answer[i]);
			}
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	

	static class Trie {
		Trie[] child = new Trie[26];
		int count;
		int aletter = Character.getNumericValue('a');
		
		void insert (String str) {
			Trie curr = this;
			for (char ch : str.toCharArray()) {
				curr.count ++;
				int idx = Character.getNumericValue(ch) - aletter;
				if (curr.child[idx] == null) {
					curr.child[idx] = new Trie();
				}
				
				curr = curr.child[idx];
			}
			
			curr.count ++;
		}

		int search (String str) {
			Trie curr = this;
			for (char ch : str.toCharArray()) {
				if (ch == '?') return curr.count;
				
				curr = curr.child[Character.getNumericValue(ch) - aletter];
				if (curr == null) {
					return 0;
				}
			}
			
			return curr.count;
		}
	}
		

}
