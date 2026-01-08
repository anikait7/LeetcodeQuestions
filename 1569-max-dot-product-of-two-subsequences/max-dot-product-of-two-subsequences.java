class Solution 
{
    public int recursive(int dp[][], int x, int y, int nums1[], int nums2[])
    {
        if(x==nums1.length || y==nums2.length)
            return -1000001;

        if(dp[x][y]!=-1000001)
            return dp[x][y];

        int a = nums1[x]*nums2[y];
        int next = recursive(dp,x+1,y+1,nums1,nums2);
        if(next>0)
            a+=next;

        int skip1 = recursive(dp,x+1,y,nums1,nums2);
        int skip2 = recursive(dp,x,y+1,nums1,nums2);

        return dp[x][y]=Math.max(a,Math.max(skip1,skip2));
    }


    public int maxDotProduct(int[] nums1, int[] nums2) 
    {
        int x = nums1.length;   int y = nums2.length;

        int dp[][] = new int[x][y];
        for(int i=0;i<x;i++)
            Arrays.fill(dp[i], -1000001);

        return recursive(dp,0,0,nums1,nums2);
    }
}