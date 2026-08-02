class Solution 
{
    public boolean recursive(int player1, int player2, int i, int j, int nums[], int turn)
    {
        if(i>j)
        {
            if(player1>=player2)
                return true;
            else
                return false;
        }

        if(turn==1)
        {
            return recursive(player1+nums[i],player2,i+1,j,nums,2) || recursive(player1+nums[j],player2,i,j-1,nums,2);
        }
        else
        {
            return recursive(player1,player2+nums[i],i+1,j,nums,1) && recursive(player1,player2+nums[j],i,j-1,nums,1);
        }
    }

    public boolean predictTheWinner(int[] nums) 
    {
        return recursive(0,0,0,nums.length-1,nums,1);
    }
}