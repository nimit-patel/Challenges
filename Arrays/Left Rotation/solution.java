public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
       
        int steps = k % n; // avoids identity rotations
        
        if(steps >  0){
            int counter = 0;
            int startIndex = 0;
            int tempVal = a[startIndex];
            int tempIndex = (startIndex - steps) < 0 ? startIndex - steps + n : startIndex - steps;     
            int nextTemp = 0;// start at this index to finds its index
            
            /* 1234 steps: 3
               0123
               
               1134 tempVal:2 nextTemp:0 startIndex: 1 tempIndex: 1
               1124 tempVal:3 nextTemp:3 startIndex: 2 tempIndex: 2
               1123 tempVal:4 nextTemp:4 startIndex: 3 tempIndex: 3
               4123 tempVal:1 nextTemp:1 startIndex: 0 tempIndex: 0
               
            */
            
            while(counter != n){ // exactly n swaps
                
                tempIndex = (startIndex - steps) < 0 ? startIndex - steps + n : startIndex - steps;
                nextTemp = a[tempIndex];
                a[tempIndex] = tempVal;
                startIndex = tempIndex;
                tempVal = nextTemp;
                
                ++counter;
            }
            
        } 
        
        for(int i = 0; i < a.length - 1; ++i){
            System.out.print(a[i] + " ");
        }
        System.out.print(a[a.length - 1]);
    }
}