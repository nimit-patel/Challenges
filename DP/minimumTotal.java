// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
public int minimumTotal(List<List<Integer>> triangle) {
        
        int[] dp = new int[triangle.size() + 1];
        
        for(int i = triangle.size() - 1; i >= 0; --i){
            for(int j = 0, index = 0; j < triangle.get(i).size(); ++j, ++index){
                dp[index] = Math.min(dp[index], dp[index + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
}
