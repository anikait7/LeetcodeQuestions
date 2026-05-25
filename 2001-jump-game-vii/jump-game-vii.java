class Solution 
{
    public boolean canReach(String s, int minJump, int maxJump) 
    {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(0);

        int far=0;
        while(!queue.isEmpty())
        {
            int x = queue.poll();

            for(int i=Math.max(far,x+minJump);i<=Math.min(x+maxJump,s.length()-1);i++)
            {
                if(!set.contains(i) && s.charAt(i)=='0')
                {
                    if(i==s.length()-1)
                        return true;

                    set.add(i);
                    queue.add(i);
                }

                far=i;
            }            
        }

        return false;
    }
}