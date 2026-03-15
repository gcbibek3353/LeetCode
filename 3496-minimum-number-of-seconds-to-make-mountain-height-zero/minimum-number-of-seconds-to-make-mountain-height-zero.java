class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long l = 1;
        long r = 0;
        long ans = -1;
        int slowestWorkerTime = 0;
        for(int workTime : workerTimes){
            slowestWorkerTime = Math.max(slowestWorkerTime , workTime);
        }
        r = (long)slowestWorkerTime * (mountainHeight * (long)(mountainHeight + 1)) / 2;

        while(l <= r){
            long mid = l + (r - l) / 2;

            long reducedMountainCount = 0;
            for(int curWorkerTime : workerTimes) {
                long heightReducedByCurrentWorker = (long)(-1.0 + Math.sqrt(1 + 8.0 * (mid / curWorkerTime))) / 2;
                reducedMountainCount += heightReducedByCurrentWorker;
            }
            if(reducedMountainCount >= mountainHeight){
                ans = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return ans;
    }
}