class Solution 
{
    public List<Integer> solveQueries(int[] nums, int[] queries) 
    {
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                List<Integer> temp = map.get(nums[i]);
                temp.add(i);
            }
            else
            {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(nums[i],temp);
            }
        }

        for(int i=0;i<queries.length;i++)
        {
            List<Integer> list = new ArrayList<>();
            int x=nums[queries[i]];
            
            list=map.get(x);

            if(list.size()==1)
                ans.add(-1);
            else
            {
                int key=queries[i];
                int index=Collections.binarySearch(list,key);

                if(list.size()==2)
                {
                    int y=list.get((index+1)%2);
                    int z=Math.abs(y-queries[i]);
                    ans.add(Math.min(z,nums.length-z));
                }
                else
                {
                    int y=index-1;
                    if(y==-1)
                        y=list.size()-1;

                    int z=index+1;
                    if(z==list.size())
                        z=0;

                    y=list.get(y);
                    z=list.get(z);

                    if(z-queries[i]<0)
                        z=nums.length-queries[i]+z;
                    else
                        z=z-queries[i];

                    if(queries[i]-y<0)
                        y=nums.length-y+queries[i];
                    else
                        y=queries[i]-y;

                    if(y<0)
                        ans.add(z);
                    else
                    if(z<0)
                        ans.add(y);
                    else
                        ans.add(Math.min(y,z));
                }
            }
        }

        return ans;
    }
}