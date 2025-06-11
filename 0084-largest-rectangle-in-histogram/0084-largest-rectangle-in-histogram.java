class Solution {
    public int largestRectangleArea(int[] heights) {

        int area =0;
        Stack<Integer> stack = new Stack<>();
        int length = heights.length;

        for(int i =0; i< heights.length; i++) {

            while(!stack.isEmpty() && heights[i]< heights[stack.peek()]) {

                int popped = stack.pop();

                int psc = stack.isEmpty()? -1: stack.peek();

                int nsc = i;

                area = Math.max(area, heights[popped]*(nsc- psc -1));

            }

           stack.push(i);

        }

        while(!stack.isEmpty()) {
             int popped = stack.pop();

                int psc = stack.isEmpty()? -1: stack.peek();

                int nsc = length;

                area = Math.max(area, heights[popped]*(nsc- psc -1));

        }

        return area;

        


    }
}