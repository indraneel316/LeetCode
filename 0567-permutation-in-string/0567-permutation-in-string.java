class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int k = s1.length();

        Map<Character, Integer> store = new HashMap<>();

        for (char c : s1.toCharArray()) {
            store.put(c, store.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int formed = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            if (store.containsKey(c)) {
                 store.put(c, store.get(c) - 1);
                if (store.get(c) >= 0) {
                    formed++;
                }
            }

            if (right - left + 1 > k) {
                if (store.containsKey(s2.charAt(left))) {
                    store.put(s2.charAt(left), store.get(s2.charAt(left)) + 1);
                    if (store.get(s2.charAt(left)) > 0)
                        formed--;
                }
                left++;
            }

            if (formed == k) {
                return true;
            }

            right++;
        }

        return false;

    }
}