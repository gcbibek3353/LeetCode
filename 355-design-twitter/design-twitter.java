import java.util.*;

class Twitter {

    static class User {
        int id;
        Set<Integer> followers;
        Set<Integer> following;
        List<Integer> tweets;

        User(int id) {
            this.id = id;
            followers = new HashSet<>();
            following = new HashSet<>();
            tweets = new ArrayList<>();
        }
    }

    static class Tweet {
        int id;
        int userId;

        Tweet(int id, int userId) {
            this.id = id;
            this.userId = userId;
        }
    }

    Map<Integer, User> users;
    List<Tweet> tweets;

    public Twitter() {
        users = new HashMap<>();
        tweets = new ArrayList<>();
    }

    private User getUser(int id) {
        if (!users.containsKey(id)) {
            users.put(id, new User(id));
        }
        return users.get(id);
    }

    public void postTweet(int userId, int tweetId) {
        User user = getUser(userId);

        Tweet tweet = new Tweet(tweetId, userId);
        tweets.add(tweet);

        user.tweets.add(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        User user = getUser(userId);

        Set<Integer> following = user.following;

        for (int i = tweets.size() - 1; i >= 0 && result.size() < 10; i--) {
            Tweet t = tweets.get(i);

            if (t.userId == userId || following.contains(t.userId)) {
                result.add(t.id);
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);

        follower.following.add(followeeId);
        followee.followers.add(followerId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!users.containsKey(followerId) || !users.containsKey(followeeId)) {
            return;
        }

        User follower = users.get(followerId);
        User followee = users.get(followeeId);

        follower.following.remove(followeeId);
        followee.followers.remove(followerId);
    }
}