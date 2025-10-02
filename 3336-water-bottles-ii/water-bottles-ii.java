class Solution 
{
    public int maxBottlesDrunk(int numBottles, int numExchange) 
    {
        int empty=0;
        int count=0;

        while(true)
        {
            count+=numBottles;
            empty+=numBottles;
            numBottles=0;

            if(empty>=numExchange)
            {
                empty-=numExchange;
                numBottles++;
                numExchange++;
            }
            else
                break;
        }

        return count;
    }
}