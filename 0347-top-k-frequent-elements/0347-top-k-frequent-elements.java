import java.util.Comparator;
import java.util.PriorityQueue;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> hmap = new HashMap<>();
        for(int i =0; i<nums.length;i++) {
           if(hmap.get(nums[i])!=null) {
            hmap.put(nums[i], hmap.get(nums[i])+1);
           }
           else {
           hmap.put(nums[i], 1);
           }
        }
         PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> hmap.get(n2)- hmap.get(n1));
         queue.addAll(hmap.keySet());

         int [] result = new int[k];

         for(int i=0;i<k;i++) {
             result[i] = queue.poll();
         }
        
        return result;
    }
}