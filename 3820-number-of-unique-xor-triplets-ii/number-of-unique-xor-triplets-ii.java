class Solution 
{
    public int uniqueXorTriplets(int[] nums) 
    {
        int max=nums[0];

        for(int i : nums)
            max=Math.max(max,i);

        int bit=1;
        while(bit<=max)
            bit<<=1;

        //one = single XOR  two = twice XOR three = Two XOR one
        boolean one[] = new boolean[bit];
        boolean two[] = new boolean[bit];
        boolean three[] = new boolean[bit];

        for(int i : nums)
        {
            one[i]=true;
            for(int x=0;x<bit;x++)
            {
                if(one[x])
                    two[x^i]=true;
            }
        }

        for(int i : nums)
        {
            for(int x=0;x<bit;x++)
            {
                if(two[x])
                    three[x^i]=true;
            }
        }

        int cnt=0;
        for(boolean i : three)
            if(i)
                cnt++;

        return cnt;
    }
}