class Twitter {

    private int time;
    private Map<Integer, List<int[]>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        this.time = 0;
        this.tweetMap = new HashMap<>();
        this.followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(new int[]{tweetId, time});
        time++;

        // Keep only the latest 10 tweets
        if (tweetMap.get(userId).size() > 10) {
            tweetMap.get(userId).remove(0);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // Min heap by timestamp
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        // User's own tweets
        if (tweetMap.containsKey(userId)) {
            for (int[] tweet : tweetMap.get(userId)) {
                pq.offer(tweet);
                if (pq.size() > 10) {
                    pq.poll();
                }
            }
        }

        // Followee tweets
        if (followMap.containsKey(userId)) {
            for (int followee : followMap.get(userId)) {
                if (!tweetMap.containsKey(followee)) continue;

                for (int[] tweet : tweetMap.get(followee)) {
                    pq.offer(tweet);
                    if (pq.size() > 10) {
                        pq.poll();
                    }
                }
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.addFirst(pq.poll()[0]);
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            return;
        }

        followMap.get(followerId).remove(followeeId);
    }
}
