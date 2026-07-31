class Solution {
    public int minimumPushes(String word) {
        Map<Character,Integer> mp = new HashMap<>();
        for(char c : word.toCharArray()) {
            mp.put(c,mp.getOrDefault(c,0) + 1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        for(Map.Entry<Character,Integer> entry : mp.entrySet()){
            pq.offer(entry);
        }

        int curPress = 1;
        int charCount = 1;
        int ans = 0;
        System.out.println(mp);
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> topEntry = pq.poll();
            ans += curPress * topEntry.getValue();
            // System.out.printf("char : %c, curpress : %d , val : %d, charCount : %d \n", topEntry.getKey(), curPress , topEntry.getValue(), charCount);
            if(charCount == 8){
                charCount = 0;
                curPress ++;
            }
            charCount ++;
        }
        return ans;
    }
}