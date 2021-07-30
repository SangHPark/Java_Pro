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
			
			if (char_array.length == 0) { // �Լ����� ���� �迭�� ���̰� 0�̸� ���������ڿ� �ܾ�ó��
				isWord = true;				
			} else {
				char c = char_array[0]; //ù��¥ ����
				// children �迭�� Index�� 0���� ����� ���� 
				int idx = Character.getNumericValue(c) - Character.getNumericValue('a');
				if (children[idx] == null) {
					children[idx] = new TrieNode();
				}
				s = s.substring(1); //���� �ڸ��������� ����
				children[idx].insert(s); //���� �ڸ��� ���ڸ� ����Ͽ� Recursive ȣ�� 
			}
		}
		
		boolean search(String s) {
			char[] char_array= s.toCharArray();
			if (char_array.length == 0) { // ������ ������ Word�� ��ȯ
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
			if (!search(s)) { //�Է¹��� ������ �����ϴ� ���� �Ǵ�
				System.out.println(s + " does not exist !");
				return;
			}
			
			TrieNode current = this; //class�� ���� ��ü current�� ���� 
			for (char c : s.toCharArray()) {
				int idx = Character.getNumericValue(c) - Character.getNumericValue('a');
				TrieNode delnode = current.children[idx]; //������� �ڽĳ����� �����ϰ��� �ϴ� �����ϳ��� �ڽĳ�带 ����
				
				if (delnode.isWord) { //����� ����� ������������ �ܾ�� Ȯ���� �ܾ�θ� false�� ó���Ͽ� ����ȿ���� 
					delnode.isWord = false;
					return;
				}
				
				current = delnode; //���� node�� current�� �̵�
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

