class Solution 
{
    public char[][] rotateTheBox(char[][] box) 
    {
        int i,j;

        for(i=0;i<box.length;i++)
        {
            int pos=box[0].length-1;
            for(j=box[0].length-1;j>=0;j--)
            {
                if(box[i][j]=='*')
                    pos=j-1;

                if(box[i][j]=='#')
                {
                    box[i][j]='.';
                    box[i][pos]='#';
                    pos--;
                }
            }
        }

        char ans[][] = new char[box[0].length][box.length];

        for(i=0;i<box.length;i++)
        {
            int x=box.length-i-1;
            for(j=0;j<box[0].length;j++)
            {
                ans[j][x]=box[i][j];
            }
        }

        return ans;
    }
}