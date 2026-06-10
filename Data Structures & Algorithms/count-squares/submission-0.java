class CountSquares {
    
    // x -> (y -> frequency)
    private Map<Integer, Map<Integer, Integer>> points;

    public CountSquares() {
        points = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        points.putIfAbsent(x, new HashMap<>());

        points.get(x).put(y, points.get(x).getOrDefault(y, 0) + 1);
    }
    
    public int count(int[] point) {
        int qx = point[0];
        int qy = point[1];

        if (!points.containsKey(qx)) {
            return 0;
        }

        int ans = 0;

        Map<Integer, Integer> sameColumn = points.get(qx);

        // Iterate through all points sharing query x-coordinate
        for (int y : sameColumn.keySet()) {
            if (y == qy) {
                continue;
            }

            int side = y - qy;

            // right square
            ans += sameColumn.get(y) * getCount(qx + side, qy) * getCount(qx + side, y);

            // left square
            ans += sameColumn.get(y) * getCount(qx - side, qy) * getCount(qx - side, y);
        }

        return ans;
    }

    private int getCount(int x, int y) {
        if (!points.containsKey(x)) {
            return 0;
        }

        return points.get(x).getOrDefault(y, 0);
    }
}
