package problems.dynamicprogramming;
import java.util.*;
public class longestIncresingSubsequence {
	 public static void main(String args[]) { 
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        while(t > 0){
	            int n = sc.nextInt();
	            int array[] = new int[n];
	            for (int i = 0; i < n; ++i)
	            {
	                array[i] = sc.nextInt();
	            }
	            Solution ob = new Solution();
	            System.out.println(ob.longestSubsequence(n,array));
	            t--;
	        }
	    } 
}
class Solution { 
    // return length of longest strictly increasing subsequence
    static int longestSubsequence(int n, int a[]){
        int dp[]=new int[n];
        int len=0;
        for(int num:a){
            int i=Arrays.binarySearch(dp,0,len,num);
            if(i<0)
            i=-(i+1);
            dp[i]=num;
            if(i==len)
            len++;
        }
        return len;
    }
} 