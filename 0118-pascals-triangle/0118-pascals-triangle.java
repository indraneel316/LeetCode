class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(numRows==1) {
            resultList.add(new ArrayList<>(List.of(1)));
        }
        else if(numRows>=1) {
            resultList.add(new ArrayList<>(List.of(1)));
            resultList.add(new ArrayList<>(List.of(1,1)));
            for(int i =2; i<numRows;i++) {
                List<Integer> lastStoredArray = resultList.get(resultList.size()-1);
                List<Integer> newValueArray = new ArrayList<>();
                newValueArray.add(1);
                for(int j =1; j<lastStoredArray.size();j++) {
                    newValueArray.add(lastStoredArray.get(j-1) + lastStoredArray.get(j));
                }
                newValueArray.add(1);
                resultList.add(newValueArray);
            }

        }
             return resultList;
    }

}