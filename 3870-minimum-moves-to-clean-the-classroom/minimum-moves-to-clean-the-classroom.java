class BFS
{
    int x;    int y;    int energy;    int litter;

    BFS(int x, int y, int energy, int litter)
    {
        this.x=x;        
        this.y=y;        
        this.energy=energy;        
        this.litter=litter;
    }
}

class Solution 
{
    public int minMoves(String[] classroom, int energy) 
    {
        /*
            This question is a based on bfs. Its not a normal bfs.
            Generally in bfs -> visit a cell, mark it as visited, push the adjacent cell in queue. We generally have x,y and score/chances_left/... parameter.
            
            In this question -> x,y,energy,litters are needed to check if i have visited the cell with a similar state or not
                                litters -> this is a problem. We can choose two different paths to reach the same litter and still it will be marked as visited which shouldnt be done. 
                                eg. There are three litters. You have picked litter 0 and litter 1 making litter left as 2 but the path is different hence we need a method to find which litter has been picked to prevent confusion.
                                Here bit-masking will help. Assign every litter starting from 1 ... n. Whenever you encounter a litter use litter | 1<< (unique value given to the litter)
                                Once the number becomes 111111.... return the count;
        */

        int r = classroom.length;
        int c = classroom[0].length();

        Map<Integer,Integer> map = new HashMap<>();

        int count=0; //litter count in the whole matrix
        int xi=-1;   int yi=-1;   //start position

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(classroom[i].charAt(j)=='L')                
                    map.put(i*25+j,count++);     //i*25+j -> unique key will be generated as max of i and j can be 20

                if(classroom[i].charAt(j)=='S') //entry point of my bfs
                {
                    xi=i;    yi=j;
                }
            }
        }

        if(count==0) //litter has already been cleaned
            return 0;

        Queue<BFS> queue = new LinkedList<>(); //queue with custom variable

        BFS xyz = new BFS(xi,yi,energy,0);
        queue.add(xyz);

        int cost=0;
        int find = (int)Math.pow(2,count)-1; //suppose litter count is 3 total 7=(111)2 111-> all litters collected

        boolean visited[][][][] = new boolean[r][c][energy+1][find+1];

        while(!queue.isEmpty())
        {
            int size = queue.size();
            System.out.print(cost);

            for(int i=1;i<=size;i++)
            {
                BFS temp = queue.poll();

                if(temp.litter==find) //all litters collected
                    return cost-1;

                if(temp.energy==-1) //no energy hence cant continue why not 0-> because there might be a possibility that my energy gets refilled if I land on R
                    continue;

                int x = temp.x;
                int y = temp.y;
                int new_energy=temp.energy;
                int litter=temp.litter;

                if(visited[x][y][new_energy][litter])
                    continue;

                visited[x][y][new_energy][litter]=true;

                char ch = classroom[x].charAt(y);
                if(ch=='X') //blocked route
                    continue;
                
                if(ch=='R')
                    new_energy=energy;

                if(ch=='L') //setting the litter bit
                {
                    int abc = map.get(x*25+y);
                    litter|=1<<abc;
                }

                if(x+1<r)
                {
                    xyz = new BFS(x+1,y,new_energy-1,litter);
                    queue.add(xyz);
                }

                if(x-1>=0)
                {
                    xyz = new BFS(x-1,y,new_energy-1,litter);
                    queue.add(xyz);
                }

                if(y+1<c)
                {
                    xyz = new BFS(x,y+1,new_energy-1,litter);
                    queue.add(xyz);
                }

                if(y-1>=0)
                {
                    xyz = new BFS(x,y-1,new_energy-1,litter);
                    queue.add(xyz);
                }
            }

            cost++;
        }

        return -1;
    }
}