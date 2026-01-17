class Solution 
{
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) 
    {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int area=1;
        List<List<Integer>> row = new ArrayList<>();
        List<List<Integer>> col = new ArrayList<>();

        int start_x=1;      int start_y=1;
        int end_x=2;        int end_y=2;

        for(int i=0;i<hBars.length;i++)
        {
            if(hBars[i]==end_x)
                end_x++;
            else
            {
                boolean flag=true;
                if(start_x+1==end_x)
                    flag=false;

                if(flag)
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(start_x);   temp.add(end_x);
                    row.add(temp);
                }

                start_x=hBars[i]-1;
                end_x=start_x+2;
            }
        }

        List<Integer> temp1 = new ArrayList<>();
        temp1.add(start_x);      temp1.add(end_x);
        row.add(temp1);

        for(int i=0;i<vBars.length;i++)
        {
            if(vBars[i]==end_y)
                end_y++;
            else
            {
                boolean flag=true;
                if(start_y+1==end_y)
                    flag=false;

                if(flag)
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(start_y);       temp.add(end_y);
                    col.add(temp);
                }
                
                start_y=vBars[i]-1;
                end_y=start_y+2;
            }
        }        

        temp1 = new ArrayList<>();
        temp1.add(start_y);    temp1.add(end_y);
        col.add(temp1);

        for(int i=0;i<row.size();i++)
        {
            int size = row.get(i).get(1)-row.get(i).get(0);

            for(int j=0;j<col.size();j++)
            {
                int size1 = col.get(j).get(1)-col.get(j).get(0);

                int min = Math.min(size,size1);
                area=Math.max(area,min*min);
            }
        }

        return area;
    }
}