package greedy;

public class addormultiple {
	static String S = "313";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String operator = "";
		int pre_x = 0;
		int x = 0;
		int result = 0;
		
		result = S.charAt(0) - '0';
		
		
		for (int i = 1; i < S.length(); i ++) {
			int num = S.charAt(i) - '0';
			if (num <=1 || result <=1) {
				result += num;
			} else {
				result *= num;
			}
		}
		
		
		
		System.out.println(result);
	}
	

}
