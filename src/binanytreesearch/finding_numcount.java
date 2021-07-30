package binanytreesearch;

public class finding_numcount {
	static int N = 7;
	static int X = 2;
	static int[] ary = {1, 1, 1, 1, 1, 2, 2};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start = 0;
		int end = N - 1;
		
		int xpos = -1;
		int xpos_1, xpos_2 = -1;
		
		int startidx = -1;
		int endidx = -1;

		int result = -1;
		xpos = finding_x (start, end);
		if ( xpos == -1) {
			result = -1;
		} else {

			// 1st half		
			start = 0;
			end = xpos - 1;
			
			if (ary[start] == X) startidx = 0;
			else {
				xpos_1 = finding_x (start, end);
				if (xpos_1 == -1) {
					startidx = xpos; 
				} else {
					startidx = xpos_1;
				}
			}
				
			
			// 2nd half		
			
			start = xpos + 1;
			end = N-1;
			if (ary[end] == X) endidx = N-1;
			else {
				xpos_2 = finding_x (start, end);
				if (xpos_2 == -1) {
					endidx = xpos; 
				} else {
					endidx = xpos_2;
				}
			}
			
			result = endidx - startidx+1;
		}
		
		System.out.println(result);
	}
	
	static int finding_x(int s, int e) {
		int start = s;
		int end = e;
		

		
		while (start <= end) {
			int mid = (start + end) / 2;
			
			if (ary[mid] > X) {
				end = mid - 1;
			} else if (ary[mid] < X) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		
		return -1;
	}

}
