class Solution 
{
    int dp[];

    public int recursive(int arr[], int d, int index)
    {
        if(index<0 || index>=arr.length)
            return 0;

        if(dp[index]!=0)
            return dp[index];

        int x=1;
        int y=1;

        for(int i=index+1;i<=Math.min(arr.length-1,index+d);i++)
        {
            if(arr[index]>arr[i])
                x = Math.max(x,1+recursive(arr,d,i));
            else
                break;
        }

        for(int i=index-1;i>=Math.max(0,index-d);i--)
        {
            if(arr[index]>arr[i])
                y = Math.max(y,1+recursive(arr,d,i));
            else
                break;
        }

        return dp[index]=Math.max(x,y);
    }

    public int maxJumps(int[] arr, int d) 
    {
        int n = arr.length;
        dp = new int[n];

        for(int i=0;i<n;i++)
            dp[i]=recursive(arr, d, i);

        int max=0;
        for(int i : dp)
            max=Math.max(max,i);

        return max;
    }
}