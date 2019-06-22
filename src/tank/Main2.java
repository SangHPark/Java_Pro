package tank;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


public class Main2 {
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
                           tanks[i] = a;
              }
              
//              System.out.println("#");
//              Arrays.sort(tanks,  Collections.reverseOrder());
              
              int [] sorted_y = new int [N];
              for (int i = 0; i < N ; ++i) {
            	  sorted_y[i] = tanks[i].y;
              }

              Arrays.sort(sorted_y);
              
              TreeSet<Integer> set=new TreeSet<Integer>();              
              for (int i = 0; i < N ; ++i) {
                set.add(sorted_y[i]);  
                
                Iterator iter = set.iterator();  
                while(iter.hasNext())  
                {  
                    System.out.println(iter.next());  
                }  
              }
              
              if (set.equals(3)) {System.out.println("find 6");
              
              }
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
              
              class Node_y {
            	int data;
            	Node_y left;
            	Node_y right;
            	Node_y (int data) {
            		this.data = data;
            	}
              }
              
              public void searchBTree(Node_y n, int find) {
      			if (find < n.data ) {
    				System.out.println("Data is smaller than " + n.data);
    				searchBTree(n.left, find);
    			}
    			else if (find > n.data ) {
    				System.out.println("Data is bigger than " + n.data);
    				searchBTree(n.right, find);
    			}
    			else {
    				System.out.println("Data found!"); 
    			}
              }
              
=======
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
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
		
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\Downloads\\sample_input_Tank1.txt"));
		
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
>>>>>>> branch 'master' of https://github.com/SangHPark/Java_Pro.git
              @Override
              public int compareTo(Tank t) {
                     if (this.x > t.x) return 1;
                     else if (this.x < t.x) return -1;
                     else return 0;
              }
              
       }

}
