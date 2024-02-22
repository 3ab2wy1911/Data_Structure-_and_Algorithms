package Valid_Parentheses;

import java.util.Stack;

class Solution {
    // LeetCode : 20. Valid Parentheses
    public boolean isSame(char o, char c){
        return (o == '(' && c == ')') || (o == '[' && c ==']') || (o == '{' && c == '}');
    }
    public boolean isValid(String s) {
        Stack<Character> p = new Stack<>();
        for(char c : s.toCharArray()){
            if(!p.empty() && isSame(p.peek(), c))  p.pop();
            else  p.push(c);
        }
        return p.empty();
    }
}