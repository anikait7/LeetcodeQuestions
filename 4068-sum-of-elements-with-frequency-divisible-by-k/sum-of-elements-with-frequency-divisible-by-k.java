class Solution 
{
    public int sumDivisibleByK(int[] nums, int k) 
    {
        int sum=0;
        int f[] = new int[101];

        for(int i : nums)
            f[i]++;

        for(int i=1;i<=100;i++)
            if(f[i]%k==0)
                sum+=i*f[i];

        return sum;
    }
}