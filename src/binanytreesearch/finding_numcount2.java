package binanytreesearch;

//With making upper bound, lower bound
//but logic error

public class finding_numcount2 {
	static int N = 7;
	static int X = 2;
	static int[] ary = {1, 1, 1, 1, 1, 2, 3};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start = 0;
		int end = N - 1;
		
		int startidx = lower_bound();
		int endidx = upper_bound();
		
		
		System.out.println(endidx - startidx + 1);
	}
	
	static int lower_bound() {
		int start = 0;
		int end = N - 1;
		
		while (start < end) {
			int mid = (start + end) / 2;
			
			if (ary[mid] >= X) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
		}
		return end;
	}

	static int upper_bound() {
		int start = 0;
		int end = N - 1;
		
		while (start < end) {
			int mid = (start + end) / 2;
			
			if (ary[mid] <= X) {
				start = mid + 1;
			}
			else {
				end = mid;
			}
		}
		return end;
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
