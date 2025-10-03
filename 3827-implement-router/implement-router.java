class Router 
{
    class Pair
    {
        List<Integer> time;
        int head;

        Pair()
        {
            this.time = new ArrayList<>();
            this.head = 0;
        }
    }

    int n;
    Queue<List<Integer>> queue = new LinkedList<>();
    Set<List<Integer>> set = new HashSet<>();
    Map<Integer,Pair> dest = new HashMap<>();

    public Router(int memoryLimit) 
    {
        n = memoryLimit;
    }
    
    public boolean addPacket(int source, int destination, int timestamp) 
    {
        List<Integer> list = new ArrayList<>();
        list.add(source);   list.add(destination);     list.add(timestamp);
        
        if(!set.add(list))
            return false;

        if(queue.size()==n)
            forwardPacket();

        queue.add(list);
        set.add(list);
        dest
            .computeIfAbsent(destination, k-> new Pair())
            .time.add(timestamp);

        return true;
    }
    
    public int[] forwardPacket() 
    {
        if(queue.isEmpty())
            return new int[]{};

        List<Integer> list = queue.poll();
        set.remove(list);
        Pair p = dest.get(list.get(1));
        p.head++;

        return new int[]{list.get(0), list.get(1), list.get(2)};
    }
    
    public int getCount(int destination, int startTime, int endTime) 
    {
        Pair p = dest.get(destination);
        if(p==null)
            return 0;

        return search(p.time,endTime+1,p.head) - search(p.time,startTime,p.head);
    }

    public int search(List<Integer> list, int val, int left)
    {
        int right = list.size()-1;

        while(left<=right)
        {
            int mid = (left+right)/2;
            if(list.get(mid)>=val)
                right=mid-1;
            else
                left=mid+1;
        }

        return left;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */