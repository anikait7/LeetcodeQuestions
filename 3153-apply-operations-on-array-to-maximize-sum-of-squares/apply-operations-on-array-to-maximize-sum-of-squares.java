class Solution 
{
    public int maxSum(List<Integer> nums, int k) 
    {
        int bits[] = new int[32];

        //index 0 = leftmost bit
        // index 31 = rightmost bit

        for(int i=0;i<32;i++)
        {
            int x = 1<<i;

            for(int j : nums)            
                if((j&x) != 0)
                    bits[i]++;
            
        }

        long sum=0;

        for(int i=1;i<=k;i++)
        {
            int temp=0;
            for(int j=31;j>=0;j--)
            {
                if(bits[j]>0)
                {
                    bits[j]--;
                    temp|=(1<<j);
                }
            }

            if(temp==0)
                break;

            sum+=1L*temp*temp;
            sum%=1000000007;
        }

        return (int)sum;
    }
}