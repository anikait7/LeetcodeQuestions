class Solution
{
    public int countPermutations(int[] complex)
    {
        int len = complex.length;
        int min = complex[0];
        int MOD = 1000000007;
        long ans=1;

        for(int i=1;i<len;i++)
            if(min>=complex[i])
                return 0;

        for(int i=1;i<complex.length;i++)
        {
            ans*=i;
            ans%=MOD;
        }

        return (int)ans;
    }
}