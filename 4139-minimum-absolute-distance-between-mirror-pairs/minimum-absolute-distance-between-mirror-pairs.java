class Solution 
{
    //better method reverse every current number and check if the reverse existed in the past. Since with every update
    //the old reverse pos is getting replaced by the latest no need of pq. Integer works well.

    public int minMirrorPairDistance(int[] nums) 
    {
        int dist=nums.length;
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();

        for(int i=1;i<nums.length;i++)
        {
            map.putIfAbsent(nums[i], new PriorityQueue<>());
            map.get(nums[i]).add(i);
        }

        for(int i=0;i<nums.length;i++)
        {
            int rev=0;
            while(nums[i]>0)
            {
                rev=rev*10+nums[i]%10;
                nums[i]/=10;
            }

            if(map.containsKey(rev))
            {
                PriorityQueue<Integer> pq = map.get(rev);
                while(!pq.isEmpty() && pq.peek()<=i)
                    pq.poll();

                if(!pq.isEmpty())
                    dist=Math.min(dist,pq.peek()-i);
            }
        }

        if(dist==nums.length)
            return -1;

        return dist;
    }
}