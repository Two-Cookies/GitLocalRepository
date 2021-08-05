/**
 *5.最长回文子串
 *      给你一个字符串 s，找到 s 中最长的回文子串
 */

public class LC0005 {

    public static void main(String[] args) {
        String s ="babad";
        String s1 ="cbba";
        System.out.println(longestPalindromeTest(s1));
    }

    public static String longestPalindromeTest(String s) {
        int len = s.length();
        if (len<2)return s;

        boolean dp[][] = new boolean[len][len];
        for (int i = 0;i<len;i++){
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        int maxlength =1,start = 0;
        for (int j = 1;j<len;j++){
            for (int i = 0;i<j;i++){
                if (chars[i] == chars[j]){
                    if (j-i<3)
                        dp[i][j] = true;
                    else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j-i+1>maxlength){
                    start = i;
                    maxlength = j-i+1;
                }
            }
        }
        return s.substring(start,start+maxlength);
    }




















    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len<2) return s;

        boolean[][] dp = new boolean[len][len];
        for (int i = 0;i<len;i++){
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();

        int maxlength = 0,start = 0;
        for (int j = 1;j<len;j++){
            for (int i = 0;i < j;i++){
                if (chars[i]!=chars[j]){
                    dp[i][j] = false;
                }else {
                    if (j-i<3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i+1][j-1];
                }

                if (dp[i][j] && maxlength<j-i+1) {
                    maxlength = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start,start+maxlength);
    }
}
