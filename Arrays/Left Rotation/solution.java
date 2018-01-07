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

        if(steps > 0){
            if( 2*k == n){ // pairwise swaps only when steps are exactly half of the size
                for(int i = 0; i < (n / 2); ++i){
                    int temp = a[i];
                    a[i] = a[i + steps];
                    a[i + steps] = temp;
                }
            }else {
                int counter = 0;
                int startIndex = 0;
                int tempVal = a[startIndex];
                int index = 0;
                int tempIndex = 0;
                int nextTemp = 0;

                    while(counter != n){ // exactly n iterations for rotation
                        index = startIndex - steps;
                        tempIndex = index < 0 ? index + n : index;
                        nextTemp = a[tempIndex];
                        a[tempIndex] = tempVal;
                        startIndex = tempIndex;
                        tempVal = nextTemp;
                        ++counter;
                    }
                }
        }

        for(int i = 0; i < a.length - 1; ++i){
            System.out.print(a[i] + " ");
        }
        System.out.print(a[a.length - 1]);
    }
}
