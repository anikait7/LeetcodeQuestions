class Solution 
{
    public int finalValueAfterOperations(String[] operations) 
    {
        int x=0;

        for(String st : operations)
        {
            if(st.indexOf("--")!=-1)
                x--;
            else
                x++;
        }

        return x;
    }
}