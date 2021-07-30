package LIS;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class example_BTS {

	static int N = 3;
//	static int[] array = {10,20,15,30,20,50};
	static int[] array = {
			524,
			447,
			550
	};
	
	public static void main(String[] args) {
		
//        int n = scan.nextInt();
//        int[] array = new int[n];
//        for(int i=0;i<n;i++)
//        {
//            array[i] = scan.nextInt();
//        }
        
        int[] ans = new int[N];
        int idx = 0;
        ans[0] = array[0];
        
        for(int i=1;i<N;i++)
        {
            if(ans[idx]<array[i])
            {
                idx++;
                ans[idx] = array[i];
            }
            else
            {
                int start = 0;
                int end = idx;
                int mid;
                while(end>start)
                {
                    mid = (start+end) /2;
                    if(ans[mid] < array[i])
                    {
                        start = mid+1;
                    }
                    else
                    {
                        end = mid;
                    }
                }
                ans[end] = array[i];
            }
        }
        System.out.println(idx+1);
    }
		


		
	}


