class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                st.push(asteroids[i]);
                continue;
            } else {
                int curAsteroidSize = asteroids[i] * -1;
                boolean isDestroyed = false;
                while (st.size() > 0) {
                    int topAsteroidSize = st.peek();
                    if (topAsteroidSize < 0)
                        break;
                    if (topAsteroidSize < curAsteroidSize)
                        st.pop();
                    else if (topAsteroidSize == curAsteroidSize) {
                        st.pop();
                        isDestroyed = true;
                        break;
                    } else
                        break;
                }
                if (!isDestroyed && (st.size() == 0 || st.peek() < 0))
                    st.push(asteroids[i]);
            }
        }
        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}