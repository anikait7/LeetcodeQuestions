class Solution 
{
    public int minimumDistance(int[] nums) 
    {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i], new PriorityQueue<>()));
            map.get(nums[i]).add(i);
        }

        int min =Integer.MAX_VALUE;

        for(Map.Entry<Integer,PriorityQueue<Integer>> entry : map.entrySet())
        {
            if(entry.getValue().size()>=3)
            {
                int x = entry.getValue().poll();
                int y = entry.getValue().poll();
                while(!entry.getValue().isEmpty())
                {
                    int z = entry.getValue().poll();
                    min=Math.min(min,z*2-x*2);
                    x=y;
                    y=z;
                }
            }
        }

        if(min==Integer.MAX_VALUE)
            return -1;

        return min;
    }
}