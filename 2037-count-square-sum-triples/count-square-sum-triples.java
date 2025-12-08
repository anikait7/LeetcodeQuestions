class Solution 
{
    public int countTriples(int n) 
    {
        int c=0;

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                int x=i*i+j*j;
                double z = Math.sqrt(x*1.0);
                if(z==(int)z && z<=n)
                    c++;
            }
        }

        return c;
    }
}