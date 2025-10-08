class Solution {
    public int triangleNumber(int[] nums) {

        Arrays.sort(nums);

        int i =0;
        int j =1;
      

        int count =0;

        for (int k = nums.length-1; k>=0; k--) {
           count += findTriangles(nums, k);
    
        }
        return count;
        
    }

    public int findTriangles(int [] nums, int index) {

    int i =0;
    int j = index-1;

    int k = index;
    int count=0;

    while(i<k && j>i) {


    if(nums[i] + nums[j] <=nums[k]) {
        i++;
    }

    else {
      count += j - i;
      j--;


    }

            
    }
return count;
    }

}
