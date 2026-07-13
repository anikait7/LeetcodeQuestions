class Solution 
{
    public List<Integer> sequentialDigits(int low, int high) 
    {
        List<Integer> list = new ArrayList<>();
        String st = "123456789";

        int l = Integer.toString(low).length();
        int r = Integer.toString(high).length();

        for(int i=l;i<=r;i++)
        {
            for(int j=0;j<=9-i;j++)
            {
                int temp = Integer.parseInt(st.substring(j,j+i));
                if(temp>=low && temp<=high)
                    list.add(temp);
            }
        }

        return list;
    }
}