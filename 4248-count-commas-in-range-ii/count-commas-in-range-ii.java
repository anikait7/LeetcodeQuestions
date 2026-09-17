class Solution 
{
    public long countCommas(long n) 
    {
        long count=0;

        long x = 999;

        while(x<=n)
        {
            count+=n-x;
            x = (x+1)*1000-1;
        }

        

        return count;
    }
}