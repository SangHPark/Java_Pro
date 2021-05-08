package trie;

public class SWPro_Trie {

	
	static class TrieNode {
		TrieNode[] children; 
		boolean isWord;
		TrieNode() {
			this.isWord = false;
			children = new TrieNode[26];
		}
		
		void insert(String s) {
			char[] char_array= s.toCharArray();
			
			if (char_array.length == 0) { // 입수받은 문자 배열의 길이가 0이면 마지막문자에 단어처리
				isWord = true;				
			} else {
				char c = char_array[0]; //첫번짜 문자
				// children 배열의 Index를 0부터 만들기 위해 
				int idx = Character.getNumericValue(c) - Character.getNumericValue('a');
				if (children[idx] == null) {
					children[idx] = new TrieNode();
				}
				s = s.substring(1); //다음 자릿수부터의 문자
				children[idx].insert(s); //다음 자리의 문자를 사용하여 Recursive 호출 
			}
		}
		
		boolean search(String s) {
			char[] char_array= s.toCharArray();
			if (char_array.length == 0) { // 마지막 문자의 Word를 반환
				return isWord;
			} else {
				char c = char_array[0];
				int idx = Character.getNumericValue(c) - Character.getNumericValue('a');
				
				if (children[idx] == null) return false;
				
				s = s.substring(1);
				return children[idx].search(s);
			}
		}
		
		void delete(String s) {
			if (!search(s)) { //입력받은 문제가 존재하는 여부 판단
				System.out.println(s + " does not exist !");
				return;
			}
			
			TrieNode current = this; //class내 값을 전체 current로 복사 
			for (char c : s.toCharArray()) {
				int idx = Character.getNumericValue(c) - Character.getNumericValue('a');
				TrieNode delnode = current.children[idx]; //현재노의 자식노노드중 삭제하고자 하는 문자하나의 자식노드를 복사
				
				if (delnode.isWord) { //복사된 노드의 마지막문자의 단어여부 확인후 단어여부만 false로 처리하여 삭제효과냄 
					delnode.isWord = false;
					return;
				}
				
				current = delnode; //현재 node를 current로 이동
			}
		}
	}
	
	public static void main(String[] args) {
		TrieNode root = new TrieNode();
		System.out.println("--- Insert ---");		
		System.out.println(" Insert Hello"); root.insert("Hello");
		System.out.println(" Insert He"); root.insert("He");		
		System.out.println(" Insert Holy"); root.insert("Holy");
		System.out.println(" Insert House"); root.insert("House");		
		System.out.println(" Insert Java"); root.insert("Java");
		System.out.println(" Insert JAN"); root.insert("JAN");
		System.out.println(" Insert Job"); root.insert("Job");

		System.out.println("--- Search ---");
		
		System.out.println(" search for 'Hello' = " + root.search("Hello"));
		System.out.println(" search for 'Holy' = " + root.search("Holy"));
		System.out.println(" search for 'Java' = " + root.search("Java"));
		System.out.println(" search for 'Study' = " + root.search("Study"));
		System.out.println(" search for 'He' = " + root.search("He"));
		System.out.println(" search for 'Hell' = " + root.search("Hell"));
	
		System.out.println("--- Delete & Search ---");
		
		System.out.println(" Delete 'He'"); root.delete("He");		

		System.out.println(" search for 'He' after delete 'He' = " + root.search("He"));
		System.out.println(" search for 'Holy' after delete 'He' = " + root.search("Holy"));	
		System.out.println(" search for 'Hello' after delete 'He' = " + root.search("Hello"));
		
		System.out.println("--- Re-Insert ---");
		System.out.println(" Insert He"); root.insert("He");
		System.out.println(" search for 'He' = " + root.search("He"));		
	}

}

