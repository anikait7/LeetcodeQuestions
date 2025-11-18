class Solution 
{
    public boolean isOneBitCharacter(int[] bits) 
    {
        int c=0;

        while(c<bits.length-1)
        {
            if(bits[c]==1)
                c+=2;
            else
                c++;
        }

        if(c==bits.length)
            return false;

        if(bits[c]==1)
            return false;

        return true;
    }
}