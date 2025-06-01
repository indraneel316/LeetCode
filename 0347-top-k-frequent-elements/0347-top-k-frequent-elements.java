class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> hmap = new HashMap<>();

        for(int i=0; i<nums.length;i++) {
            hmap.put(nums[i], hmap.getOrDefault(nums[i],0)+1);
        }

        Queue<Integer>  queue = new PriorityQueue<>((n1,n2) -> hmap.get(n2) - hmap.get(n1));

        queue.addAll(hmap.keySet());

        int result [] = new int[k];
        for(int i =0; i<k; i++) {

            result[i] = queue.poll();
        }

        return result;


    }
}