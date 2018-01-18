class solution{
    public static int numOfWaysToClimb(int n){

          if(n <= 0)
            return 0;

          if(n == 1)
            return 1;

          if(n == 2)
            return 2;

          if(n == 3)
            return 4;

          return numOfWaysToClimb(n - 1) + numOfWaysToClimb(n - 2) + numOfWaysToClimb(n - 3);
        }
  }
