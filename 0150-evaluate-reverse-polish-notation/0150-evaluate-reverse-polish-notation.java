class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        int res = 0;

        for (String s : tokens) {
            char c = s.charAt(0);  
            if (isInteger(s)) {
                stack.push(Integer.parseInt(s));
            }
        
            else {

                if (stack.size() >=2) {

                    int ele1 = stack.pop();
                    int ele2 = stack.pop();
                    if (c == '/') {
                        res = ele2 / ele1;
                        stack.push(res);
                    }
                    else if (c == '*') {
                        res = ele1 * ele2;
                        stack.push(res);
                    }
                    else if (c == '+') {
                        res = ele1 + ele2;
                        stack.push(res);
                    }
                    else if (c == '-') {
                        res = ele2 - ele1;
                        stack.push(res);
                    }

                }
            }
        }

        return stack.pop();

    }

    public boolean isInteger(String s) {
    try {
        Integer.parseInt(s);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

}