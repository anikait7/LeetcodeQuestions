class Solution 
{
    public boolean binary(int n)
    {
        StringBuilder sb = new StringBuilder();
        while(n>0)
        {
            if(n%2==0)
                sb.append("0");
            else
                sb.append("1");

            n/=2;
        }

        if(sb.toString().equals(sb.reverse().toString()))
            return true;
        else
            return false;
    }

    public int[] minOperations(int[] nums) 
    {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        list.add(0);
        set.add(0);

        //adding palindrome numbers to list
        for(int i=1;i<=5005;i++)
        {
            if(binary(i))
            {
                list.add(i);
                set.add(i);
            }
        }

        int ans[] = new int[nums.length];

        for(int i=0;i<nums.length;i++)
        {
            if(set.contains(nums[i]))
                ans[i]=0;
            else
            {
                int lb=0;   int ub=list.size()-1;

                while(lb<=ub)
                {
                    int mid = (lb+ub)/2;
                    if(nums[i]<list.get(mid))
                        ub=mid-1;
                    else
                        lb=mid+1;
                }

                int best = Integer.MAX_VALUE;

                if(lb-1>=0)
                    best = Math.min(best,nums[i]-list.get(lb-1));

                if(lb<list.size())
                    best = Math.min(best,list.get(lb)-nums[i]);

                ans[i]=best;
            }
        }

        return ans;
    }
}