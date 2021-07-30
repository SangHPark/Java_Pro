package LIS;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class example_BTS2 {

	static int N = 20;
//	static int[] array = {10,20,15,30,20,50};
	static int[] list = {
			19, 3, 29, 1, 6, 10, 17, 30, 16, 6, 22, 24, 3, 1, 27, 10, 5, 11, 12, 13
	};
	
	public static void main(String[] args) {
		
//	        int[] list = {8, 2, 4, 3, 6, 11, 7, 10, 14, 5};
	        int[] LIS = new int[list.length]; // LIS�� ��밡���� ���ڸ� ����
	        int size = 0; // LIS�� ������ ������ ����
	        LIS[size++] = list[0]; // ù��° ���ڴ� �ٷ� �ݿ�
	        for (int i = 1; i < list.length; i++) {
	            if(LIS[size-1] < list[i]){
	                LIS[size++] = list[i]; // ���� �ڿ� ���̱�
	            } else{
	                int temp = Arrays.binarySearch(LIS,0, size, list[i]); // ������ ��ġ
	                if(temp < 0) temp = -temp -1;
	                LIS[temp] = list[i];
	                
	                if (temp > 0) {size = temp + 1;}
	                
	                
	            }
	        }

	        System.out.println("LIS : " + Arrays.toString(LIS));
	        System.out.println("LIS�� ���� : " + size);
	    }
    }
		



