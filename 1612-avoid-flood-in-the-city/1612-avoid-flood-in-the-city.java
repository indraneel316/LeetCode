class Solution {
    public int[] avoidFlood(int[] rains) {

        int ans[] = new int[rains.length];

        Map<Integer, Integer> fullLakes = new HashMap<>();

        TreeSet<Integer> dryLakes = new TreeSet<>();


        for(int i=0; i < rains.length; i++) {

            if(rains[i]==0) {

                dryLakes.add(i);
                ans[i] = 1;
            }

            else {

                int lake = rains[i];

                ans[i] =-1;

                if(fullLakes.containsKey(lake)) {

                    Integer dryDay = dryLakes.higher(fullLakes.get(lake));

                    if(dryDay == null) {
                        return new int[0];
                    }

                    ans[dryDay] = lake;

                    dryLakes.remove(dryDay);


                }

                fullLakes.put(lake, i);

            }

        }       
        return ans; 
    }
}