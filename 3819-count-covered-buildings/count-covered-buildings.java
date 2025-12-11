class Solution 
{
    public int countCoveredBuildings(int n, int[][] buildings) 
    {
        int count=0;
        int len=buildings.length;

        int row_build[][] = new int[len][2];
        int col_build[][] = new int[len][2];

        for(int i=0;i<len;i++)
        {
            row_build[i][0]=buildings[i][0];
            row_build[i][1]=buildings[i][1];
            col_build[i][0]=buildings[i][0];
            col_build[i][1]=buildings[i][1];
        }

        Arrays.sort(row_build, new Comparator<int []>()
        {
            public int compare(final int x[], final int y[])
            {
                if(x[0]!=y[0])
                    return Integer.compare(x[0],y[0]);
                else
                    return Integer.compare(x[1],y[1]);
            }
        });

        Arrays.sort(col_build, new Comparator<int []>()
        {
            public int compare(final int x[], final int y[])
            {
                if(x[0]!=y[0])
                    return Integer.compare(x[0],y[0]);
                else
                    return Integer.compare(x[1],y[1]);
            }
        });

        Map<Integer,List<Integer>> row = new HashMap<>();
        Map<Integer,List<Integer>> col = new HashMap<>();

        for(int i=0;i<len;i++)
        {
            if(row.containsKey(row_build[i][0]))
                row.get(row_build[i][0]).add(row_build[i][1]);
            else
            {
                List<Integer> list = new ArrayList<>();
                list.add(row_build[i][1]);
                row.put(row_build[i][0],list);
            }

            if(col.containsKey(col_build[i][1]))
                col.get(col_build[i][1]).add(col_build[i][0]);
            else
            {
                List<Integer> list = new ArrayList<>();
                list.add(col_build[i][0]);
                col.put(col_build[i][1],list);
            }
        }

        for(int i=0;i<len;i++)
        {
            int x=buildings[i][0];
            int y=buildings[i][1];

            if(row.get(x).size()>2 && row.get(x).get(0)!=y && row.get(x).get(row.get(x).size()-1)!=y && col.get(y).size()>2 && col.get(y).get(0)!=x && col.get(y).get(col.get(y).size()-1)!=x)
                count++;
        }

        return count;
    }
}