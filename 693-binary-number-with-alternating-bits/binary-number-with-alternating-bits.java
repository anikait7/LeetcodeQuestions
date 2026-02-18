class Solution 
{
    public boolean hasAlternatingBits(int n) 
    {
        int mod = n%2;
        n/=2;

        while(n>0)
        {
            if(mod==n%2)
                return false;

            mod=n%2;
            n/=2;
        }



        return true;
    }
}