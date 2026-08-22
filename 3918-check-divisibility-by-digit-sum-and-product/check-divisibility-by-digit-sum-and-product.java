class Solution 
{
    public boolean checkDivisibility(int n) 
    {
        int pro=1;
        int sum=0;
        int b=n;

        while(b>0)
        {
            pro*=(b%10);
            sum+=(b%10);
            b/=10;
        }

        return n%(pro+sum)==0;        
    }
}