package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class sortNadd {

	static String S = "0KKA";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Character> myclist = new ArrayList<>();
		
		
		int sum = 0;
		boolean num_exist = false;
		
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			
			if (c >= 'A' && c <='Z') {
				
				myclist.add(c);
				
			}
			
			if (c >= '0' && c <= '9' ) {
				num_exist = true;
				sum += c - '0';
			}
		}
		

		Collections.sort(myclist);
				
		String str_result = "";
		for (int i = 0; i < myclist.size(); i ++) {
				str_result += myclist.get(i);
		}
		
		if (num_exist) {
			System.out.println(str_result + sum);
		} else {
			System.out.println(str_result);
		}
	}
			

}
