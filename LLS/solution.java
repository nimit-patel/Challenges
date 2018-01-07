class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Common cases
        if(s == null || s == ""){
            return 0;
        }
        
        if(s.length() == 1){
            return 1;
        }
        
        int max = 0;
        HashSet<Character> uChars = new HashSet<Character>();
        char matchedChar = ' ';
        
        for(int i = 0; i < s.length() && max < (s.length() - i + uChars.size()); ++i){ 
                if(!uChars.add(s.charAt(i))){
                    max = Math.max(max, uChars.size()); 
                    int startIndex = i - uChars.size();
                    int indexOfChar = s.indexOf(s.charAt(i), startIndex); // first occurence of this char
                    
                    for(;startIndex <= indexOfChar; ++startIndex){ // removal of all extra chars
                        uChars.remove(s.charAt(startIndex)); 
                    }
                    uChars.add(s.charAt(i)); // adding this matched char to the set
                }         
        }
        
         // important to store max in case the inner loop reaches end of the string
        max = Math.max(max, uChars.size());     
        
        return max;
    }
}