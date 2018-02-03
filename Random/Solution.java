class Solution {
    public int minSteps(int n) {

        if(n == 1)
            return 0;

        // first step for n > 2 always is to c & p and so len is intially 2
        int steps = 2;
        int len = 2;
        int lastCopied = 1;

        while(len <= n/2){
            // after half the length is passed there will be no copy and paste at all
            if(n % len == 0){
                ++steps;         // copy
                lastCopied = len;
            }

            len += lastCopied;
             ++steps;           // something is always done (paste)
        }

        // final calculation
        return steps + (n-len)/lastCopied;

    }
}
