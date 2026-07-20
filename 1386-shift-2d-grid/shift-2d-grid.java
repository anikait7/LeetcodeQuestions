class Solution 
{
    public List<List<Integer>> shiftGrid(int[][] grid, int k) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        int x = grid.length;    int y = grid[0].length;

        for(int i=0;i<x;i++)
            ans.add(new ArrayList<>());

        List<Integer> temp = new ArrayList<>();
        for(int a[] : grid)
        {
            for(int i : a)
                temp.add(i);
        }

        k%=(x*y);
        int start = temp.size()-k;

        for(int i=0;i<temp.size();i++)
        {
            start%=(x*y);

            int r = i/y;

            ans.get(r).add(temp.get(start++));
        }

        return ans;
    }
}