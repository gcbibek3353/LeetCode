class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftBoundary = height[left];
        int rightBoundary = height[right];
        int totalWaterCount = 0;
        while(left < right){
            leftBoundary = Math.max(leftBoundary , height[left]);
            rightBoundary = Math.max(rightBoundary , height[right]);
            // System.out.printf("%d , %d , %d , %d \n", left , right , leftBoundary , rightBoundary);
            if(leftBoundary <= rightBoundary){
                totalWaterCount += Math.min(leftBoundary , rightBoundary) - height[left];
                left ++;
            }
            else{
                totalWaterCount += Math.min(leftBoundary , rightBoundary) - height[right];
                right --; 
            }
        }
        return totalWaterCount;
    }
}