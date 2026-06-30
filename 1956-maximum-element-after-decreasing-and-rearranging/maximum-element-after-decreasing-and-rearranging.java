class Solution 
{
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<arr.length;i++)
            pq.add(arr[i]);

        pq.poll();
        int max=1;
        while(!pq.isEmpty())
        {
            int temp = pq.poll();
            if(max<temp)
                max=Math.min(temp,max+1);
        }

        return max;
    }
}