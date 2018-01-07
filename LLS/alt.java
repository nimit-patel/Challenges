class Solution {
    public int lengthOfLongestSubstring(String s) {

      int result = 0;
      int len = s.length();
      int[] index = new int[128];

      /* Example: "abca"
        j = 0; i = 0; result = 1; index[a] = 1
        j = 1; i = 0; result = 2; index[b] = 2
        j = 2; i = 0; result = 3; index[c] = 3
        j = 3; i = 1; result = 3; index[a] = 4
      */

      for(int j = 0, i = 0; j < n; j++){
        i = Math.max(index[s.charAt(j)], i);
        result = Math.max(result, j - i + 1);
        index[s.charAt(j)] = j + 1;
      }
 
      return result;
    }

}