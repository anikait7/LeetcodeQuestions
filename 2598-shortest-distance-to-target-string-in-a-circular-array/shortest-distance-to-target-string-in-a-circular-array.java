class Solution 
{
    public int closestTarget(String[] words, String target, int startIndex) 
    {
        int min=words.length+1;

        for(int i=0;i<words.length;i++)
        {
            if(words[i].equals(target))
            {
                int x = Math.abs(startIndex-i);
                int y = words.length-x;
                min=Math.min(min,Math.min(x,y));
            }
        }

        if(min==words.length+1)
            return -1;
        else
            return min;
    }
}