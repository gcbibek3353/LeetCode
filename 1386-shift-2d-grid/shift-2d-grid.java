class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int r = grid.length; 
        int c = grid[0].length;
        for(int i = 0; i < r; i ++) ans.add(new ArrayList<>());
        for(int i = 0; i < r; i ++){
            for(int j = 0; j < c; j ++) {
                ans.get(i).add(j,grid[i][j]);
            }
        }

        for(int count = 0; count < k; count ++){

            int[] lastCol = new int[r];
            int lastElm = ans.get(r-1).get(c-1);
            // keeping copy of last column
            for(int i = 0; i < r; i ++){
                lastCol[i] = ans.get(i).get(c - 1);
            }
            // copying over all elements except the first column
            for(int i = c - 1; i > 0; i --) {
                for(int j = 0; j < r; j ++) {
                    int curValue = ans.get(j).get(i - 1);
                    ans.get(j).set(i,curValue);
                }
            }
            // printArrayList(ans.get(0));
            // printArrayList(ans.get(1));
            // printArrayList(ans.get(2));
            // filling first column
            for(int i = r - 1; i > 0; i --) {
                int curValue = lastCol[i - 1];
                ans.get(i).set(0,curValue);
            }
            //
            ans.get(0).set(0,lastElm);
        }

        return ans;
    }

    private void printArray(int[] arr) {
        System.out.print("[");
        for(int i = 0; i < arr.length; i ++){
            System.out.print(arr[i] + ",");
        }
        System.out.println("]");
    }

    private void printArrayList(List<Integer> arr) {
        System.out.print("[");
        for(int i = 0; i < arr.size(); i ++){
            System.out.print(arr.get(i) + ",");
        }
        System.out.println("]");
    }
}