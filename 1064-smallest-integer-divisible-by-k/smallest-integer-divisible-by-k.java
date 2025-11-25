class Solution 
{
    public int smallestRepunitDivByK(int k) 
    {
        if(k%2==0 || k%5==0) 
            return -1;

        int len=1;
        int num=1;

        while(num!=0)
        {
            if(num%k==0)
                return len;

            len++;
            num=num*10+1;
            num%=k;
        }

        return len;
    }
}