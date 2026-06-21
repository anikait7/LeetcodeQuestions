class Solution 
{
    public int maxIceCream(int[] costs, int coins) 
    {
        /*

        Arrays.sort(costs);
        int count=0;
        int i=0;

        while(i<costs.length && coins>=costs[i])
        {
            coins-=costs[i++];
            count++;
        }

        return count;

        */

        //counting sort -> frequency sort best when n<=10^5.
        //                 find highest, create array till highest+1 and start deducting value from coins

        int count=0;

        //maximum of all elements
        int max=costs[0];
        for(int cost : costs)
            max=Math.max(max,cost);

        //frequency of array
        int freq[] = new int[max+1];
        for(int cost:costs)
            freq[cost]++;

        //calculating count till coins exhaust
        for(int i=1;i<=max;i++)
        {
            if(i>coins)
                break;

            if(freq[i]==0)
                continue;

            if(coins>=i*freq[i])
            {
                count+=freq[i];
                coins-=i*freq[i];
            }
            else
            {
                count+=coins/i;
                break;
            }
        }
        
        return count;
    }
}