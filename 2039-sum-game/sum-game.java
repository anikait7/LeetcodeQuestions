class Solution 
{
    public boolean sumGame(String num) 
    {
        int n = num.length();

        int left_sum=0;
        int left_quest=0;
        for(int i=0;i<n/2;i++)
        {
            char ch = num.charAt(i);
            if(ch=='?')
                left_quest++;
            else
                left_sum+=(ch-'0');
        }

        int right_sum=0;
        int right_quest=0;
        for(int i=n/2;i<n;i++)
        {
            char ch = num.charAt(i);
            if(ch=='?')
                right_quest++;
            else
                right_sum+=(ch-'0');
        }

        int total_quest = left_quest-right_quest;

        //Alice will have the differentiator move
        if(total_quest%2==1 || total_quest%2==-1)
            return true;

        //Bob wins
        if(total_quest==0 && left_sum==right_sum)
            return false;

        //Alice wins
        if(total_quest==0 && left_sum!=right_sum)
            return true;

        if(left_sum==right_sum)
        {
            if(left_quest-right_quest==0)
                return false;
            else
                return true;
        }

        int diff = Math.abs(left_quest-right_quest)/2;

        if(left_sum > right_sum)
        {
            if(left_quest > right_quest)
                return true;
            else
            {
                //alice sabotages if he picks 9 to increase the score
                //alice sabotages if he picks 0 to lower the score

                //optimal range is [9 to 18]

                if(right_sum+9*diff==left_sum)
                    return false;
                else
                    return true;
            }
        }
        else //left_sum < right_sum
        {
            if(left_quest > right_quest)
            {
                if(left_sum+9*diff==right_sum)
                    return false;
                else
                    return true;
            }
            else
                return true;
        }
        /*
            case i) left_sum > right_sum
                part a) left_quest is left

                part b) right_quest is left

            case ii) left_sum < right_sum
                part a) left_quest is left

                part b) right_quest is left
        */
    }
}