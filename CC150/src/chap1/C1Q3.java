package chap1;

/**
 * Question: Given two strings, write a method to decides if one is a permutation of the other.
 */
public class C1Q3 {
    private static boolean isPermutation(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }
        int[] flag = new int[256];

        for(int i = 0; i < str1.length(); i++) {
            int index = Character.getNumericValue(str1.charAt(i));
            flag[index]++;
        }

        for(int i = 0; i< str2.length();i++) {
            int index = Character.getNumericValue(str2.charAt(i));
            if(--flag[index] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for(String[] pair : pairs) {
            String str1 = pair[0];
            String str2 = pair[1];
            System.out.println(str1 + "," + str2 + ":" + isPermutation(str1, str2));
        }
    }
}