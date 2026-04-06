class Solution 
{
    public int robotSim(int[] commands, int[][] obstacles) 
    {
        int i,j,direction1=0,x=0,y=0,max=0;
        int direction[][] = {{0,1},{1,0},{0,-1},{-1,0}};

        for(i=0;i<commands.length;i++)
        {
            int prev_x,prev_y;
            int obs_max=-3001,obs_min=3001;

            if(commands[i]==-1)
                direction1=(direction1+1)%4;
            else
            if(commands[i]==-2)
                direction1=(direction1+3)%4;
            else
            {
                prev_x=x;
                prev_y=y;

                x=x+direction[direction1][0]*commands[i];
                y=y+direction[direction1][1]*commands[i];

                if(prev_x==x)
                {
                    for(j=0;j<obstacles.length;j++)
                    {
                        if(x==obstacles[j][0] && ((prev_y<obstacles[j][1] && y>=obstacles[j][1]) || (prev_y>obstacles[j][1] && y<=obstacles[j][1])))
                        {
                            if(obstacles[j][1]<obs_min && direction[direction1][1]==1)
                                obs_min=obstacles[j][1];

                            if(obstacles[j][1]>obs_max && direction[direction1][1]==-1)
                                obs_max=obstacles[j][1];
                        }                        
                    }    
                    if(obs_min!=3001)
                        y=obs_min-1;
                    else
                    if(obs_max!=-3001)
                        y=obs_max+1;                                        
                }
                else
                if(prev_y==y)
                {
                    for(j=0;j<obstacles.length;j++)
                    {
                        if(y==obstacles[j][1] && ((prev_x<obstacles[j][0] && x>=obstacles[j][0] && direction[direction1][0]==1) || (prev_x>obstacles[j][0] && x<=obstacles[j][0] && direction[direction1][0]==-1)))
                        {   
                            if(obstacles[j][0]<obs_min && direction[direction1][0]==1)
                                obs_min=obstacles[j][0];

                            if(obstacles[j][0]>obs_max && direction[direction1][0]==-1)
                                obs_max=obstacles[j][0];
                        }                        
                    }    
                    if(obs_min!=3001)
                        x=obs_min-1;
                    else
                    if(obs_max!=-3001)
                        x=obs_max+1;      
                }                
                if(x*x+y*y>max)
                    max=x*x+y*y;
            }
        }
        return max;
    }
}