class RandomizedSet {
    List<Integer> ds;
    Map<Integer , Integer> mp;
    Random rand;
    public RandomizedSet() {
        ds = new ArrayList<>();
        mp = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(mp.containsKey(val)) return false;
        int curIndex = ds.size();
        ds.add(val);
        mp.put(val , curIndex);
        return true;
    }
    
    public boolean remove(int val) {
        if(!mp.containsKey(val)) return false;
        int removingElmIndex = mp.get(val);
        int lastElm = ds.get(ds.size() - 1);
        // if(ds.size() == 1){
        //     mp.remove(lastElm);
        //     ds.remove(0);
        //     return true;
        // }
        ds.set(removingElmIndex , lastElm);
        mp.put(lastElm , removingElmIndex);

        ds.remove(ds.size() - 1);
        mp.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = rand.nextInt(ds.size());
        return ds.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */