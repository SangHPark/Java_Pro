package boggle_game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class othersSolution_9202 {
	private static char[][] boggleMap;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
    private static int[] dy = {-1, 1, 0, 0, 1, -1, 1, -1};
    private static Trie trie = new Trie();
    private static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\boggle_game\\mySolution_9202.txt"));
    	
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int w = Integer.parseInt(br.readLine());
            while (w-- > 0) {
                trie.insert(br.readLine());
            }
            br.readLine();
 
            int b = Integer.parseInt(br.readLine());
            while (b-- > 0) {
                boggleMap = new char[4][4];
                visited = new boolean[4][4];
 
                for (int i = 0; i < 4; i++) {
                    String line = br.readLine();
                    for (int j = 0; j < 4; j++) {
                        boggleMap[i][j] = line.charAt(j);
                    }
                }
 
                Set<String> stringSet = new HashSet<>();
                for (int y = 0; y < 4; y++) {
                    for (int x = 0; x < 4; x++) {
                        visited[y][x] = true;
                        dfs(x, y, boggleMap[y][x] + "", stringSet);
                        visited[y][x] = false;
                    }
                }
 
                setPrint(stringSet);
 
                if (b != 0) br.readLine();
            }
 
            System.out.println(sb.toString());
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
 
    private static void setPrint(Set<String> stringSet) {
        List<String> list = new ArrayList<>(stringSet);
        Collections.sort(list);
        String longestStr = "";
        int score = 0;
 
        for (String s : list) {
            if (s.length() > longestStr.length()) {
                longestStr = s;
            }
            score += getScore(s.length());
        }
 
        sb.append(score).append(" ").append(longestStr).append(" ").append(list.size()).append("\n");
    }
 
    private static int getScore(int maxLen) {
        int score = 0;
        if (maxLen <= 2) score = 0;
        else if (maxLen <= 4) score = 1;
        else if (maxLen == 5) score = 2;
        else if (maxLen == 6) score = 3;
        else if (maxLen == 7) score = 5;
        else if (maxLen == 8) score = 11;
 
        return score;
    }
 
    private static void dfs(int x, int y, String str, Set<String> stringSet) {
        if (trie.find(str, true)) { // 만약 문자열의 끝으로 설정되어있다면, set에 단어를 추가한다.
        	System.out.println("Find Text = " + str);
            stringSet.add(str);
        }
 
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
 
            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
            if (visited[ny][nx]) continue;
 
            String key = str + boggleMap[ny][nx]; // 있는지 확인해야할 문자열
            
            if (trie.find(key, false)) { // 해당 좌표까지의 문자열이 있다면, 다음 문자 탐색
                visited[ny][nx] = true;
				if (str.equals("ICP")) {
					System.out.println("LMK");
				}                
                dfs(nx, ny, key, stringSet);
                visited[ny][nx] = false;
            }
        }
    }
 
    private static class Trie {
 
        TrieNode root = new TrieNode();
 
        private void insert(String key) {
            int length = key.length();
            TrieNode currentNode = root;
 
            for (int i = 0; i < length; i++) {
                int next = key.charAt(i) - 'A';
                if (currentNode.child[next] == null) {
                    currentNode.child[next] = new TrieNode();
                    currentNode.nChild++;
                }
                currentNode = currentNode.child[next];
            }
            currentNode.isFinish = true;
        }
 
        // isCompleteString 값에 따른 의미
        //   true: 완전한 문자열을 검색할 경우
        //   false: 해당 문자열까지의 노드가 존재하는지만 알고 싶은 경우 (즉, 접두사를 포함)
        private boolean find(String key, boolean isCompleteString) {
            int length = key.length();
            TrieNode currentNode = root;
 
            for (int i = 0; i < length; i++) {
                int next = key.charAt(i) - 'A';
                if (currentNode.child[next] == null) return false;
                currentNode = currentNode.child[next];
            }
 
            return isCompleteString ? currentNode.isFinish : true;
        }
    }
 
    private static class TrieNode {
 
        TrieNode[] child = new TrieNode[26]; // 알파벳 대문자로만 이루어져 있다.
        boolean isFinish = false;
        int nChild = 0; // 자식 노드의 갯수
	}

}
