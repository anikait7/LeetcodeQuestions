class Solution
{
    public int count(int n, long x, long y)
    {
        int steps=0;

        while(x<=n)
        {
            y=Math.min(y,n+1);
            steps+=y-x;

            x*=10;
            y*=10;
        }

        return steps;
    }

    public int findKthNumber(int n, int k)
    {
        int curr=1;
        k--;

        while(k>0)
        {
            int step = count(n,curr,curr+1);
            if(step<=k)
            {
                curr++;
                k-=step;
            }
            else
            {
                curr*=10;
                k--;
            }
        }

        return curr;
    }
}