class Solution 
{
    public int[] findXSum(int[] nums, int k, int x) 
    {
        int n = nums.length;
        int arr[] = new int[n-k+1];

        Map<Integer,Integer> map = new HashMap<>();
        int left=0;     

        //Frequency calculation till 0 to k-2 Total k-1 elements
        for(int i=0;i<k-1;i++)
            map.merge(nums[i],1,Integer::sum);


        for(int i=k-1;i<n;i++)
        {   
            //making the size k
            map.merge(nums[i],1,Integer::sum);
            
            //initializing the queue as per requirement
            PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> {
                if(b[1]!=a[1])
                    return b[1]-a[1];
                else
                    return b[0]-a[0];
            });

            //adding elements to the queue
            for(Map.Entry<Integer,Integer> entry : map.entrySet())
                pq.add(new int[]{entry.getKey(),entry.getValue()});

            int sum=0;
            int y = pq.size();

            //helps in getting top x sum (even if pq contains less than x elements it will work fine)
            for(int j=0;j<Math.min(x,y);j++)
            {
                int temp[] = pq.poll();
                sum+=temp[0]*temp[1];
            }

            arr[left]=sum;
            //removing the left index making the total element k-1
            map.put(nums[left],map.get(nums[left++])-1);
        }

        return arr;
    }
}