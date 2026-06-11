class TimeMap {

    // key -> list of (value, timestamp) pairs
    private Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    // O(1) amotized
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair<>(value, timestamp));
    }
    
    // O(log n) using binary search, n is the number of values stored for that key
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair<String, Integer>> list = map.get(key);

        int left = 0;
        int right = list.size() - 1;
        String ans = "";

        // Binary search for rightmost valid timestamp
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).getValue() <= timestamp) {
                // valid candidate, try to find a later one
                ans = list.get(mid).getKey();
                left = mid + 1;
            } else {
                // too large time, go left
                right = mid - 1;
            }
        }

        return ans;
    }
}
