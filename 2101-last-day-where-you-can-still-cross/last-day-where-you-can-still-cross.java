class Solution 
{
    //Method 1 : Binary search 

    public int find(int n, int arr[])
    {
        if(arr[n]==-1)
            return n;

        return arr[n]=find(arr[n],arr);
    }

    public void union(int x, int y, int arr[])
    {
        int a = find(x,arr);
        int b = find(y,arr);

        if(a!=b)
            arr[a]=b;
    }

    public int latestDayToCross(int row, int col, int[][] cells) 
    {
        int n = row*col;
        int arr[] = new int[n+2];
        int grid[][] = new int[row][col];
        //   0 - water  1 - land

        Arrays.fill(arr,-1);

        for(int i=cells.length-1;i>=0;i--)
        {
            int r = cells[i][0]-1;        int c = cells[i][1]-1;
            grid[r][c]=1;

            int index = r*col+c;

            if(r==0)
                union(index,n,arr);    

            if(r==row-1)
                union(index,n+1,arr);    

            if(r-1>=0 && grid[r-1][c]==1)
                union(index,(r-1)*col+c,arr);            

            if(c-1>=0 && grid[r][c-1]==1)
                union(index,r*col+c-1,arr);

            if(r+1<row && grid[r+1][c]==1)
                union(index,(r+1)*col+c,arr);

            if(c+1<col && grid[r][c+1]==1)
                union(index,r*col+c+1,arr);

            if(find(n,arr) == find(n+1,arr))
                return i;
        }

        return 0;
    }
}