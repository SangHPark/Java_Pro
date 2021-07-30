package LIS;

import java.util.Arrays;

	public class example_BTS3 {
	    public static void main(String[] args) {
	        int[] list = {19, 3, 29, 1, 6, 10, 17, 30, 16, 6, 22, 24, 3, 1, 27, 10, 5, 11, 12, 13};
//	        int[] list = {1,2,3,4, 30,3,27,5,11,12,13};
	        int[] LIS = new int[list.length]; // LIS�� ��밡���� ���ڸ� ����
	        int size = 0; // LIS�� ������ ������ ����
	        LIS[size++] = list[0]; // ù��° ���ڴ� �ٷ� �ݿ�
	        for (int i = 1; i < list.length; i++) {
	            if(LIS[size-1] < list[i]){
	                LIS[size++] = list[i]; // ���� �ڿ� ���̱�
	            }else{
	                int temp = Arrays.binarySearch(LIS,0, size, list[i]); // ������ ��ġ
	                if(temp < 0) temp = -temp -1;
	                LIS[temp] = list[i];
	            }
	        }

	        System.out.println("LIS : " + Arrays.toString(LIS));
	        System.out.println("LIS�� ���� : " + size);
	    }
	}
