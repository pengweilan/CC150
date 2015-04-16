package chap1;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters
 * For example, the string aabccccaaa would become a2b1c5a3
 * If the "compressed" string would not become smaller than the original string
 * your method should return the original string
 * You can assume the string has only upper and lower case letters(a-z).
 */

public class C1Q5 {
	private static String compress(String str) {
		if(str == null || str.isEmpty()) {
			return "";
		}
		int count = 0;
		char cur = str.charAt(0);
		
		StringBuilder res = new StringBuilder();
		for(char cha : str.toCharArray()) {
			if(cha == cur) {
				count++;
			} else {
				res.append(cur).append(String.valueOf(count));
				count = 1;
				cur = cha;
			}
		}
		res.append(cur).append(String.valueOf(count));
		return res.toString();
	}
	
	public static void main(String[] args) {
		String test = "aabccccaaa";
		String res = compress(test);
		System.out.println(res.length() < test.length() ? res : test);	
	}
}
