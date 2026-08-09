class Solution 
{
    public int minNumberOperations(int[] target) 
    {
        int count=target[0];
        int ptr=1;

        while(ptr<target.length)
        {
            if(target[ptr]<=target[ptr-1])
                ptr++;
            else
            {
                count+=target[ptr]-target[ptr-1];
                ptr++;
            }
        }

        return count;
    }
}