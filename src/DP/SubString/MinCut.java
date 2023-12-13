package DP.SubString;

/**
 * @Author 年年
 * @Date 2021/12/15 9:02
 * @Description
 * LeetCode-1278：分割回文串 II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。返回符合要求的 最少分割次数 。
 */
public class MinCut {
    /**
     * 方法一：
     * boolean[][] isPalindrome[i][j]表示s.subString(i,j+1)是不是回文串
     * 递推公式：
     * i==j -> isPalindrome[i][j] = true;
     * (i!=j && s.charAt(i)==s.charAt(j)) -> isPalindrome[i][j] = (i==j-1)?true:isPalindrome[i+1][j-1];
     *
     * int[] dp[i] 表示 s.subString(0,i)最少需要几次分割
     * 递推公式:
     * if(isPalindrome[j][i-1]){dp[i] = Math.min(dp[i],dp[j]+1) | j = 0...(i-1)}
     * @param s
     * @return
     */
    public int minCut(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i =  s.length() - 1; i >= 0 ;i--){
            for (int j = i; j < s.length(); j++) {
//                if(i == j){
//                    isPalindrome[i][j] = true;
//                }else if(s.charAt(i)==s.charAt(j)){
//                    isPalindrome[i][j] = (i==j-1)?true:isPalindrome[i+1][j-1];
//                }
                if(s.charAt(i)==s.charAt(j)){
                    isPalindrome[i][j] = j-i<2||isPalindrome[i+1][j-1];
                }
            }
        }
        int[] cut = new int[s.length()+1];

        for (int i = 1; i < cut.length; i++) {
            cut[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if(isPalindrome[j][i-1])
                cut[i] = Math.min(cut[i],cut[j]+1);
            }
        }
        return cut[s.length()]-1;
    }

    public static void main(String[] args) {
        System.out.println(new MinCut().minCut("aab"));
    }
}
