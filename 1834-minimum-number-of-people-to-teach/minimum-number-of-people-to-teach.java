class Solution 
{
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) 
    {
        int x = languages.length;
        //  person with friends
        Map<Integer,List<Integer>> friends = new HashMap<>();
        for(int i=1;i<=x;i++)
            friends.put(i,new ArrayList<>());

        for(int a[] : friendships)
        {
            friends.get(a[0]).add(a[1]);
            friends.get(a[1]).add(a[0]);
        }

        //  person with language
        Map<Integer,Set<Integer>> lang = new HashMap<>();
        for(int i=1;i<=languages.length;i++)
            lang.put(i,new HashSet<>());

        for(int i=0;i<languages.length;i++)
            for(int j=0;j<languages[i].length;j++)
                lang.get(i+1).add(languages[i][j]);

        Set<Integer> set = new HashSet<>();

        for(int i=1;i<=x;i++)
        {
            List<Integer> temp = friends.get(i);
            for(int j=0;j<temp.size();j++)
            {
                Set<Integer> set1 = lang.get(i);
                Set<Integer> set2 = lang.get(temp.get(j));

                boolean flag=false;
                for(int a : set1)
                {
                    if(set2.contains(a))
                    {
                        flag=true;
                        break;
                    }
                }

                if(!flag)
                {
                    set.add(i);     set.add(temp.get(j));
                }
            }   
        }

        int freq[] = new int[n+1];
        for(int a : set)
        {
            for(int j=0;j<languages[a-1].length;j++)
                freq[languages[a-1][j]]++;
        }

        int max=-1;
        for(int i : freq)
            max=Math.max(max,i);

        return set.size()-max;
    }
}