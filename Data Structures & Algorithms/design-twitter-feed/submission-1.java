class Twitter {
    // Map userId -> set of userIDs this user follows
    private Map<Integer, Set<Integer>> followMap;

    // Map userId -> list of at most 10 most recent tweets
    private Map<Integer, List<int[]>> tweetMap;
    private int time;

    public Twitter() {
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
        this.time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }
        time++;
        tweetMap.get(userId).add(new int[]{tweetId, time});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // Get the set of users this user follows
        Set<Integer> followingSet = followMap.getOrDefault(userId, new HashSet<>());

        Set<Integer> allRelevantUsers = new HashSet<>(followingSet);
        allRelevantUsers.add(userId);

        PriorityQueue<int[]> tweetQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        // Collect recent tweets from all relevant users
        for (int currentUserId : allRelevantUsers) {
            List<int[]> currentUserTweets = tweetMap.get(currentUserId);

            if (currentUserTweets != null) {
                int tweetsToAdd = Math.min(10, currentUserTweets.size());

                for (int i = currentUserTweets.size() - 1; i >= currentUserTweets.size() - tweetsToAdd; i--) {
                    tweetQueue.add(currentUserTweets.get(i));
                }
            }
        }

        // Extract top 10 tweets from the PQ
        List<Integer> newsFeed = new ArrayList<>();
        while (!tweetQueue.isEmpty() && newsFeed.size() < 10) {
            newsFeed.add(tweetQueue.poll()[0]);
        }

        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
