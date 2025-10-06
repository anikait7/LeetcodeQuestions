class MovieRentingSystem 
{
    Map<List<Integer>,Integer> map = new HashMap<>();   // (shop+movie) -> cost
    Map<Integer,TreeSet<List<Integer>>> data = new HashMap<>(); // movie -> (shop+cost)

    TreeSet<List<Integer>> rented = new TreeSet<>((x,y) -> {       //shop + movie + price
                    if(!x.get(2).equals(y.get(2)))
                        return x.get(2)-y.get(2);
                    if(!x.get(0).equals(y.get(0)))
                        return x.get(0)-y.get(0);
                    else
                        return x.get(1)-y.get(1);
                });

    public MovieRentingSystem(int n, int[][] entries) 
    {
        for(int a[] : entries)
        {
            List<Integer> key = new ArrayList<>();
            key.add(a[0]);      key.add(a[1]);
            map.put(key,a[2]);  // (shop+movie) -> cost

            if(data.containsKey(a[1]))
            {
                List<Integer> temp = new ArrayList<>();
                temp.add(a[0]);      temp.add(a[2]);
                data.get(a[1]).add(temp);  // movie -> (shop+cost)      
            }
            else
            {
                TreeSet<List<Integer>> p = new TreeSet<>((x,y) -> {
                    if(!x.get(1).equals(y.get(1)))
                        return x.get(1)-y.get(1);
                    else
                        return x.get(0)-y.get(0);
                });

                data.put(a[1],p);
                List<Integer> temp = new ArrayList<>();
                temp.add(a[0]);      temp.add(a[2]);
                data.get(a[1]).add(temp);  // movie -> (shop+cost)
            }
        }
    }
    
    public List<Integer> search(int movie) 
    {
        List<Integer> result = new ArrayList<>();
        if(!data.containsKey(movie))
            return result;

        int c=0;
        for(List<Integer> a : data.get(movie))
        {
            if(c>=5)
                break;

            result.add(a.get(0));
            c++;
        }

        return result;
    }
    
    public void rent(int shop, int movie) 
    {
        List<Integer> temp = new ArrayList<>();
        temp.add(shop);
        temp.add(movie);

        int x = map.get(temp);

        List<Integer> temp1 = new ArrayList<>(); 
        temp1.add(shop);      temp1.add(x);

        data.get(movie).remove(temp1);
        
        List<Integer> adds = new ArrayList<>();
        adds.add(shop);    adds.add(movie);   adds.add(x);

        rented.add(adds);
    }
    
    public void drop(int shop, int movie) 
    {
        List<Integer> temp = new ArrayList<>();
        temp.add(shop);
        temp.add(movie);

        int x = map.get(temp);

        List<Integer> temp1 = new ArrayList<>(); 
        temp1.add(shop);    temp1.add(movie);    temp1.add(x);

        rented.remove(temp1);
        
        List<Integer> adds = new ArrayList<>();
        adds.add(shop);     adds.add(x);

        data.get(movie).add(adds);  
    }
    
    public List<List<Integer>> report() 
    {
        List<List<Integer>> list = new ArrayList<>();
        int c=0;

        for(List<Integer> a : rented)
        {
            if(c>=5)
                break;

            List<Integer> ans = new ArrayList<>();
            ans.add(a.get(0));  ans.add(a.get(1));
            list.add(ans);
            c++;
        }       

        return list;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */