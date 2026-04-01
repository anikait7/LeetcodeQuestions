class Solution 
{
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) 
    {
        //index + postition + health
        //(0,5,2,1) (1,4,17,1) , (2,3,9,1) ,(3,2,15,1) (4,1,10,1)
        //after sort
        //(4,1,10,1), (3,2,15,1), (2,3,9,1), (1,4,17,1), (0,5,2,1)

        int len = directions.length();
        int arr[][] = new int[len][4];

        for(int i=0;i<len;i++)
        {
            arr[i][0]=i;
            arr[i][1]=positions[i];
            arr[i][2]=healths[i];
            arr[i][3]=(directions.charAt(i)=='R') ? 1 : -1;
        }
        
        Arrays.sort(arr, (a,b) -> a[1]-b[1]);
        Stack<int []> stack = new Stack<>();

        int i=0;
        while(i<len)
        {
            if(stack.isEmpty())
                stack.add(arr[i]);
            else
            {
                int temp = stack.peek()[3];
                if(!(temp==1 && arr[i][3]==-1))
                    stack.add(arr[i]);
                else
                {
                    while(!stack.isEmpty())
                    {
                        int xyz[] = stack.pop();
                        if(xyz[3]==1 && arr[i][3]==-1)
                        {
                            if(xyz[2]==arr[i][2])
                            {
                                arr[i][2]=0;
                                break;    
                            }                        
                            else
                            if(xyz[2]>arr[i][2])
                            {
                                xyz[2]--;
                                if(xyz[2]!=0)
                                    stack.add(xyz);
                                break;
                            }
                            else
                            {
                                arr[i][2]--;
                                if(arr[i][2]==0)
                                    break;
                            }
                        }
                        else
                        {
                            stack.add(xyz);
                            stack.add(arr[i]);
                            break;
                        }
                    }

                    if(stack.isEmpty() && arr[i][2]>0)
                        stack.push(arr[i]);
                }
            }
            i++;
        }

        List<int[]> temp = new ArrayList<>(stack);
        temp.sort((a,b) -> a[0]-b[0]);

        List<Integer> ans = new ArrayList<>();
        for(int x[] : temp)
            ans.add(x[2]);

        return ans;
    }
}