class Solution {
    public int[] constructTransformedArray(int[] nums) {


        int [] result = new int[nums.length];
        

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {

                int pos = Math.floorMod(i + nums[i], nums.length);
                result[i] = nums[pos];
            }

            else if (nums[i] < 0) {

                int pos = Math.floorMod(i + nums[i], nums.length);
                result[i] = nums[pos];
            }

            else {
                result[i] = nums[i];
            }
        }

        return result;
    }

        
    }