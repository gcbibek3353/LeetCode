import java.util.*;

class Twitter {

    private static int timeStamp = 0;

    class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
            this.next = null;
        }
    }

    // userId -> head of tweet list
    Map<Integer, Tweet> tweetMap;

    // userId -> set of followees
    Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId);

        // insert at head (like stack)
        newTweet.next = tweetMap.get(userId);
        tweetMap.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        if (!followMap.containsKey(userId)) {
            followMap.put(userId, new HashSet<>());
        }

        // user should follow themselves
        followMap.get(userId).add(userId);

        Set<Integer> followees = followMap.get(userId);

        // max heap based on tweet time
        PriorityQueue<Tweet> maxHeap =
            new PriorityQueue<>((a, b) -> b.time - a.time);

        // add most recent tweet of each followee
        for (int followeeId : followees) {
            Tweet t = tweetMap.get(followeeId);
            if (t != null) {
                maxHeap.offer(t);
            }
        }

        // extract top 10 tweets
        while (!maxHeap.isEmpty() && res.size() < 10) {
            Tweet curr = maxHeap.poll();
            res.add(curr.id);

            // push next tweet from same user
            if (curr.next != null) {
                maxHeap.offer(curr.next);
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap
            .computeIfAbsent(followerId, k -> new HashSet<>())
            .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId) && followeeId != followerId) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}