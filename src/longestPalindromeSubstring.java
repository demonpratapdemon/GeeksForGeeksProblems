import java.util.*;
import java.io.*;
public class longestPalindromeSubstring {
	public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String str = br.readLine().trim();
            Solution sln = new Solution();
            System.out.println(sln.longestPalindrome(str));
        }
    }
}
class Solution {
    // complete this function
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0)
        return "";
        int start=-1;
        int max_len =0;
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        for(int i=0;i<n;i++)
        dp[i][i]=true;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                dp[j][i]=s.charAt(i)==s.charAt(j)&&(i-j<3||dp[j+1][i-1]);
                if(dp[j][i]){
                    int len=i-j+1;
                    if(len>max_len){
                        max_len=len;
                        start=j;
                    }
                }
            }
        }
        if(start!=-1)
        return s.substring(start,start+max_len);
        return String.valueOf(s.charAt(0));
    }
}