class Solution {
    public int lengthOfLongestSubstring(String s) {

      int len = s.length();
      Set<Character> set = new HashSet<>();
      int result = 0, start = 0, end = 0;

      /* sliding window :
        abca
        0: a end:1 start:0 max:1
        1: b end:2 start:0 max:2
        2: c end:3 start:0 max:3
        3: a => removes a end: 3 start:1 max:3
        3: a is not in the set so add a. end:4 start:1 max:3
        return max
      */
      while(start < len && end < len){

        if(!set.contains(s.charAt(end))){
          set.add(s.charAt(end++));
          result = Math.max(result, end - start);
        }else{
          set.remove(s.charAt(start++));
        }

      }

      return result;
    }

}
