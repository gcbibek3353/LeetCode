class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] NSE = NSE(heights);
        int[] PSE = PSE(heights);

        // for(int i = 0; i < heights.length; i ++)System.out.print(NSE[i] + " ");
        // System.out.println();
        // for(int i = 0; i < heights.length; i ++)System.out.print(PSE[i] + " ");
        
        int maxArea = 0;
        for(int i = 0; i < heights.length; i ++) {
            int width = NSE[i] - PSE[i] - 1;
            int curArea = width * heights[i];
            // System.out.print(maxArea);
            maxArea = Math.max(maxArea , curArea);
        }
        return maxArea;
    }
    private int[] NSE(int[] heights) {
        int[] ans = new int[heights.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
    
        for(int i = 0; i < heights.length; i ++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int prevIndex = stack.pop();
                ans[prevIndex] = i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            ans[stack.pop()] = heights.length;
        }
        return ans;
    }

    private int[] PSE(int[] heights) {
        int[] ans = new int[heights.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
    
        for(int i = heights.length - 1; i >= 0; i --){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int prevIndex = stack.pop();
                ans[prevIndex] = i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }
        return ans;
    }

}