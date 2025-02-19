class Solution {
    public int reversePairs(int[] nums) {
        int low =0;
        int high = nums.length-1;  
        return mergeSort(nums, low, high);
    }

    public int mergeSort(int nums[], int low, int high) {

        int cnt =0;
        if(low<high) {
            int mid = (low + high)/2;
            cnt+=mergeSort(nums, low, mid);
            cnt+=mergeSort(nums, mid+1, high);
            cnt+= reversePairsCount(nums, low, mid, high);
            merge(nums, low, mid, high);
        }
        return cnt;
    }

    public int reversePairsCount(int[] nums, int low, int mid, int high) {

        int count =0;
        int right = mid+1;
        for(int i = low; i<=mid;i++) {
            while(right<=high && nums[i]> 2L*nums[right]) {
                right++;
            }
            count+= right-(mid+1);

        }
        return count;
    }


    public void merge(int[] nums , int low , int mid , int high) {

        int left = low; 
        int right = mid+1;
        List<Integer> temp = new ArrayList<>();

        while(left<=mid && right<=high) {

            if(nums[left]<=nums[right]) {

                temp.add(nums[left]);
                left++;
            }
            else {
                //arr[left]> arr[right]
                temp.add(nums[right]);
                right++;
            }
        }

        while(left<=mid) {
                temp.add(nums[left]);
                left++;
            }

        while(right<=high) {
                temp.add(nums[right]);
                right++;
            }
        for(int i = low; i<=high;i++) {
            nums[i] = temp.get(i-low);
        }
    }
}