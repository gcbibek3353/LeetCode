class TimeMap {
    static class TimeValueStore{
        int timestamp;
        String value;
        public TimeValueStore(int timestamp , String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    Map<String , ArrayList<TimeValueStore>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        ArrayList<TimeValueStore> curList;
        if(mp.containsKey(key)) curList = mp.get(key);
        else curList = new ArrayList<>();
        curList.add(new TimeValueStore(timestamp , value));
        mp.put(key , curList);
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key)) return "";
        ArrayList<TimeValueStore> curList = mp.get(key);
        if(curList == null) return "";
        
        int l = 0;
        int r = curList.size() - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            TimeValueStore curTimeValueStore = curList.get(m);
            int curTimestamp = curTimeValueStore.timestamp;
            if(curTimestamp == timestamp) return curTimeValueStore.value;
            else if (curTimestamp < timestamp) l = m + 1;
            else r = m - 1;
        }
        if(r >= 0)
    return curList.get(r).value;
    return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */