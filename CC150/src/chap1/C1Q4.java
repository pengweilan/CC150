package chap1;

/**
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end of the string to hold the additional characters,
 * and that you are given the "true" length of the string.
 */
public class C1Q4 {
    private static int spaceCount(char[] str) {
        int spaceCount = 0;
        for(char cha : str) {
            if(cha == ' ') {
                spaceCount++;
            }
        }
        return spaceCount;
    }

    private static char[] replaceSpace (char[] str, int len) {
        int space = spaceCount(str);

        int newLen = len + space * 2;
        str[--newLen] = '\0';

        for(int i = len - 1; i > -1; i--) {
            if(str[i] == ' ') {
                str[newLen] = '0';
                str[newLen - 1] = '2';
                str[newLen - 2] = '%';
                newLen = newLen - 3;
            } else {
              str[newLen] = str[i];
                newLen--;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String str = " hello my world ";
        char[] arr = new char[str.length() + spaceCount(str.toCharArray()) * 2 + 1];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        System.out.println(new String(replaceSpace(arr, str.length())));
    }
}
