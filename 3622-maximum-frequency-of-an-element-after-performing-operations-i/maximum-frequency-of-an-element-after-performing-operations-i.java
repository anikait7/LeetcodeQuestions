class Solution 
{
    public int maxFrequency(int[] nums, int k, int numOperations) 
    {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        Arrays.sort(nums);

        int size = nums[n-1]+2;
        int pre[] = new int[size];

        for(int i=0;i<n;i++)
        {
            int min = Math.max(0,nums[i]-k);
            pre[min]++;

            int max = Math.min(nums[n-1],nums[i]+k);
            pre[max+1]--;

            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }

        int max=0;
        for(int i=1;i<pre.length;i++)
            pre[i]+=pre[i-1];

        for(int i=0;i<pre.length;i++)
        {
            if(map.containsKey(i))
                max=Math.max(max,map.get(i)+Math.min(pre[i]-map.get(i),numOperations));
            else
                max=Math.max(max,Math.min(pre[i],numOperations));
        }

        return max;
    }
}