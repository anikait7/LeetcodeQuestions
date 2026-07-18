class Solution 
{
    public int gcd(int a, int b)
    {
        while(a%b!=0)
        {
            int temp = a%b;
            a=b;
            b=temp;
        }

        return b;
    }

    public long gcdSum(int[] nums) 
    {
        int gcd[] = new int[nums.length];
        long sum=0;

        int max=gcd[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            max=Math.max(max,nums[i]);
            gcd[i]=gcd(max,nums[i]);
        }

        Arrays.sort(gcd);

        for(int i=0;i<gcd.length/2;i++)
            sum+=gcd(gcd[gcd.length-1-i],gcd[i]);

        return sum;
    }
}