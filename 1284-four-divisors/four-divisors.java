class Solution 
{
    public int sumFourDivisors(int[] nums) 
    {
        int sum=0;

        for(int i : nums)
        {
            int c=0;         int temp=0;

            for(int j=2;j*j<=i;j++)
            {
                if(i%j!=0)
                    continue;

                int d1 = i/j;   int d2=j;

                if(d1==d2)
                {
                    temp+=d1;
                    c++;
                }
                else
                {
                    c+=2;
                    temp+=d1+d2;
                }

                if(c>2)
                    break;
            }

            if(c==2)
                sum+=temp+1+i;
        }

        return sum;
    }
}