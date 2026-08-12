class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> st = new ArrayDeque<>();

        for (int asteroid : asteroids) {

            if (asteroid > 0) {
                st.push(asteroid);
                continue;
            }

            boolean alive = true;

            while (alive && !st.isEmpty() && st.peek() > 0) {

                if (st.peek() < -asteroid) {
                    // Stack asteroid explodes
                    st.pop();
                }
                else if (st.peek() == -asteroid) {
                    // Both explode
                    st.pop();
                    alive = false;
                }
                else {
                    // Incoming asteroid explodes
                    alive = false;
                }
            }

            if (alive) {
                st.push(asteroid);
            }
        }

        int[] ans = new int[st.size()];

        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}