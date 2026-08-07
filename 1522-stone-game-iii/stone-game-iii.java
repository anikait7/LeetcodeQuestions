class Solution 
{
    int dp[][];

    public int recursive(int stone[], int index, int chance)
    {
        if(index>=stone.length)
            return 0;   

        if(dp[index][chance]!=Integer.MIN_VALUE)
            return dp[index][chance];

        int sum;

        if(chance==1)
            sum=Integer.MIN_VALUE;
        else
            sum=Integer.MAX_VALUE;

        int prefix=0;

        for(int i=index;i<Math.min(index+3,stone.length);i++)
        {
            prefix+=stone[i];
            if(chance==1)
            {
                //choose the best for alice -> BEST CASE = MAX
                sum=Math.max(sum,prefix+recursive(stone,i+1,2));
            }
            else
            {
                //choose the worst for alice -> WORST CASE FOR ALICE = MIN
                sum=Math.min(sum,recursive(stone,i+1,1));
            }
        }

        return dp[index][chance]=sum;
    }

    public String stoneGameIII(int[] stone) 
    {
        dp = new int[stone.length][3];
        for(int i=0;i<stone.length;i++)
            Arrays.fill(dp[i],Integer.MIN_VALUE);

        //Game theory concept -> Alice will do the best and Bob will make things worst for Alice
        //Make everything wrt to ALICE: maximize ALICE chance sum AND minimize what ALICE gets when its BOB's turn

        int SUM=0;
        for(int i : stone)
            SUM+=i;

        //1-> Alice chance  2-> Bob chance
        int AliceSUM = recursive(stone,0,1);

        if(AliceSUM*2==SUM)
            return "Tie";
        else
        if(AliceSUM*2>SUM)
            return "Alice";
        else
            return "Bob";
    }
}