class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> store = new HashMap<>();
        for(String str: strs) {
           char [] chars = str.toCharArray();
           Arrays.sort(chars);
           String sorted = String.valueOf(chars);
            
            if(store.containsKey(sorted)) {
                store.get(sorted).add(str);
            }
            else {
                List<String> vals = new ArrayList<>();
                vals.add(str);
                store.put(sorted, vals);
            }
        
        }

        return new ArrayList<>(store.values());


    }
}