class Solution 
{
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) 
    {
        Set<Integer> set = new HashSet<>();
        set.add(firstPerson);
        set.add(0);

        Arrays.sort(meetings, (a,b) -> Integer.compare(a[2],b[2]));


        int i=0;
        while(i<meetings.length)
        {
            int time=meetings[i][2];
            int j=i;
            Map<Integer, List<Integer>> map = new HashMap<>();

            while(j<meetings.length && meetings[j][2]==time)
            {
                map.computeIfAbsent(meetings[j][0], k-> new ArrayList<>()).add(meetings[j][1]);
                map.computeIfAbsent(meetings[j][1], k-> new ArrayList<>()).add(meetings[j][0]);
                j++;
            }

            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();

            for(int key : map.keySet())
            {
                if(set.contains(key))
                {
                    queue.add(key);
                    visited.add(key);
                }
            }

            while(!queue.isEmpty())
            {
                int xyz = queue.poll();
                for(int abc : map.get(xyz))
                {
                    if(!visited.contains(abc))
                    {
                        queue.add(abc);
                        visited.add(abc);
                    }
                }
            }

            set.addAll(visited);
            i=j;
        }

        // List<Integer> ans = new ArrayList<>();
        // for(int ele : set)
        //     ans.add(ele);

        return new ArrayList<>(set);
    }
}