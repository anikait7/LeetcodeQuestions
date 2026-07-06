class Solution 
{
    public int minScore(int n, int[][] roads) 
    {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int min=Integer.MAX_VALUE;

        for(int i=1;i<=n;i++)
            map.put(i, new ArrayList<>());

        for(int road[] : roads)
        {
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }

        boolean visited[] = new boolean[n+1];
        visited[n]=true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while(!queue.isEmpty())
        {
            int x = queue.poll();

            for(int i=0;i<map.get(x).size();i++)
            {
                if(!visited[map.get(x).get(i)])
                {
                    visited[map.get(x).get(i)]=true;
                    queue.add(map.get(x).get(i));
                }
            }
        }

        for(int road[] : roads)
        {
            if(visited[road[0]] && visited[road[1]])
                min=Math.min(min,road[2]);
        }
        
        return min;
    }
}