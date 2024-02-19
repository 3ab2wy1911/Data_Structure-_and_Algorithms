package Plus_One;
//LeetCode : 66. Plus One
class Solution {
    public int[] plusOne(int[] digits) {
        boolean flag;
        for(int i = digits.length-1;i>=0;i--){
            flag = digits[i] == 9;
            digits[i]++;
            digits[i] %= 10;
            if(!flag)   break;
        }
        int cnt = 0;
        if (digits[0] == 0)
            cnt++;
        int[] result = new int [digits.length + cnt];
        result [0] = 1;
        System.arraycopy(digits, 0, result, cnt, digits.length);
        if(cnt == 1)    digits[0] = 1;
        return result;
    }
}
