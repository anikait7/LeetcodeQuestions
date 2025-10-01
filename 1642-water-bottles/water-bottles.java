class Solution 
{
    public int numWaterBottles(int numBottles, int numExchange) 
    {
        int emptyBottles=0,c=0;

        while(true)
        {
            c=c+numBottles;
            emptyBottles=emptyBottles+numBottles;
            numBottles=emptyBottles/numExchange;
            if(numBottles==0)
                break;
            emptyBottles=emptyBottles%numExchange;
        }        
        return c;
    }
}