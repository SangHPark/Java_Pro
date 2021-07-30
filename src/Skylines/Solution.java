package Skylines;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

//	2
//	4
//	1 5
//	2 4
//	3 5
//	4 7
//	8
//	7 3
//	12 1
//	2 9
//	11 7
//	7 2
//	4 3
//	9 4
//	5 5
	
	static long[] ans = new long[200000];
	static long[] arr = new long[200000];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int i, j;
		int T;
		 
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <=T; ++test_case) {
			int cnt = 0;
			
			int n = sc.nextInt();
			
			HashMap<Long, Integer> map = new HashMap<>();
			
			for (i = 0; i < 200000; i++) {
				arr[i] = 0;
			}
			
			for (i=0; i < n; i++) {
				long x = sc.nextInt();
				long y = sc.nextInt();
				
				map.put(x * 1000000001 + y, i + 1);
				arr[i] = x * 1000000001 + y;
				
				
			}
			
			Arrays.sort(arr, 0, n);
			
			long min = 2000000000;
			
			for (i = 0; i <n; i++) {
				long x = arr[i] / 1000000001;
				long y = arr[i] % 1000000001;
				
				if (min > y ) {
					min = y;
					
					ans[cnt] = map.get(arr[i]);
					cnt ++;
				}
			}
			
			System.out.print("#" + test_case + " ");
			for (i =0; i<cnt; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println(" ");
		}

	}

}
