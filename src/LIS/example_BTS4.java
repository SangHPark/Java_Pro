package LIS;

import java.util.Arrays;

	public class example_BTS4 {
	    public static void main(String[] args) {
	        int[] list = {19, 3, 29, 1, 6, 10, 17, 30, 16, 6, 22, 24, 3, 1, 27, 10, 5, 11, 12, 13};
	        int[] LIS = new int[list.length]; // LIS로 사용가능한 숫자를 저장
	        int size = 0; // LIS의 개수를 관리할 변수
	        for (int i = 0; i < list.length; i++) {
	        	int temp = Arrays.binarySearch(LIS,0, size, list[i]); // 삽입할 위치
	        	if(temp < 0) temp = -temp -1;
	        	 LIS[temp] = list[i];

	        	 if (temp == size) ++size;
	        }

	        System.out.println("LIS : " + Arrays.toString(LIS));
	        System.out.println("LIS의 개수 : " + size);
	    }
	}
