class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // min-heap of size k


//min heap -> until k keep adding element, index, once it hits k , check if the current element 
// is greater than than min element in the heap, if yes, pop the top element and add the current element (it will get rearranged accordingly if necessary)
    for (int i = 0; i < nums.length; i++) {
        if (pq.size() < k) {
            pq.offer(new int[]{nums[i], i});
        } else if (nums[i] > pq.peek()[0]) {
            pq.poll();
            pq.offer(new int[]{nums[i], i});
        }
    }
    List<int[]> result = new ArrayList<>(pq);
    //sort by index
    result.sort(Comparator.comparingInt(a -> a[1]));
// give the result
    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
        res[i] = result.get(i)[0];
    }
    return res;
}
    }