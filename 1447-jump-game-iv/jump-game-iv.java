class Solution 
{
    public int minJumps(int[] arr) 
    {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++)
            map.computeIfAbsent(arr[i], k-> new ArrayList<>()).add(i);

        boolean visited[] = new boolean[arr.length];

        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{0,0}); //index,count
        visited[0]=true;

        while(!queue.isEmpty())
        {
            int temp[] = queue.poll();

            int idx = temp[0];
            int cost = temp[1];

            if(idx==arr.length-1)
                return cost;

            if(idx+1<arr.length && !visited[idx+1])
            {
                visited[idx+1]=true;
                queue.add(new int[]{idx+1,cost+1});
            }

            if(idx-1>=0 && !visited[idx-1])
            {
                visited[idx-1]=true;
                queue.add(new int[]{idx-1,cost+1});
            }

            if(map.containsKey(arr[idx]))
            {
                for(int i=0;i<map.get(arr[idx]).size();i++)
                {
                    if(!visited[map.get(arr[idx]).get(i)])
                    {
                        visited[map.get(arr[idx]).get(i)]=true;
                        queue.add(new int[]{map.get(arr[idx]).get(i),cost+1});
                    }
                }
                map.remove(arr[idx]);
            }
        }

        return 100;
    }
}