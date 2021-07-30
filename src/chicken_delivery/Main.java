package chicken_delivery;

import java.util.Scanner;
import java.util.Vector;

public class Main {
    static int n, m, type, ret;
    Vector<POSI> house, ship, pick;
    
    
	public static void main(String[] args) {
		POSI target;
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for (int y = 0; y < n; ++y) {
			for (int x = 0; x < m; ++x) {
				type = sc.nextInt();
				if (type == 1) {
					
				}
				if (type == 2) {
					
				}
			}
		}

	}
	
	class POSI {
		int y, x;
	}

}
