package problems.dynamicprogramming;
import java.util.*;
public class distinctOccurrences {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			String S = sc.next();
			String T = sc.next();
			
			GfG g = new GfG();
			System.out.println(g.subsequenceCount(S,T));
		}
	}
}
class GfG
{
    int  subsequenceCount(String s, String t)
    {
	int dp[][]=new int[t.length()+1][s.length()+1];
	for(int j=0;j<=s.length();j++)
	dp[0][j]=1;
	for(int i=0;i<t.length();i++){
	    for(int j=0;j<s.length();j++){
	        if(t.charAt(i)==s.charAt(j))
	        dp[i+1][j+1]=(dp[i][j]+dp[i+1][j])%1000000007;
	        else
	        dp[i+1][j+1]=(dp[i+1][j])%1000000007;
	    }
	}
	return dp[t.length()][s.length()];
    }
}
