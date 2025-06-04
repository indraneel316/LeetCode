class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        if (k > s2.length()) return false;

        Map<Character, Integer> store = new HashMap<>();
        for (char c : s1.toCharArray()) {
            store.put(c, store.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, formed = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);

            if (store.containsKey(c)) {
                store.put(c, store.get(c) - 1);
                if (store.get(c) >= 0) {
                    formed++;
                }
            }

            if (right - left + 1 > k) {
                char leftChar = s2.charAt(left);
                if (store.containsKey(leftChar)) {
                    store.put(leftChar, store.get(leftChar) + 1);
                    if (store.get(leftChar) > 0) {
                        formed--;
                    }
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
