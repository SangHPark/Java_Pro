package LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

	
	
	public class example_BTS5 {
		static List<Integer> LIS;
		static int lowerbound(int n) {
			int s = 0;
			int e = LIS.size();
			int m;
			while (s < e) {
				m = (s + e ) / 2;
				if (LIS.get(m) < n) s = m + 1;
				else e = m;
			}
			return e;
		}
		
	    public static void main(String[] args) {
	        int[] list = {19, 3, 29, 1, 6, 10, 17, 30, 16, 6, 22, 24, 3, 1, 27, 10, 5, 11, 12, 13};
	        
	        
	        LIS = new ArrayList<Integer>();
	        LIS.add(0);
	        
	        int lb;
	        for (int i = 1; i < list.length; i ++) {
	        	lb = lowerbound(list[i]);
	        	if (LIS.size() == lb) 
	        		LIS.add(list[i]);
	        	else {
	        		if (LIS.get(lb) > list[i])
	        			LIS.set(lb, list[i]);
	        	}
	        }
	        
	        for (int i = 0; i < LIS.size(); i ++ ) {
	        	System.out.print(LIS.get(i) + " ");
	        }
	        
	        System.out.println(LIS.size() - 1);
	        

	    }
	}
