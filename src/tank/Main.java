package tank;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
       static int N, T;
//       static Tank[] tanks = new Tank[100001];
       
       public static void main(String[] args) throws Exception {
    	   
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */
		
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\Downloads\\sample_input_Tank.txt"));
		
		/*
		   Make new scanner from standard input System.in, and read data.
		 */		
              Scanner sc = new Scanner(System.in);
              T = sc.nextInt();
              for (int t=1; t<=T; ++t) {
            	  long startTime = System.currentTimeMillis();
            	  
            	  
              N = sc.nextInt();
              Tank[] tanks = new Tank[N];
              for (int i = 0; i < N; ++i) {
                     Tank a = new Tank();
                           a.x = sc.nextInt();
                           a.y = sc.nextInt();
                           a.score = sc.nextInt();
                           tanks[i] = a;
              }
              
//              System.out.println("#");
//              Arrays.sort(tanks,  Collections.reverseOrder());        
              Arrays.sort(tanks);
//              for (int i = 0; i < N ; ++i) {
//                  System.out.println( tanks[i].x + " " + tanks[i].y + " " + tanks[i].score);
//              }  
              long sum = 0;
            for (int i = 0; i < N ; ++i) {
//                   System.out.println( tanks[i].x + " " + tanks[i].y + " " + tanks[i].score);
//                   sum = tanks[i].score;
//                   tanks[i].sumscore = tanks[i].score;
                   sum = 0;
                   for (int j = i + 1; j < N; ++j) {
	                	if (tanks[i].y < tanks[j].y ) {
	                		sum += tanks[j].score;
	                		tanks[i].sumscore = sum;
	                	}
//	                	System.out.println(sum);
	                	
                   }
            }
             
            
//            addScore(0);
              
              long result = 0;
              for (int i =0; i <N; ++i) {
//                     result += addScore(0);
            	  result +=tanks[i].sumscore;
              }
              
              long endTime = System.currentTimeMillis();
              
              System.out.println("#" + t + " " + result + " elapseTime="+(endTime-startTime)/1000.0);
              }
       }
       

       static class Tank implements  Comparable<Tank>{
              int x;
              int y;
              int score;
              long sumscore;
              @Override
              public int compareTo(Tank t) {
                     if (this.x > t.x) return 1;
                     else if (this.x < t.x) return -1;
                     else return 0;
              }
              
       }

}
