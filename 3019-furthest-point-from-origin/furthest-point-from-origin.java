class Solution 
{
    public int furthestDistanceFromOrigin(String moves) 
    {
        int count=0;
        int blank=0;

        for(int i=0;i<moves.length();i++)
        {
            if(moves.charAt(i)=='_')
                blank++;
            else
            if(moves.charAt(i)=='L')
                count--;
            else
                count++;
        }

        if(count>=0)
            return blank+count;
        else
            return blank+count*-1;
    }
}