class Twitter {
    private int time;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        this.time = 0;
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }

        tweetMap.get(userId).add(new int[]{tweetId, time});
        this.time++;

        // Keep the 10 most recent tweets from this user
        if (tweetMap.get(userId).size() > 10) {
            tweetMap.get(userId).remove(0);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // Min heap in timestamp
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // This user's tweets
        if (tweetMap.containsKey(userId)) {
            for (int[] tweet : tweetMap.get(userId)) {
                minHeap.add(tweet);
                if (minHeap.size() > 10) {
                    minHeap.poll();
                }
            }
        }

        // Tweets from users this user follows
        if (followMap.containsKey(userId)) {
            for (int followee : followMap.get(userId)) {
                for (int[] tweet : tweetMap.get(followee)) {
                    minHeap.add(tweet);
                    if (minHeap.size() > 10) {
                        minHeap.poll();
                    }
                }
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            res.addFirst(minHeap.poll()[0]);
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
        }

        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) return;

        followMap.get(followerId).remove(followeeId);
    }
}
