package tank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
       static int N, T;
//       static Tank[] tanks = new Tank[100001];
       
       public static void main(String[] args) {
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
//                           a.x_rank = i;

//                     tanks[i] = a;
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
