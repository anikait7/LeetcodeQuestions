class Solution 
{
    public int mirrorDistance(int n) 
    {
        int copy=n;
        int r=0;

        while(copy>0)
        {
            r=r*10+copy%10;
            copy/=10;
        }

        return Math.abs(n-r);
    }
}