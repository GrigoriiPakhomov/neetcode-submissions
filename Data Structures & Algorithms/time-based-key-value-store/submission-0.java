class TimeMap {
    private Map<String, List<String>> valuesMap;
    private Map<String, List<Integer>> timestampsMap;

    public TimeMap() {
        valuesMap = new HashMap<>();
        timestampsMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        valuesMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        timestampsMap.computeIfAbsent(key, k -> new ArrayList<>()).add(timestamp);
    }

    public String get(String key, int timestamp) {
        if (!valuesMap.containsKey(key)) return "";

        List<Integer> times = timestampsMap.get(key);
        int left = 0;
        int right = times.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (times.get(mid) <= timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right < 0) return "";

        return valuesMap.get(key).get(right);
    }
}