package chap1;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */

public class C1Q1 {
    private static boolean isCharUnique(String word) {
        if(word.length() > 256) {
            return false;
        }
        boolean[] flag = new boolean[256];
        for(char cha : word.toCharArray()) {
            int val = Character.getNumericValue(cha);
            if(flag[val]) {
                return false;
            } else {
                flag[val] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testWords = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : testWords) {
            System.out.println(word + ":" + isCharUnique(word));
        }
    }
}
