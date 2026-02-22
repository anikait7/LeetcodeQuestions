class Solution 
{
    public int binaryGap(int n) 
    {
        int ans=0;
        int temp=0;
        int prev=0;
        int c=0;

        while(n>0)
        {
            if(n%2==0 && prev==1)
                temp++;
            else
            if(n%2==1)
            {
                c++;
                ans=Math.max(ans,temp);
                temp=0;
                prev=1;
            }

            n/=2;
        }

        return c>1 ? ans+1 : 0;
    }
}