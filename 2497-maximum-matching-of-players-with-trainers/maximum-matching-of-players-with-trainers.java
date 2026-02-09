class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int t = 0;
        int p = 0;
        while(t < trainers.length && p < players.length) {
            if(trainers[t] >= players[p]) p ++;
            t ++;
        }
        return p;
    }
}