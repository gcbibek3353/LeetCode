class Solution {

    class Task {
        int freq;
        int time;

        Task(int freq, int time) {
            this.freq = freq;
            this.time = time;
        }
    }

    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int f : freq) {
            if (f > 0) pq.offer(f);
        }

        Queue<Task> q = new LinkedList<>();
        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {

            time++;

            if (!pq.isEmpty()) {
                int f = pq.poll() - 1;

                if (f > 0) {
                    q.offer(new Task(f, time + n));
                }
            }

            if (!q.isEmpty() && q.peek().time == time) {
                pq.offer(q.poll().freq);
            }
        }

        return time;
    }
}