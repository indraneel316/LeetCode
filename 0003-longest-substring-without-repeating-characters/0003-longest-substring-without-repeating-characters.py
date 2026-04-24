class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        

        character_set = set()
        left =0 
        max_length=0
        
        for right in range(len(s)):
            while(s[right] in character_set):
                character_set.remove(s[left])
                left+=1
            character_set.add(s[right])
            
            current_size = right-left+1

            max_length = max(current_size, max_length)


        return max_length



         










        