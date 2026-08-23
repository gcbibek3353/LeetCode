class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Set<Integer> foundKeys = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        foundKeys.add(0);
        while(!q.isEmpty()) {
            int curQueueSize = q.size();
            for(int i = 0; i < curQueueSize; i ++) {
                int curKey = q.poll();
                List<Integer> curRoomKeys = rooms.get(curKey);
                for(int j = 0; j < curRoomKeys.size(); j ++) {
                    int newCurKey = curRoomKeys.get(j);
                    if(!foundKeys.contains(newCurKey)) {
                        foundKeys.add(newCurKey);
                        q.offer(newCurKey);
                    }
                }
            }
        }
        return foundKeys.size() == n;
    }
}