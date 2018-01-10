import java.io.*;
import java.util.*;

public class Solution {

final static private char OPEN_CURL = '{';
final static private char END_CURL = '}';

final static private char OPEN_PAREN = '(';
final static private char END_PAREN = ')';

final static private char OPEN_SQUARE = '[';
final static private char END_SQUARE = ']';

  public static boolean isBalanced(String expression) {

        if(expression == null || expression.trim().isEmpty()){
            return true;
        }

        Stack<Character> stack = new Stack<Character>();

        for(int index = 0; index < expression.length(); ++index){

            char bracket = expression.charAt(index);

            if( isBracketOpen(bracket) ){
                stack.push(bracket);
            }else if( !stack.empty() ){
                if( !matchesBracket(stack.pop(), bracket) ){
                    return false;
                  }
            }else{
                return false;
            }
        }

        return stack.empty();
    }


   public static boolean isBracketOpen(char ch){
      return ch == OPEN_CURL || ch == OPEN_PAREN || ch == OPEN_SQUARE;
    }

   public static boolean matchesBracket(char open, char close){
      if(open == OPEN_CURL)
        return close == END_CURL;

      if(open == OPEN_PAREN)
        return close == END_PAREN;

      if(open == OPEN_SQUARE)
        return close == END_SQUARE;

      return false;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
