class Solution {
    public String addBinary(String a, String b) {

        int len_a = a.length();
        int len_b = b.length();

        int len_max = Math.max(len_a,len_b);
        char[] result = new char[len_max];

        char[] addResult = {'0','0'};

        while(len_max-- != 0){

            if(len_a != 0 && len_b != 0){
                addBinary(a.charAt(--len_a), b.charAt(--len_b),addResult[0], addResult);
            }else if(len_a != 0){
                addBinary(a.charAt(--len_a), '0',addResult[0], addResult);
            }else{
                addBinary('0', b.charAt(--len_b),addResult[0], addResult);
            }

            result[len_max] = addResult[1];
        }

        // possible carry at the end
        return addResult[0] == '1' ? "1" + new String(result) : new String(result);
    }


    public void addBinary(char a, char b, char carry, char[] result){

        int sum = a + b + carry;

        if(sum == 144){
            // 0,0,0 result is 00
            result[0] = '0';
            result[1] = '0';

        }else if(sum == 145){
            // 1,0,0 (in any order) result is 01
            result[0] = '0';
            result[1] = '1';

        }else if(sum == 146){
            // 1,1,0 (in any order) result is 10
            result[0] = '1';
            result[1] = '0';

        }else{
            // 1,1,1 result is 11
            result[0] = '1';
            result[1] = '1';
        }
    }
}
