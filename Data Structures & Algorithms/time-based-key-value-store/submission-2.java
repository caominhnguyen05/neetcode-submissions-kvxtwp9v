class TimeMap {
    private Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair<>(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair<String, Integer>> list = map.get(key);

        int left = 0;
        int right = list.size() - 1;
        String ans = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).getValue() <= timestamp) {
                ans = list.get(mid).getKey();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
