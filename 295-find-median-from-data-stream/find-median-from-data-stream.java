class MedianFinder {

    List<Integer> dataStore;

    public MedianFinder() {
        dataStore = new ArrayList<>();
    }

    public void addNum(int num) {
        int index = findInsertIndex(num);
        dataStore.add(index, num);
    }

    private int findInsertIndex(int target) {
        int l = 0;
        int r = dataStore.size() - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (dataStore.get(m) == target)
                return m;
            else if (dataStore.get(m) < target)
                l = m + 1;
            else
                r = m - 1;
        }

        return l;
    }

    public double findMedian() {
        int n = dataStore.size();

        if (n % 2 == 1)
            return dataStore.get(n / 2);

        return ((double) dataStore.get(n / 2 - 1)
                + dataStore.get(n / 2)) / 2.0;
    }
}