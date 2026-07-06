class TimeMap {
    private Map<String, List<Pair<String, Integer>>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }

        timeMap.get(key).add(new Pair<>(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }

        List<Pair<String, Integer>> timestamps = timeMap.get(key);
        int left = 0;
        int right = timestamps.size() - 1;
        String ans = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (timestamps.get(mid).getValue() <= timestamp) {
                ans = timestamps.get(mid).getKey();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
