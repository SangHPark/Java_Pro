package bin_powerset;

public class Main {

	public static void main(String[] args) {
		int i, j;
		int [] arr = new int[] {3,6,7,1,5,4};
	    int n = 6;
	    
//	    i = 2;
//	    System.out.println(i<<6);
	    
	    
//	    for (i= 0; i < n; i ++) {
//	    	System.out.println(i + " " + (i << n));
//	    }
	    
	    for (i = 0; i < (1 << (n)) ;  ++i ) {
	    	for (j =0; j < n; ++j) {
	    		System.out.println(i & (1 << j));
//	    			System.out.println(arr[j]);
	    		}
//	    	System.out.println(i);
	    	
	    }
		

	}

}
