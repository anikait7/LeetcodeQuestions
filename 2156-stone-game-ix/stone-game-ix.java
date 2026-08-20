class Solution 
{
    // public boolean recursive(int arr[], int sum, boolean aliceTurn)
    // {
    //     //sum shouldnt be divisible by 3
    //     if(sum%3==0)
    //         return aliceTurn;
        
    //     //since sum isnt divisible by 3 alice will still loose if no stones are left
    //     if(arr[1]==0 && arr[2]==0)
    //     {
    //         return !aliceTurn;
    //     }

    //     //i have three options for alice choose the best and want the best case that is true
    //     if(aliceTurn)
    //     {
    //         boolean flag=false;

    //         for(int i=0;i<3;i++)
    //         {
    //             if(arr[i]>0)
    //             {
    //                 arr[i]--;
    //                 flag|=recursive(arr,(sum+i)%3,!aliceTurn);
    //                 arr[i]++;
    //             }
    //         }

    //         return flag;
    //     }
    //     else    //i have three options for bob and want to choose that makes alice in worse position
    //     {
    //         for(int i=0;i<3;i++)
    //         {
    //             if(arr[i]>0)
    //             {
    //                 arr[i]--;
    //                 boolean flag=recursive(arr,(sum+i)%3,!aliceTurn);
    //                 arr[i]++;

    //                 if(!flag)
    //                     return false;
    //             }
    //         }

    //         return true;
    //     }     
    // }

    public boolean stoneGameIX(int[] stones) 
    {
        int arr[] = new int[3];
        //store remaineder

        for(int i : stones)
            arr[i%3]++;

        arr[0]%=2;
        // even no of 0 -> you will go in the same state
        //  odd no of 0 -> state will change

        //Alice will always start the game
        //Alice should pick stone 1 or stone 2 at the start

        // boolean flag=false;

        // for(int i=1;i<3;i++)
        // {
        //     if(arr[i]>0)
        //     {
        //         arr[i]--;
        //         flag|=recursive(arr,(i)%3,false);
        //         arr[i]++;
        //     }
        // }
        
        // return flag;      

        if(arr[0]==0)
        {
            if((arr[1]>=1 && arr[2]>=1) && (arr[2]>=arr[1] || arr[1]>=arr[2]))
                return true;
        }
        else
        {
            if(Math.abs(arr[1]-arr[2])>=3)
                return true;
        }

        return false;
    }
}