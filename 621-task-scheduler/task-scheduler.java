class Solution {
    public int leastInterval(char[] tasks, int n) {
        class Task{
            int freq;
            int waitTime;
            public Task(int freq , int waitTime){
                this.freq = freq;
                this.waitTime = waitTime;
            }
        }
        Queue<Integer> maxHeap = new PriorityQueue<>((a , b) -> b - a);
        Queue<Task> waitingQueue = new LinkedList<>();

        int[] freq = new int[26];
        for(int i = 0; i < tasks.length; i ++){
            int curCharIndex = tasks[i] - 'A';
            freq[curCharIndex] += 1;
        }

        for(int i = 0; i < freq.length; i ++){
            if(freq[i] > 0) maxHeap.offer(freq[i]);
        }

        int time = 0;
        while(!maxHeap.isEmpty() || !waitingQueue.isEmpty()){
            time ++;
            if(!maxHeap.isEmpty()){
                int topFreq = maxHeap.poll();
                topFreq -= 1;
                if(topFreq > 0) waitingQueue.offer(new Task(topFreq , time + n));
            }

            if(!waitingQueue.isEmpty()){
                Task mostRecentTask = waitingQueue.peek();
                if (mostRecentTask.waitTime == time){
                    waitingQueue.poll();
                    maxHeap.offer(mostRecentTask.freq);
                }
            }
        }
        return time;
    }
}