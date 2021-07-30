package greedy;

import java.util.Arrays;

public class explorer_guild {

	static int N = 5;
	static int[] exp = {2, 3, 1, 2, 2};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Arrays.sort(exp);
		
		int group_cnt = 0;
		int count = 0;
		for (int i=0; i <exp.length; i++ ) {
			count ++;
			if (count >= exp[i]) {
				group_cnt ++;
				count = 0;
			}
		}
		
		System.out.println(group_cnt);
	}

}
