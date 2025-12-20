class Solution 
{
    public int minDeletionSize(String[] strs) 
    {
        int c=0;
        int max=0;

        for(String st : strs)
            max=Math.max(max,st.length());

        for(int i=0;i<max;i++)
        {
            for(int j=1;j<strs.length;j++)
            {
                if(strs[j].charAt(i)<strs[j-1].charAt(i))
                {
                    c++;
                    break;
                }
            }
        }
        

        return c;
    }
}