class Solution 
{
    public int minCost(int n, int[][] edges) 
    {
        Map<Integer,List<int []>> map = new HashMap<>();
        Map<Integer,List<int []>> rev = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            map.put(i,new ArrayList<>());
            rev.put(i,new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++)
        {
            map.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
            rev.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]*2});
        }

        PriorityQueue<int []> pq = new PriorityQueue<int []>((a,b) -> a[1]-b[1]);
        boolean visited[] = new boolean[n];

        pq.add(new int[]{0,0});

        while(!pq.isEmpty())
        {
            int temp[] = pq.poll();
            if(temp[0]==n-1)
                return temp[1];

            if(visited[temp[0]])
                continue;

            visited[temp[0]]=true;

            for(int i=0;i<map.get(temp[0]).size();i++)
            {
                pq.add(new int[]{map.get(temp[0]).get(i)[0],map.get(temp[0]).get(i)[1]+temp[1]});                    
            }

            for(int i=0;i<rev.get(temp[0]).size();i++)
            {
                pq.add(new int[]{rev.get(temp[0]).get(i)[0],rev.get(temp[0]).get(i)[1]+temp[1]});                    
            }
        }

        return -1;
    }
}