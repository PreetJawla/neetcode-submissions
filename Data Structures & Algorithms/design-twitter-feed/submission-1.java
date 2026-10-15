class Twitter {

    class Tweet {
        int userId;
        int tweetId;
        int timestamp;

        Tweet(int userId, int tweetId, int timestamp) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }

    Map<Integer, List<Tweet>> tweetMap;
    Map<Integer, Set<Integer>> followMap;
    int timestamp;
    int sizeOfFeed = 10;
    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet t = new Tweet(userId, tweetId, timestamp++);
        if(!tweetMap.containsKey(userId))
            tweetMap.put(userId, new LinkedList<Tweet>());

        tweetMap.get(userId).add(0, t);
        follow(userId, userId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // Get Followee list and make a top 10 latest tweets lists
        Set<Integer> followees = followMap.get(userId);
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> a.timestamp - b.timestamp);

        if(followees != null) {
            for(int followee : followees) {
                List<Tweet> tweets = tweetMap.get(followee);
                if(tweets == null) continue;
                for(Tweet tweet : tweets) {
                    if(pq.size() < sizeOfFeed) {
                        pq.add(tweet);
                    } else {
                        if(tweet.timestamp <= pq.peek().timestamp) break;
                        pq.add(tweet);
                        pq.poll();
                    }
                }
            }
        }

        List<Integer> feed = new LinkedList<>();
        while(!pq.isEmpty()) {
            feed.add(0, pq.poll().tweetId);
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId))
            followMap.put(followerId, new HashSet<>());

        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId != followeeId && followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */