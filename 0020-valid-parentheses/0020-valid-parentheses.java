class Solution {
    public boolean isValid(String s) {
        

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {

            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else {

                 if(stack.isEmpty())
                    return false;

                    if((c == ')' && stack.peek() != '(') || (c == ']' && stack.peek() != '[') || (c == '}' && stack.peek() != '{')) {
                        return false;
                    }
                    else
                    stack.pop();
            }
            
        }

        if(!stack.isEmpty())
        return false;
     
        return true;
        
    }
}