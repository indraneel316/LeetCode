class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, new Comparator<>() {
            public int compare(int a[], int b[]) {
                return a[0]-b[0];
            }
        }); // [1,3] [2,4], [2,6]
        List<List<Integer>> ans = new ArrayList<>();

        for(int i =0; i<intervals.length; i++) {

            if(ans.isEmpty() || ans.get(ans.size()-1).get(1)< intervals[i][0]) {
                List<Integer> result = new ArrayList<>();
                result.add(intervals[i][0]);
                result.add(intervals[i][1]);
                ans.add(result);

            }
            else {
                List<Integer> result = new ArrayList<>();
                result.add(ans.get(ans.size()-1).get(0));
                result.add(Math.max(intervals[i][1], ans.get(ans.size()-1).get(1)));
                ans.set(ans.size()-1, result);
            }
        }
        int rowSize = ans.size();
        int [][] finalResult = new int[rowSize][2];
        int pointer = 0;
        for(List<Integer> num: ans) {
            finalResult[pointer][0] =num.get(0); 
            finalResult[pointer][1] =num.get(1); 
            pointer++;

        }
          return finalResult;


    }
}